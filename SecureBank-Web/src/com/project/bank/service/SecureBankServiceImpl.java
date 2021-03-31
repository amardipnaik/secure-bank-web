package com.project.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.bank.bean.TrasactionBean;
import com.project.bank.bean.UserBean;
import com.project.bank.dao.ISecureBankDao;

@Service
public class SecureBankServiceImpl implements ISecureBankService{
	
	private  ISecureBankDao secureBankDao;

	public ISecureBankDao getSecureBankDao() {
		return secureBankDao;
	}

	public void setSecureBankDao(ISecureBankDao secureBankDao) {
		this.secureBankDao = secureBankDao;
	}

@Transactional
	public void adduserBean(UserBean userBean)
	{
		secureBankDao.adduserBean(userBean);
		
	}
@Transactional
	 public void addTransactionBean(TrasactionBean trasactionBean)
	 {
		 secureBankDao.addTransactionBean(trasactionBean);
	 }

@Transactional
	 public List<UserBean> userBeanList(UserBean userBean)
	 {
		return secureBankDao.userBeanList(userBean);
	 }

@Transactional
	 public List<UserBean> userList()
	 {
		 return secureBankDao.userList();
	 }
	
@Transactional
public List<TrasactionBean> trasactionList()
{
	return secureBankDao.trasactionList();
}

@Transactional
public List<TrasactionBean> trasactionListByUserCode(String UserCode)
{
	return secureBankDao.trasactionListByUserCode(UserCode);
}
	



}
