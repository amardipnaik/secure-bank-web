package com.project.bank.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.bank.bean.TrasactionBean;
import com.project.bank.bean.UserBean;
import com.project.bank.service.ISecureBankService;

@RestController
public class SecureBankController {

	@Autowired
    private ISecureBankService secureBankService;
    
	 @RequestMapping(value="/login", method = RequestMethod.POST)
	    public ModelAndView loginMain(HttpServletRequest req, HttpServletResponse res)
	    {
		 
		 	HttpSession session=req.getSession();
	    	String login=req.getParameter("login");
	    	String password=req.getParameter("password");
	    	
	    	UserBean userBean=new UserBean();
	    	userBean.setLogin(EncodedStringLogin(login));
	    	userBean.setPassword(EncodedStringLogin(password));
	    	
	    	System.out.println("Login ::"+login);
	    	System.out.println("password ::"+password);
	    	
	    	List<UserBean> userBeanList=new ArrayList<UserBean>();
			try {
				userBeanList = secureBankService.userBeanList(userBean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	String profile=null;
	    	long userId=0;
	    	UserBean user=new UserBean();
	    	
	    	if(!userBeanList.isEmpty())
	    	{
	    		
	    		user=userBeanList.get(0);
	    		profile=user.getProfile();
	    		userId=user.getId();
	    	}
	    	else
	    	{
	    		return new ModelAndView("redirect:loginAuth");
	    	}
	    	
	    	session.setAttribute("userId",userId );
	    	session.setAttribute("user",user );
	    	
	    	session.setAttribute("profile",profile );
	    	
	    	
	    	session.setAttribute("loggedInUser", req.getAttribute("uname"));
	    	return new ModelAndView("login");
		
	    }
    
	 @RequestMapping(value="/register", method = RequestMethod.POST)
	    public ModelAndView regitserUser(HttpServletRequest req, HttpServletResponse res)
	    {
		 
			HttpSession session=req.getSession();
	    	String login=req.getParameter("login");
	    	String password=req.getParameter("pwd");
	    	String fname=req.getParameter("fname");
	    	String lname=req.getParameter("lname");
	    	String cn=req.getParameter("cn");
	    	String em=req.getParameter("em");
	    	String ct=req.getParameter("ct");
	    	String profile=req.getParameter("profile");
	    	
	    	UserBean userBean=new UserBean();
	    	userBean.setLogin(EncodedStringLogin(login));
	    	userBean.setPassword(EncodedStringLogin(password));
	    	userBean.setFirstName(EncodedString(fname));
	    	userBean.setLastName(EncodedString(lname));
	    	userBean.setMailID(EncodedString(em));
	    	userBean.setContactNumber(EncodedString(cn));
	    	userBean.setProfile(profile);
	    	userBean.setCity(ct);
	    	
	    	System.out.println("userBean"+userBean);
	    	System.out.println("secureBankService"+secureBankService);
	    	secureBankService.adduserBean(userBean);
	    	
	    	
	    	
	    	return new ModelAndView("redirect:loginAuth");
		
	    }
	

	 @RequestMapping(value="/loginAuth", method = RequestMethod.GET)
	    public ModelAndView loginAuth(HttpServletRequest req, HttpServletResponse res)
	    {
		 	return new ModelAndView("loginAuth");
		
	    }
	 
	 @RequestMapping(value = "userList", method = RequestMethod.GET)
		public List<UserBean> listuserBean() {
			System.out.println("In Controller userList");
			
			List<UserBean> userBeanList=new ArrayList<>();
			userBeanList=secureBankService.userList();
			
			return userBeanList;
		}
	 
	 
	 @RequestMapping(value = "transactionList", method = RequestMethod.GET)
		public List<TrasactionBean> transactionList() {
			System.out.println("In Controller TrasactionBean");
			
			List<TrasactionBean> trasactionBean=new ArrayList<>();
			trasactionBean=secureBankService.trasactionList();
			
			return trasactionBean;
		}
	 
	 
	 @RequestMapping(value = "transactionListByUserId", method = RequestMethod.GET)
		public List<TrasactionBean> transactionListByUserId(HttpServletRequest req, HttpServletResponse res) {
			System.out.println("In Controller transactionListByUserId");
			
			HttpSession session=req.getSession();
			long userId=(long) session.getAttribute("userId" );
			String userIdString=String.valueOf(userId);
			
			List<TrasactionBean> trasactionBean=new ArrayList<>();
			trasactionBean=secureBankService.trasactionListByUserCode(userIdString);
			
			List<TrasactionBean> trasactionBeanDecodedList=new ArrayList<>();
			
			for(TrasactionBean bean:trasactionBean)
			{
			
			TrasactionBean trasactionBeanDecoded=new TrasactionBean();
			
			trasactionBeanDecoded.setId(bean.getId());
			trasactionBeanDecoded.setUserCode(bean.getUserCode());
			trasactionBeanDecoded.setTrasactionDate(bean.getTrasactionDate());
			
			trasactionBeanDecoded.setBankName(DecodedString(bean.getBankName()));
			trasactionBeanDecoded.setTrasactionType(DecodedString(bean.getTrasactionType()));
			trasactionBeanDecoded.setCity(bean.getCity());
			trasactionBeanDecoded.setState(bean.getState());
			trasactionBeanDecoded.setAmount(DecodedString(bean.getAmount()));
			trasactionBeanDecoded.setUserAccountNumber(DecodedString(bean.getUserAccountNumber()));
			trasactionBeanDecoded.setBenificiaryAccountNumber(DecodedString(bean.getBenificiaryAccountNumber()));
			trasactionBeanDecoded.setBenificiaryIFSCCode(DecodedString(bean.getBenificiaryIFSCCode()));
			
			trasactionBeanDecodedList.add(trasactionBeanDecoded);
			
			}
			
			return trasactionBeanDecodedList;
		}
		
		
		@RequestMapping(value = "getUser", method = RequestMethod.GET)
		public UserBean getUser(HttpServletRequest req, HttpServletResponse res) {
			System.out.println("In Controller getUser");
			HttpSession session=req.getSession();
			UserBean userBean=new UserBean();
			 userBean= (UserBean) session.getAttribute("user");
			 
			 UserBean userBeanDecoded=new UserBean();
			 
			 userBeanDecoded.setLogin(DecodedString(userBean.getLogin()));
			 userBeanDecoded.setPassword(DecodedString(userBean.getPassword()));
			 userBeanDecoded.setFirstName(DecodedString(userBean.getFirstName()));
			 userBeanDecoded.setLastName(DecodedString(userBean.getLastName()));
			 userBeanDecoded.setMailID(DecodedString(userBean.getMailID()));
			 userBeanDecoded.setContactNumber(DecodedString(userBean.getContactNumber()));
			 userBeanDecoded.setProfile(userBean.getProfile());
			 userBeanDecoded.setCity(userBean.getCity());
			 userBeanDecoded.setId(userBean.getId());
			 
			
			return userBeanDecoded;
		}
	 
		@RequestMapping(value = "addTrasaction", method = RequestMethod.POST)
		public Map<String,String> addTrasaction(@RequestBody TrasactionBean trasactionBean) {
			System.out.println("In Controller trasactionBean");
			Map<String,String> resultMap=new HashMap<String,String>();
			System.out.println("trasactionBean is:::"+trasactionBean);
			
			TrasactionBean trasactionBeanEncoded=new TrasactionBean();
			
			trasactionBeanEncoded.setUserCode(trasactionBean.getUserCode());
			trasactionBeanEncoded.setBankName(EncodedString(trasactionBean.getBankName()));
			trasactionBeanEncoded.setTrasactionType(EncodedString(trasactionBean.getTrasactionType()));
			trasactionBeanEncoded.setCity(trasactionBean.getCity());
			trasactionBeanEncoded.setState(trasactionBean.getState());
			trasactionBeanEncoded.setAmount(EncodedString(trasactionBean.getAmount()));
			trasactionBeanEncoded.setUserAccountNumber(EncodedString(trasactionBean.getUserAccountNumber()));
			trasactionBeanEncoded.setBenificiaryAccountNumber(EncodedString(trasactionBean.getBenificiaryAccountNumber()));
			trasactionBeanEncoded.setBenificiaryIFSCCode(EncodedString(trasactionBean.getBenificiaryIFSCCode()));

				
				
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			trasactionBeanEncoded.setTrasactionDate(date);
			String status=null;
			
			try {
				secureBankService.addTransactionBean(trasactionBeanEncoded);;
				status="SUCCESS";
			} catch (Exception e) {
				status="ERROR:Kindly Check With Database Connectin";
				
			}
			
			resultMap.put("result", status);
			return resultMap;
			
		}
	
public String RandomNumber()
{
	 Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    String randomNumber=String.valueOf(randomInt) ; 
	    return randomNumber;
	    
	
}

public String EncodedString(String value)
{
	
	
	
	String addedNoise="CRYT";
	System.out.println("RandomNumber Is"+addedNoise);
	String addedNoiseWithString=addedNoise+value;
	System.out.println("addedNoiseWithString:::"+addedNoiseWithString);
	byte[] encodedBytes = Base64.getEncoder().encode(addedNoiseWithString.getBytes());
	String encodedStringWithNoise=new String(encodedBytes);
	System.out.println("encodedStringWithNoise " + encodedStringWithNoise);
	
	return encodedStringWithNoise;
}

public String EncodedStringLogin(String value)
{
	String addedNoise="AESN";
	System.out.println("RandomNumber Is"+addedNoise);
	String addedNoiseWithString=addedNoise+value;
	System.out.println("addedNoiseWithString:::"+addedNoiseWithString);
	byte[] encodedBytes = Base64.getEncoder().encode(addedNoiseWithString.getBytes());
	String encodedStringWithNoise=new String(encodedBytes);
	System.out.println("encodedStringWithNoise " + encodedStringWithNoise);
	
	return encodedStringWithNoise;
}


public String DecodedString(String value)
{
	byte[] decodedBytes = Base64.getDecoder().decode(value);
	String decodedString=new String(decodedBytes);
	System.out.println("decodedString " + decodedString);
	String FinalStringWithoutNoise=decodedString.substring(4);
	System.out.println("FinalStringWithoutNoise:::"+FinalStringWithoutNoise);
	    return FinalStringWithoutNoise;
	    
	
}



	
	
}
