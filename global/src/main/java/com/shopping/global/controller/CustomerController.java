package com.shopping.global.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.global.bean.CustomerDetailsBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.bo.CustomerServiceBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dao.PrintUtilityDAO;
import com.shopping.global.dto.CustomerDueDTO;
import com.shopping.global.dto.CustomerDueDetailsBean;
import com.shopping.global.dto.CustomerSearchDTO;
import com.shopping.global.dto.PrintCustomerDetails;
import com.shopping.global.model.TdCashTransaction;
import com.shopping.global.model.TdCustomerDetail;
import com.shopping.global.services.ResponseDTO;
import com.shopping.global.util.DateUtil;

@Controller
public class CustomerController {

	@Autowired
	private CustomerServiceBO customerService;

	final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private PrintUtilityDAO printDAO;
	
	@Autowired
	private DateUtil dateUtil;

	@RequestMapping(value=HtmConstants.ADD_CUSTOMER_PAGE)
	public String redirectToCustomerAddPage(Model model) {
		logger.debug("redirectToCustomerAddPage :START");
		model.addAttribute("customerDetails",new CustomerDetailsBean());
		logger.debug("redirectToCustomerAddPage :END");
		return "addCustomer";
	}
	@RequestMapping(value=HtmConstants.VIEW_CUSTOMER_PAGE,method={RequestMethod.GET,RequestMethod.POST})
	public String redirectToCustomerViewPage(Model model, HttpServletRequest request,@ModelAttribute("customerSearchDetails")WildCardSearchBean customerSearchDetails) {
		logger.debug("redirectToCustomerViewPage :START");
		if(null !=customerSearchDetails){
			if(!StringUtils.isEmpty(customerSearchDetails.getSearchString())){
				ResponseDTO response=customerService.validateAndSearchCustomerDetails(customerSearchDetails);
				model.addAttribute("customerList",prepareCustomerList(response));
				model.addAttribute("searchHappen","true");
				model.addAttribute("customer",new CustomerSearchDTO());
			}
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
				model.addAttribute("customer",new CustomerSearchDTO());
			}
		}
		else{
			model.addAttribute("customerSearchDetails",new WildCardSearchBean());
		}
		logger.debug("redirectToCustomerViewPage :END");
		return "viewCustomer";
	}
	@RequestMapping(value=HtmConstants.EDIT_CUSTOMER_PAGE,method={RequestMethod.POST,RequestMethod.POST})
	public String editCustomerPage(Model model, HttpServletRequest request,@ModelAttribute("customer")CustomerSearchDTO customer) {
		logger.debug("editCustomerPage :START");
			if(!StringUtils.isEmpty(customer.getCustomerId())){
				ResponseDTO response=customerService.getCustomerDetails(customer);
				model.addAttribute("customer",prepareResponseObject(response.getResponseObject()));
				//model.addAttribute("customer",new CustomerSearchDTO());
			}
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
				model.addAttribute("customer",new CustomerSearchDTO());
			}
		logger.debug("editCustomerPage :END");
		return "editCustomer";
	}
	@RequestMapping(value=HtmConstants.UPDATE_CUSTOMER_PAGE,method={RequestMethod.POST,RequestMethod.POST})
	public String updateCustomerPage(Model model, HttpServletRequest request,@ModelAttribute("customer")CustomerSearchDTO customer) {
		logger.debug("updateCustomerPage :START");
			if(!StringUtils.isEmpty(customer.getCustomerId())){
				ResponseDTO response=customerService.updateCustomer(customer);
				if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
					model.addAttribute("message",response.getMessage());
					model.addAttribute("status",Constants.SUCCESS);
					model.addAttribute("customer",prepareResponseObject(response.getResponseObject()));
				}
				else{
					model.addAttribute("status",Constants.ERROR);
					model.addAttribute("message",response.getMessage());
					model.addAttribute("customer",customer);
				}
			}
		logger.debug("updateCustomerPage :END");
		return "editCustomer";
	}
	private CustomerSearchDTO prepareResponseObject(Object responseObject) {
		TdCustomerDetail tdCustomerDetail=(TdCustomerDetail)responseObject;
		CustomerSearchDTO customerSearchDTO=new CustomerSearchDTO();
		customerSearchDTO.setAddress(tdCustomerDetail.getAddress());
		customerSearchDTO.setCity(tdCustomerDetail.getCity());
		customerSearchDTO.setCustomerId(tdCustomerDetail.getCustomerId()+"");
		customerSearchDTO.setDob(dateUtil.dateToString(tdCustomerDetail.getDob()));
		customerSearchDTO.setEmail(tdCustomerDetail.getEmail());
		customerSearchDTO.setGodownNo(tdCustomerDetail.getGodownNo());
		customerSearchDTO.setLandline(tdCustomerDetail.getLandline());
		customerSearchDTO.setMobile(tdCustomerDetail.getMobile());
		customerSearchDTO.setName(tdCustomerDetail.getName());
		customerSearchDTO.setSphone(tdCustomerDetail.getSecondaryPhone());
		customerSearchDTO.setState(tdCustomerDetail.getState());
		return customerSearchDTO;
	}
	@RequestMapping(value=HtmConstants.ADD_CUSTOMER,method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customerDetails")CustomerDetailsBean customerDetails, BindingResult result, ModelMap model) {
		logger.debug("addCustomer :START");
		ResponseDTO response=customerService.validateAndSaveCustomerDetails(customerDetails);

		if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
			model.addAttribute("customerDetails",new CustomerDetailsBean());
			model.addAttribute("message",response.getMessage());
			model.addAttribute("status",Constants.SUCCESS);
			model.addAttribute("searchHappen","true");
		}
		else{
			model.addAttribute("customerDetails",new CustomerDetailsBean());
			model.addAttribute("status",response.getStatus());
			model.addAttribute("message",response.getMessage());
			model.addAttribute("searchHappen","true");

		}
		logger.debug("addCustomer :END");
		return "addCustomer";
	}
	private List<CustomerSearchDTO>prepareCustomerList(ResponseDTO response){
		logger.debug("prepareCustomerList :START");
		@SuppressWarnings("unchecked")
		List<CustomerSearchDTO> customerSearchDTOList= (List<CustomerSearchDTO>) response.getResponseObject();
		logger.debug("prepareCustomerList :END");
		return customerSearchDTOList;
	}
	private List<CustomerDueDTO>prepareCustomerDueDTO(ResponseDTO response){
		logger.debug("prepareCustomerDueDTO :START");
		@SuppressWarnings("unchecked")
		List<CustomerDueDTO> customerDue= (List<CustomerDueDTO>) response.getResponseObject();
		logger.debug("prepareCustomerDueDTO :END");
		return customerDue;
	}
	private List<CustomerDueDetailsBean>prepareCustomerDueDetails(ResponseDTO response){
		logger.debug("prepareCustomerDueDetails :START");
		@SuppressWarnings("unchecked")
		List<CustomerDueDetailsBean> customerDue= (List<CustomerDueDetailsBean>) response.getResponseObject();
		logger.debug("prepareCustomerDueDetails :END");
		return customerDue;
	}
	private List<TdCashTransaction>prepareCustomerPaymnetDetails(ResponseDTO response){
		logger.debug("prepareCustomerPaymnetDetails :START");
		@SuppressWarnings("unchecked")
		List<TdCashTransaction> customerDue= (List<TdCashTransaction>) response.getResponseObject();
		logger.debug("prepareCustomerPaymnetDetails :END");
		return customerDue;
	}

	@RequestMapping(value=HtmConstants.VIEW_CUSTOMER_DUES,method={RequestMethod.GET})
	public  ModelAndView  fetchCustomerDues(Model model, HttpServletRequest request,@ModelAttribute("customerId")String customerId) {
		logger.debug("fetchCustomerDues :START");
			if(!StringUtils.isEmpty(customerId)){
				WildCardSearchBean wildCardSearchBean=new WildCardSearchBean();
				wildCardSearchBean.setSearchString(customerId);
				ResponseDTO response=customerService.validateAndFetchCustomerDues(wildCardSearchBean);
				model.addAttribute("customerDue",prepareCustomerDueDTO(response));
				model.addAttribute("searchHappen","true");
			}
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
			}
		logger.debug("fetchCustomerDues :END");
        return new ModelAndView( "customerSubView" );

	}
	@RequestMapping(value=HtmConstants.VIEW_CUSTOMER_DUES_DETAILS,method={RequestMethod.GET})
	public  ModelAndView  fetchCustomerDueDetails(Model model, HttpServletRequest request,@ModelAttribute("customerId")String customerId) {
		logger.debug("fetchCustomerDueDetails :START");
			if(!StringUtils.isEmpty(customerId)){
				WildCardSearchBean wildCardSearchBean=new WildCardSearchBean();
				wildCardSearchBean.setSearchString(customerId);
				ResponseDTO response=customerService.validateAndFetchCustomerDueDetails(wildCardSearchBean);
				ResponseDTO response1=customerService.validateAndFetchCustomerPaymentDetails(wildCardSearchBean);
				model.addAttribute("customerDueDetails",prepareCustomerDueDetails(response));
				model.addAttribute("customerPaymentDetails",prepareCustomerPaymnetDetails(response1));
				model.addAttribute("searchHappen","true");
			}
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
			}
		logger.debug("fetchCustomerDueDetails :END");
        return new ModelAndView( "customerDueDetails" );

	}

	@RequestMapping(value=HtmConstants.PRINT_VIEW_CUSTOMER_DETAILS_PAGE,method={RequestMethod.GET})
	public ModelAndView redirectToCustomerPrintPage(Model model,HttpServletRequest request) {
		logger.debug("redirectToCustomerPrintPage :START");
		PrintCustomerDetails printCustomerDetails=new PrintCustomerDetails();
		printCustomerDetails.setCustomerId(request.getParameter("customerId"));
		model.addAttribute("printCustomerDetails",printCustomerDetails);
		logger.debug("redirectToCustomerPrintPage :END");
		return new ModelAndView( "printCustomerDues" );
	}
	@RequestMapping(value=HtmConstants.CUSTOMER_DUE_DETAILS,method={RequestMethod.POST})
	public String customerPrintPage(Model model,@ModelAttribute("printCustomerDetails")PrintCustomerDetails printCustomerDetails)  {
		logger.debug("redirectToCustomerPrintPage :START");
		 try{
			 List<CustomerDueDetailsBean> customerDues = printDAO.fetchCustomerBetweenDate(printCustomerDetails);
			 List<TdCashTransaction> customerPayDetails = printDAO.fetchCustomerPayBetweenDate(printCustomerDetails);
				model.addAttribute("customerDueDetails",customerDues);
				model.addAttribute("customerPaymentDetails",customerPayDetails);
				model.addAttribute("searchHappen","true");
		 }catch(Exception e){
			 System.out.println(e);
		 }
		logger.debug("redirectToCustomerPrintPage :END");
		return "customerDueDetails1";
	}
	@RequestMapping(value=HtmConstants.CUSTOMER_DUE_SEARCH,method={RequestMethod.GET})
	public String customerDueSearch(Model model,@ModelAttribute("customerId")String customerId)  {
		logger.debug("customerDueSearch :START");
		PrintCustomerDetails printCustomerDetails=new PrintCustomerDetails();
		printCustomerDetails.setCustomerId(customerId);
		model.addAttribute("customerDueSearch",printCustomerDetails);
		logger.debug("customerDueSearch :END");
		return "customerDueSearch";
	}

}
