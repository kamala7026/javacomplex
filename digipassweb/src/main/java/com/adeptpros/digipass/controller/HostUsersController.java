package com.adeptpros.digipass.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.adeptpros.digipass.beans.HostUsers;
import com.adeptpros.digipass.bo.HostUsersBo;
import com.adeptpros.digipass.exception.DateTimeFormatException;
import com.adeptpros.digipass.utility.Utils;


@Controller
public class HostUsersController {
	
	@Autowired
	private HostUsersBo hostUsersBo;
	
	
	public HostUsersBo getHostUsersBo() {
		return hostUsersBo;
	}


	public void setHostUsersBo(HostUsersBo hostUsersBo) {
		this.hostUsersBo = hostUsersBo;
	}

	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addConsumer(Model model, HttpServletRequest request,HttpServletResponse response,@ModelAttribute("hostUser")HostUsers hostUser){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		String userName=(String)session.getAttribute("userName");
				
		try {
			HostUsers hostUser1=this.hostUsersBo.addHostUser(userName,hostUser);
			if(hostUser1.getStatus().equals("SUCCESS")){
				model.addAttribute("actionStatus", "SUCCESS");
			}else if(hostUser1.getStatus().equals("EXISTUSER")){
				model.addAttribute("actionStatus", "EXISTUSER");
			}else{
				model.addAttribute("actionStatus", "ERROR");
			}
			
		} catch (Exception e) {
			model.addAttribute("actionStatus", "ERROR");
			e.printStackTrace();		
		}	
		List<HostUsers> usersList = new ArrayList<HostUsers>();
		try {
			usersList = this.hostUsersBo.getAllUsersByAdminId(userName);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		model.addAttribute("hostUsersList",usersList);
		model.addAttribute("hostUser",new HostUsers());
		return "users";		
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String getAllUsersByAdminId(Model model, HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		String userName=(String)session.getAttribute("userName");
		List<HostUsers> usersList = new ArrayList<HostUsers>();
		try {
			usersList = this.hostUsersBo.getAllUsersByAdminId(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("hostUsersList",usersList);
		model.addAttribute("hostUser",new HostUsers());
		return "users";		
	}
	@RequestMapping(value="/access",method=RequestMethod.POST)
	public String setAccess(Model model, HttpServletRequest request,HttpServletResponse response,@ModelAttribute("hostUser")HostUsers hostUser){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		String userName=(String)session.getAttribute("userName");
		try {
			String status=this.hostUsersBo.setAccess(hostUser);
			if(status.equals("SUCCESS")){
				model.addAttribute("accessStatus", "SUCCESS");
				
				if(hostUser.getAction().equals("INVITED"))
					model.addAttribute("msg","Host invited successfully.");
				else if(hostUser.getAction().equals("GRANTACCESS"))
					model.addAttribute("msg","Host activated successfully.");
				else if(hostUser.getAction().equals("DELETE"))
					model.addAttribute("msg","Host disabled successfully.");
				else if(hostUser.getAction().equals("CANCEL"))
					model.addAttribute("msg","Host deactivated successfully.");
					
			}else{
				model.addAttribute("accessStatus", "ERROR");
				model.addAttribute("msg","Internal server problem Please try again!!!");
			}
		} catch (Exception e) {
			model.addAttribute("accessStatus", "ERROR");
			model.addAttribute("msg","Internal server problem Please try again!!!");
			e.printStackTrace();
		}		
		List<HostUsers> usersList = new ArrayList<HostUsers>();
		try {
			usersList = this.hostUsersBo.getAllUsersByAdminId(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("hostUsersList",usersList);
		model.addAttribute("hostUser",new HostUsers());
		return "users";				
	}
	
	@RequestMapping(value="/host/edit", method=RequestMethod.GET)
	public @ResponseBody HostUsers getHostDetailsBthostId(@Param Long hostId){
		//System.out.println(hostId);
		HostUsers hostUsers=new HostUsers();
		hostUsers=this.getHostUsersBo().getHostDetailsBthostId(hostId);
		System.out.println(hostUsers.toString());
		return hostUsers;//"[{'name':'kamalakanta'}]";
	}
	@RequestMapping(value="/host/duplicateCheck", method=RequestMethod.GET)
	public @ResponseBody HostUsers duplicateCheck(@Param String action,@Param String value){
		System.out.println(action);
		HostUsers hostUsers=new HostUsers();
		String status=null;
		try {
			if(action.equals("email_duplicate")){
				status=this.getHostUsersBo().duplicateEmailCheck(value);
				if(status.equals("DUPLICATE")){
					hostUsers.setStatus("DUPLICATE");
				}else if(status.equals("NOTDUPLICATE")){
					hostUsers.setStatus("NOTDUPLICATE");
				}else{
					hostUsers.setStatus("ERROR");
				}
				
			}else if(action.equals("mobile_duplicate")){
				status=this.getHostUsersBo().duplicateMobileCheck(value);
				if(status.equals("DUPLICATE")){
					hostUsers.setStatus("DUPLICATE");
				}else if(status.equals("NOTDUPLICATE")){
					hostUsers.setStatus("NOTDUPLICATE");
				}else{
					hostUsers.setStatus("ERROR");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		hostUsers.setStatus("SUCCESS");
		return hostUsers;//"[{'name':'kamalakanta'}]";
	}
	
	
	@RequestMapping(value="/host/update", method=RequestMethod.POST)
	public String updateHost(Model model, HttpServletRequest request,HttpServletResponse response,@ModelAttribute("hostUser")HostUsers hostUser){
		//System.out.println(hostId);
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		String userName=(String)session.getAttribute("userName");
				
		try {
			HostUsers hostUser1=this.hostUsersBo.updateHost(userName,hostUser);
			if(hostUser1.getStatus().equals("EXISTUSER")){
				model.addAttribute("uploadStatus", "ERROR");
				model.addAttribute("msg", "Another host with same email id is exist.");
			}else if(hostUser1.getStatus().equals("SUCCESS")){
				model.addAttribute("uploadStatus", "SUCCESS");
				model.addAttribute("msg", "Host updated Successfully.");
			}else{
				model.addAttribute("uploadStatus", "ERROR");
				model.addAttribute("msg", "Internal server problem Please try again!!!");
			}
		} catch (Exception e) {
			model.addAttribute("uploadStatus", "ERROR");
			model.addAttribute("msg", "Internal server problem Please try again!!!");
			e.printStackTrace();		
		}	
		
		List<HostUsers> usersList = new ArrayList<HostUsers>();
		try {
			usersList = this.hostUsersBo.getAllUsersByAdminId(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("hostUsersList",usersList);
		model.addAttribute("hostUser",new HostUsers());
		return "users";			
	}
	
	@RequestMapping(value="/download_host_csv")
	 public void hostUserCsvFileDownload(HttpServletRequest request,HttpServletResponse response){
		
		 int BUFFER_SIZE = 4096;
		 String mimeType = "application/octet-stream";
		 FileInputStream inputStream = null;
		 OutputStream outStream = null;
		 String headerKey = "Content-Disposition";
		 String filePath = "/hostusers.csv";
		 String appPath = request.getRealPath("/downloads");
         String fullPath = appPath + filePath;      
         File downloadFile = new File(fullPath);
        
         try {
			inputStream = new FileInputStream(downloadFile);
			response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	        String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	        outStream = response.getOutputStream();
	        byte[] buffer = new byte[BUFFER_SIZE];
	        int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				inputStream.close();
		        outStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	 }
	
	

	
	@RequestMapping(value="/uploadHostUser", method=RequestMethod.POST)
    public String handleFileUpload(Model model,@RequestParam("hostFile") MultipartFile userFile,MultipartHttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if((session.getAttribute("userId"))==null){
			return "redirect:"+"/";
		}
		String userName=(String)session.getAttribute("userName");
		String oldFileName=userFile.getOriginalFilename();
		int n=oldFileName.lastIndexOf(".");
		String type=oldFileName.substring(n, oldFileName.length());
		System.out.println(type);
		if (!userFile.isEmpty()) {
			File newFile=null;
            try {
                byte[] bytes = userFile.getBytes();
                String appPath = request.getRealPath("/hostusercsv");
                String filename = "/"+new Date().getTime()+"_"+Utils.randInt()+type;
                newFile=new File(appPath+filename);
                BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(bytes);
                stream.close();
                
                String duplicateStatus=this.getHostUsersBo().checkDuplicate(model,newFile,request,userName);
                if(duplicateStatus.equals("SUCCESS")){
                	String uploadStatus=this.getHostUsersBo().uploadHostUsers(newFile, request, userName, model);
                	       		
                	if(uploadStatus.equals("SUCCESS")){
                		model.addAttribute("uploadStatus", "SUCCESS");
                		model.addAttribute("msg", "Host uploaded Successfully.");
                	}else{
                		model.addAttribute("uploadStatus", "ERROR");
                    	model.addAttribute("msg","Internal server problems. Please try again!!!!");
                    	newFile.delete();
                	}
                	                	
                }else{
                	model.addAttribute("uploadStatus", "ERROR");
                	//model.addAttribute("msg",model.);
                    newFile.delete();
                }   
              
            } catch (DateTimeFormatException e) {
            	e.printStackTrace();
            	model.addAttribute("uploadStatus", "ERROR");
            	model.addAttribute("msg","You have entered wrong date time format. Please enter valid date time format.");
            	if(newFile!=null && newFile.isFile()){
            		newFile.delete();
            	}
            	
            }catch (Exception e) {
            	e.printStackTrace();
            	model.addAttribute("uploadStatus", "ERROR");
            	model.addAttribute("msg","Internal server problems. Please try again!!!!");
            	if(newFile!=null && newFile.isFile()){
            		newFile.delete();
            	}
            	
            }
        } else {
        	model.addAttribute("uploadStatus", "ERROR");
        	model.addAttribute("msg","Internal server problems. Please try again!!!!");
        }
		
		List<HostUsers> usersList = new ArrayList<HostUsers>();
		try {
			usersList = this.hostUsersBo.getAllUsersByAdminId(userName);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("hostUsersList",usersList);
		model.addAttribute("hostUser",new HostUsers());
		return "users";		
    }
	
	
}
