package com.jasper.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;



public class ReportUtil {

	
	public static JasperReport getCompiledFile(String fileName, HttpServletRequest request) throws JRException {
	    System.out.println("path " + request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper"));
	    File reportFile = new File( request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper"));
	    // If compiled file is not found, then compile XML template
	    if (!reportFile.exists()) {
	               JasperCompileManager.compileReportToFile(request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jrxml"),request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper"));
	        }
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
	        return jasperReport;
	    
	}
	
	public static void generateReportPDF (HttpServletResponse resp, Map parameters, String report, JRBeanCollectionDataSource dataSource)throws JRException, NamingException, IOException {
        byte[] bytes = null;
        bytes = JasperRunManager.runReportToPdf(report,parameters,dataSource);
        resp.reset();
        resp.resetBuffer();
        resp.setContentType("application/pdf");
        resp.setContentLength(bytes.length);
        ServletOutputStream ouputStream = resp.getOutputStream();
        ouputStream.write(bytes, 0, bytes.length);
        ouputStream.flush();
        ouputStream.close();
    } 
	public static void generateReportHTML (HttpServletResponse response, Map parameters, String report, JRBeanCollectionDataSource dataSource)throws JRException, NamingException, IOException {
        String reportPath = JasperRunManager.runReportToHtmlFile(report,parameters,dataSource);
        File reportHtmlFile = new File(reportPath);
        FileInputStream fis = new FileInputStream(reportHtmlFile);
        byte[] bytes =  new byte[(int)reportHtmlFile.length()];
        fis.read(bytes);
        response.setHeader("Content-Disposition","inline; filename="+reportHtmlFile.getName());
        response.setContentType("text/html");
        response.setContentLength(bytes.length);
        ServletOutputStream servletOutputStream=response.getOutputStream();
        servletOutputStream.write(bytes, 0, bytes.length);
        servletOutputStream.flush();
        servletOutputStream.close();
    } 
}
