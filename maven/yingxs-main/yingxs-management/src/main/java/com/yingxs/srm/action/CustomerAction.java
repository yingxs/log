package com.yingxs.srm.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yingxs.crm.domain.Customer;
import com.yingxs.crm.service.ICustomerService;

@Controller
@Scope("prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	
	//模型驱动接受页面数据
	private Customer cust = new Customer();
	
	@Override
	public Customer getModel() {
		return cust;
	}
	
	@Resource
	private ICustomerService custService;

	public String save() {
		try {
			custService.save(cust);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
