package com.jasper.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jasper.bean.EmployeeBean;
import com.jasper.dao.EmployeeDao;
import com.jasper.util.ReportUtil;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class ReportController {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@RequestMapping(value="/employeereportPDF",method=RequestMethod.GET)
	public String generateEmployeeReportPDF(HttpServletRequest request,HttpServletResponse response){
		List<EmployeeBean> employeeList=this.getEmployeeDao().getEmployees();
		JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(employeeList);
		try {
			JasperReport jasperReport=ReportUtil.getCompiledFile("Employee", request);
			String report=request.getSession().getServletContext().getRealPath("/report/Employee.jasper");
			ReportUtil.generateReportPDF(response,new HashMap<>(), report, dataSource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	@RequestMapping(value="/employeereportHTML",method=RequestMethod.GET)
	public String generateEmployeeReportHTML(HttpServletRequest request,HttpServletResponse response){
		
		try {
			List<EmployeeBean> employeeList=this.getEmployeeDao().getEmployees();
			JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(employeeList);
			JasperReport jasperReport=ReportUtil.getCompiledFile("Employee", request);
			String report=request.getSession().getServletContext().getRealPath("/report/Employee.jasper");
			ReportUtil.generateReportHTML(response,new HashMap<>(), report, dataSource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	 
}
