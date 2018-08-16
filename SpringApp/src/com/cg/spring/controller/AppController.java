package com.cg.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moneymoney.app.model.service.ServiceImpl;
import com.moneymoney.framework.service.Service;

@Controller
public class AppController {
	
	
	ServiceImpl service;
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	
	@RequestMapping("/withdraw")
	public String withdraw()
	{
		return "withdraw";
	}
	
	@RequestMapping("/withdrawAmount")
	public String WithdrawAmount(@RequestParam("accNo") String accNo, @RequestParam("withdrawamount") String amount, Model model)
	{
		service.withdraw(Integer.parseInt(accNo),Integer.parseInt(amount));
		System.out.println(accNo + amount);
		return "display";
	}

}
