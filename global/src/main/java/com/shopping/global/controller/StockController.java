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

import com.shopping.global.bean.AddStockBean;
import com.shopping.global.bean.WildCardSearchBean;
import com.shopping.global.bo.ProductServiceBO;
import com.shopping.global.constants.Constants;
import com.shopping.global.constants.HtmConstants;
import com.shopping.global.dto.ProductQuanityDetailsDTO;
import com.shopping.global.dto.StockSearchDTO;
import com.shopping.global.services.ResponseDTO;

@Controller
public class StockController {
	final static Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private ProductServiceBO productServiceBO;
	
	
	@RequestMapping(value=HtmConstants.ADD_STOCK_PAGE)
	public String redirectToCustomerAddPage(Model model) {
		model.addAttribute("addstockDetails",new AddStockBean());
		return "addNewStock";
	}
	
	@RequestMapping(value=HtmConstants.ADD_NEW_STOCK,method=RequestMethod.POST)
	public String addNewStock(@ModelAttribute("addstockDetails")AddStockBean stockDetails, BindingResult result, ModelMap model) {
		logger.debug("addNewStock :START");
		ResponseDTO response=productServiceBO.validateAndSaveProductDetails(stockDetails);
		
		if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
			model.addAttribute("addstockDetails",new AddStockBean());
			model.addAttribute("message",response.getMessage());
			model.addAttribute("status",Constants.SUCCESS);
			model.addAttribute("searchHappen","true");
		}
		else{
			model.addAttribute("addstockDetails",new AddStockBean());
			model.addAttribute("status",response.getStatus());
			model.addAttribute("message",response.getMessage());
		}
		logger.debug("addNewStock :END");
		return "addNewStock";
	}
	
	@RequestMapping(value=HtmConstants.VIEW_PRODUCT_PAGE,method={RequestMethod.GET,RequestMethod.POST})
	public String redirectToStockViewPage(Model model, HttpServletRequest request,@ModelAttribute("stockSearchDetails")WildCardSearchBean stockSearchDetails) {
		logger.debug("redirectToStockViewPage :START");
		if(null !=stockSearchDetails){
			if(!StringUtils.isEmpty(stockSearchDetails.getSearchString())){
				ResponseDTO response=productServiceBO.validateAndSearchStockDetails(stockSearchDetails);
				model.addAttribute("stockList",prepareStockList(response));
				model.addAttribute("searchHappen","true");
			}	
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
				ResponseDTO response=productServiceBO.fetchAllStockDetails();
				model.addAttribute("stockList",prepareStockList(response) );
				model.addAttribute("searchHappen","true");
			}
		}
		else{
			
			model.addAttribute("customerSearchDetails",new WildCardSearchBean());
			
		}
		logger.debug("redirectToStockViewPage :END");
		return "viewStock";
	}
	private List<StockSearchDTO>prepareStockList(ResponseDTO response){
		logger.debug("prepareStockList :START");
		@SuppressWarnings("unchecked")
		List<StockSearchDTO> stockSearchDTOList= (List<StockSearchDTO>) response.getResponseObject();
		logger.debug("prepareStockList :END");
		return stockSearchDTOList;
	}
	
	@RequestMapping(value=HtmConstants.VIEW_PRODUCT_DETAILS,method={RequestMethod.GET})
	public  ModelAndView  fetchStockDetails(Model model, HttpServletRequest request,@ModelAttribute("productId")String productId) {
		logger.debug("fetchStockDetails :START");
			if(!StringUtils.isEmpty(productId)){
				WildCardSearchBean wildCardSearchBean=new WildCardSearchBean();
				wildCardSearchBean.setSearchString(productId);
				ResponseDTO response=productServiceBO.validateAndFetchProductDetails(wildCardSearchBean);
				model.addAttribute("productDetails",prepareProdctDetailsDTO(response));
				model.addAttribute("searchHappen","true");
			}	
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
			}
		logger.debug("fetchStockDetails :END");
        return new ModelAndView( "productSubView" );

	}
	@SuppressWarnings("unchecked")
	private List<ProductQuanityDetailsDTO>prepareProdctDetailsDTO(ResponseDTO response){
		logger.debug("prepareProdctDetailsDTO :START");
		List<ProductQuanityDetailsDTO> productDetails=null;
		if(null !=response){
			if(! org.apache.commons.lang3.StringUtils.equalsIgnoreCase(response.getStatus(), Constants.ERROR)){
				productDetails= (List<ProductQuanityDetailsDTO>) response.getResponseObject();
			}
		}
		logger.debug("prepareProdctDetailsDTO :END");
		return productDetails;
	}
	@RequestMapping(value=HtmConstants.ADD_STOCK_PAGE_VIEW,method={RequestMethod.GET})
	public  String  fetchAllStockDetails(Model model, HttpServletRequest request) {
		logger.debug("fetchAllStockDetails :START");
				ResponseDTO response=productServiceBO.fetchAllStockDetails();
				model.addAttribute("productDetails",prepareProdctDetailsDTO(response));
				model.addAttribute("searchHappen","true");
		logger.debug("fetchAllStockDetails :END");
        return "addStock";

	}
	@RequestMapping(value=HtmConstants.FETCH_STOCK_DETAILS_FOR_EDIT,method={RequestMethod.GET})
	public  ModelAndView  fetchStockDetailsForEdit(Model model, HttpServletRequest request,@ModelAttribute("productId")String productId) {
		logger.debug("fetchStockDetailsForEdit :START");
			if(!StringUtils.isEmpty(productId)){
				WildCardSearchBean wildCardSearchBean=new WildCardSearchBean();
				wildCardSearchBean.setSearchString(productId);
				ResponseDTO response=productServiceBO.validateAndFetchProductDetails(wildCardSearchBean);
				model.addAttribute("productDetails",prepareProdctDetailsDTO(response));
				model.addAttribute("searchHappen","true");
			}	
			else{
				model.addAttribute("customerSearchDetails",new WildCardSearchBean());
			}
		logger.debug("fetchStockDetailsForEdit :END");
        return new ModelAndView( "addStockSubView" );

	}
	@RequestMapping(value=HtmConstants.ADD_STOCK,method=RequestMethod.POST)
	public String addExistingStock(@ModelAttribute("stockDetails")AddStockBean stockDetails, BindingResult result, ModelMap model) {
		logger.debug("addExistingStock :START");
		ResponseDTO response=productServiceBO.validateAndUpdateProductDetails(stockDetails);
		
		if(response.getStatus().equalsIgnoreCase(Constants.SUCCESS)){
			response=productServiceBO.fetchAllStockDetails();
			model.addAttribute("productDetails",prepareProdctDetailsDTO(response));
			model.addAttribute("searchHappen","true");
			model.addAttribute("status",Constants.SUCCESS);
		}
		else{
			model.addAttribute("addstockDetails",new AddStockBean());
			model.addAttribute("status",response.getStatus());
			model.addAttribute("message",response.getMessage());
		}
		logger.debug("addExistingStock :END");
		return "addStock";
	}
	
	@RequestMapping(value=HtmConstants.VIEW_ALL_STOCK,method={RequestMethod.GET})
	public  String  viewAllStock(Model model, HttpServletRequest request) {
		logger.debug("viewAllStock :START");
				ResponseDTO response=productServiceBO.fetchAllStockDetails();
				model.addAttribute("productDetails",prepareProdctDetailsDTO(response));
				model.addAttribute("searchHappen","true");
		logger.debug("viewAllStock :END");
        return "PrintAllStock";

	}
}
