package com.project.bank.dao;

import java.util.List;

import com.project.bank.bean.TrasactionBean;
import com.project.bank.bean.UserBean;

public interface ISecureBankDao {
	
	
	 public void adduserBean(UserBean userBean);
	 public void addTransactionBean(TrasactionBean trasactionBean);
	 public List<UserBean> userBeanList(UserBean userBean);
	 public List<UserBean> userList();
	 public List<TrasactionBean> trasactionList();
	 public List<TrasactionBean> trasactionListByUserCode(String UserCode);

}
