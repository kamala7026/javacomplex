package com.shopping.global.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.global.bean.NewBillDetailsBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.bo.BillServiceBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dto.ListOfProductQuanityDetailsDTO;
import com.shopping.global.dto.NewBillProductDTO;
import com.shopping.global.services.ResponseDTO;

@Controller
public class BillController {

	@Autowired
	private BillServiceBO billService;


	final static Logger logger = LoggerFactory.getLogger(BillController.class);

	@RequestMapping(value=HtmConstants.NEW_BILL_PAGE,method={RequestMethod.GET,RequestMethod.POST})
	public String redirectToNewBillPage(Model model) {
		logger.debug("redirectToNewBillPage :START");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("redirectToNewBillPage :END");
		return "newBill";
	}
	private NewBillDetailsBean prepareNewBillBean(ResponseDTO response){
		logger.debug("prepareNewBillBean :START");
		NewBillDetailsBean newBillDetailsBean= (NewBillDetailsBean) response.getResponseObject();
		logger.debug("prepareNewBillBean :END");
		return newBillDetailsBean;
	}
	@RequestMapping(value=HtmConstants.GET_PRODUCT_DETAILS,method={RequestMethod.GET})
	public  @ResponseBody String fetchProductDetails(Model model, HttpServletRequest request,@RequestParam("productFetchDetails")String productFetchDetails) throws JsonProcessingException {
		logger.debug("fetchProductDetails :START");
		ResponseDTO response=new ResponseDTO();
		Map<String,Object>  returnMap=new HashMap<String,Object>();
		try {
			response=billService.validateAndSearchBathcNoDetails(productFetchDetails);
			@SuppressWarnings("unchecked")
			List<String> batchNumberList=(List<String>) response.getResponseObject();
			model.addAttribute("batchNumberList",batchNumberList);
			returnMap.put("batchNumberList",batchNumberList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		logger.debug("fetchProductDetails :END");
		return mapper.writeValueAsString(returnMap);
	}

	@RequestMapping(value=HtmConstants.NEW_BILL,method={RequestMethod.POST})
	public ModelAndView generateNewBill(Model model, HttpServletRequest request,HttpServletResponse httpResponse,@ModelAttribute("billItem")ListOfProductQuanityDetailsDTO billItem) throws Exception {
		logger.debug("generateNewBill :START");
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
		logger.debug("generateNewBill :END");
		return new ModelAndView( "newBill" ) ;
	}

	@RequestMapping(value=HtmConstants.ADD_NEW_ROWS_FOR_BILL,method={RequestMethod.GET,RequestMethod.POST})
	public String addRowsForBill(Model model,@ModelAttribute("numberOfRows")String numberOfRows,@ModelAttribute("billItem")ListOfProductQuanityDetailsDTO billItem) {
		logger.debug("addRowsForBill :START");
		ResponseDTO response=new ResponseDTO();
		try {
			response=billService.validateAndSearchStockDetails();
			NewBillDetailsBean newBillDetailsBean=new NewBillDetailsBean();
			newBillDetailsBean=prepareNewBillBean(response);
			model.addAttribute("stockList",newBillDetailsBean.getProductQuanityDetailsDTOList());
			model.addAttribute("customerList",newBillDetailsBean.getListofCustomers());
			ListOfProductQuanityDetailsDTO detailsDTo=new ListOfProductQuanityDetailsDTO();
			generateRows(billItem,Integer.parseInt(numberOfRows));
			model.addAttribute("billItem",detailsDTo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("addRowsForBill :END");
		return "newBill";
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
	@RequestMapping(value=HtmConstants.GENERATE_PDF,method={RequestMethod.GET})
	public String generatepdf(Model model, HttpServletRequest request,HttpServletResponse httpResponse){
		logger.debug("generatepdf :START");
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
		logger.debug("generatepdf :END");
		return "printBill";
	}
	@RequestMapping(value=HtmConstants.GENERATE_INVOICE,method={RequestMethod.POST})
	public String generateInvoice(Model model, HttpServletRequest request,HttpServletResponse httpResponse){
		logger.debug("generateInvoce :START");
		try{
			HttpSession session=request.getSession();
			ListOfProductQuanityDetailsDTO billItem=(ListOfProductQuanityDetailsDTO) session.getAttribute("billItem");
			session.removeAttribute("billItem");
			model.addAttribute("invoice",billItem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("generateInvoce :START");
		return "invoice";
	}

	@RequestMapping(value=HtmConstants.VIEW_BILL,method={RequestMethod.GET,RequestMethod.POST})
	public String redirectToBillViewPage(Model model, HttpServletRequest request,@ModelAttribute("billDetails")WildCardSearchBean billDetails) {
		logger.debug("redirectToBillViewPage :START");
		if(null !=billDetails){
			if(!StringUtils.isEmpty(billDetails.getSearchString())){
				ResponseDTO response=billService.validateAndSearchBillDetails(billDetails);
				model.addAttribute("billDetailsList",prepareBillDetailsBean(response));
				model.addAttribute("searchHappen","true");
			}
			else{
				model.addAttribute("billDetails",new WildCardSearchBean());
			}
		}
		else{
			model.addAttribute("billDetails",new WildCardSearchBean());
		}
		logger.debug("redirectToBillViewPage :END");
		return "viewBillDetails";
	}
	private ListOfProductQuanityDetailsDTO prepareBillDetailsBean(ResponseDTO response){
		logger.debug("prepareBillDetailsBean :START");
		ListOfProductQuanityDetailsDTO newBillDetailsBean= (ListOfProductQuanityDetailsDTO) response.getResponseObject();
		logger.debug("prepareBillDetailsBean :END");
		return newBillDetailsBean;
	}
	@RequestMapping(value=HtmConstants.VIEW_BILL_SUB_DETAILS,method={RequestMethod.GET})
	public  ModelAndView  fetchBillSubDetails(Model model, HttpServletRequest request,@ModelAttribute("billId")String billId) {
		logger.debug("fetchBillSubDetails :START");
			if(!StringUtils.isEmpty(billId)){
				WildCardSearchBean billDetails =new WildCardSearchBean();
				billDetails.setSearchString(billId);
				ResponseDTO response=billService.validateAndSearchBillDetails(billDetails);
				model.addAttribute("billDetailsList",prepareBillDetailsBean(response));
				model.addAttribute("searchHappen","true");
			}
		logger.debug("fetchBillSubDetails :END");
        return new ModelAndView( "billSubDetails" );

	}
	@RequestMapping(value=HtmConstants.BILL_SEARCH_FOR_REGENERATE_BILL,method={RequestMethod.GET})
	public  ModelAndView  billSearchForRegenerateBill(Model model, HttpServletRequest request) {
		logger.debug("billSearchForRegenerateBill :START");
		model.addAttribute("billDetails",new WildCardSearchBean());
		logger.debug("billSearchForRegenerateBill :END");
        return new ModelAndView( "billSearch" );

	}
	@RequestMapping(value=HtmConstants.REGENERATE_BILL,method={RequestMethod.POST})
	public  String  regenerateBill(Model model, HttpServletRequest request,@ModelAttribute("billDetails")WildCardSearchBean billDetails1) {
		logger.debug("fetchBillSubDetails :START");
		if(!StringUtils.isEmpty(billDetails1.getSearchString())){
			WildCardSearchBean billDetails =new WildCardSearchBean();
			billDetails.setSearchString(billDetails1.getSearchString());
			ResponseDTO response=billService.validateAndSearchBillDetails(billDetails);
			model.addAttribute("invoice",prepareBillDetailsBean(response));
			model.addAttribute("searchHappen","true");
		}
		logger.debug("fetchBillSubDetails :END");
		return "regenerateBill";

	}
}
