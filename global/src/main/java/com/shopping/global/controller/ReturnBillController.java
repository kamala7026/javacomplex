package com.shopping.global.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.global.bean.NewBillDetailsBean;
import com.shopping.global.bo.BillServiceBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.services.ResponseDTO;

@Controller
public class ReturnBillController {

	@Autowired
	private BillServiceBO billService;


	final static Logger logger = LoggerFactory.getLogger(BillController.class);
	
	@RequestMapping(value=HtmConstants.RETURN_BILL_PAGE,method={RequestMethod.GET,RequestMethod.POST})
	public String redirectToReturnBillPage(Model model) {
		logger.debug("redirectToReturnBillPage :START");
		ResponseDTO response=new ResponseDTO();
		try {
			response=billService.validateAndSearchStockDetails();
			NewBillDetailsBean newBillDetailsBean=new NewBillDetailsBean();
			newBillDetailsBean=prepareNewBillBean(response);
			model.addAttribute("stockList",newBillDetailsBean.getProductQuanityDetailsDTOList());
			model.addAttribute("customerList",newBillDetailsBean.getListofCustomers());
			ListOfProductQuanityDetailsDTO detailsDTo=new ListOfProductQuanityDetailsDTO();
			generateRows(detailsDTo,Constants.numberOfInitialRows);
			model.addAttribute("billItem",detailsDTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("redirectToReturnBillPage :END");
		return "returnBill";
	}
	@RequestMapping(value=HtmConstants.NEW_RETURN_BILL,method={RequestMethod.POST})
	public ModelAndView generateNewReturnBill(Model model, HttpServletRequest request,HttpServletResponse httpResponse,@ModelAttribute("billItem")ListOfProductQuanityDetailsDTO billItem) throws Exception {
		logger.debug("generateNewReturnBill :START");
		ResponseDTO response=new ResponseDTO();
		try {

			response=billService.validateBillItem(billItem);
			model.addAttribute("message",response.getMessage());
			model.addAttribute("billNumber",response.getMessage());
			HttpSession session=request.getSession();
			session.setAttribute("billNumber",response.getMessage());
			billItem.setBillNumber(response.getMessage());
			session.setAttribute("billItem",billItem);
			model.addAttribute("status",Constants.SUCCESS);
			model.addAttribute("searchHappen","true");
		} catch (Exception e) {
			model.addAttribute("status",response.getStatus());
			model.addAttribute("message",response.getMessage());
			model.addAttribute("searchHappen","true");
			//Add throw due to Ajax call.
			throw e;
		}
		logger.debug("generateNewReturnBill :END");
		return new ModelAndView( "returnBill" ) ;
	}
	@RequestMapping(value=HtmConstants.GENERATE_RETURN_BILL_PDF,method={RequestMethod.GET})
	public String generateReturnBillPDF(Model model, HttpServletRequest request,HttpServletResponse httpResponse){
		logger.debug("generateReturnBillPDF :START");
		try{
			List<ListOfProductQuanityDetailsDTO>printDTOList=new ArrayList<ListOfProductQuanityDetailsDTO>();
			HttpSession session=request.getSession();
			ListOfProductQuanityDetailsDTO billItem=(ListOfProductQuanityDetailsDTO) session.getAttribute("billItem");
			session.removeAttribute("billItem");
			printDTOList.add(billItem);
			model.addAttribute("invoice",billItem);
			//JRBeanCollectionDataSource datasource=new JRBeanCollectionDataSource(printDTOList);
			//reportUtil.getCompiledFile("Employee", request);
			//reportUtil.generateReportPDF(request,httpResponse, new HashMap<String, Object>(), "Employee",datasource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("generateReturnBillPDF :END");
		return "printReturnBill";
	}
	private NewBillDetailsBean prepareNewBillBean(ResponseDTO response){
		logger.debug("prepareNewBillBean :START");
		NewBillDetailsBean newBillDetailsBean= (NewBillDetailsBean) response.getResponseObject();
		logger.debug("prepareNewBillBean :END");
		return newBillDetailsBean;
	}
	private void generateRows(ListOfProductQuanityDetailsDTO billItems,int numberOfRows){
		logger.debug("generateRows :START");
		List<NewBillProductDTO> newRowList=new ArrayList<NewBillProductDTO>();
		for(int i=0;i<numberOfRows;i++){
			NewBillProductDTO dto=new NewBillProductDTO();
			newRowList.add(dto);
		}
		billItems.setBillItems(newRowList);
		logger.debug("generateRows :END");
	}
}
