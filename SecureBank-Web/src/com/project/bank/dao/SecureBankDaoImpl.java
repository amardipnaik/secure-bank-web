package com.project.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.project.bank.bean.TrasactionBean;
import com.project.bank.bean.UserBean;

@Repository
public class SecureBankDaoImpl implements ISecureBankDao{

	


private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void adduserBean(UserBean userBean) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userBean);
		System.out.println("userBean saved successfully, userBean Details="+userBean);
		
	}
    
    public void addTransactionBean(TrasactionBean trasactionBean) {
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(trasactionBean);
		System.out.println("userBean saved successfully, trasactionBean Details="+trasactionBean);
		
	}

    public List<UserBean> userBeanList(UserBean userBean) {
    	Session session = this.sessionFactory.getCurrentSession();
    	
    	StringBuilder querryBuilder=new StringBuilder();
    	
    	querryBuilder.append("SELECT * FROM user_table where login=:login and password=:password ");
    	
    	SQLQuery query
    	 = session.createSQLQuery(querryBuilder.toString()).addEntity(UserBean.class);
    	
    	query.setParameter("login",userBean.getLogin());
    	query.setParameter("password",userBean.getPassword());
    	
    	List<UserBean> userBeanList=query.list();
    	
    	return userBeanList;
    	
    }
    
    public List<UserBean> userList() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserBean");
       List<UserBean> userBeanList = query.list();
       
       System.out.println("User Bean List Is :: "+userBeanList.size());
       return userBeanList;
		
	}
    
    public List<TrasactionBean> trasactionList() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TrasactionBean");
       List<TrasactionBean> trasactionList = query.list();
       
       System.out.println("TrasactionBean List Is :: "+trasactionList.size());
       return trasactionList;
		
	}
    
    public List<TrasactionBean> trasactionListByUserCode(String UserCode) {
  		Session session = this.sessionFactory.getCurrentSession();
  		
  		StringBuilder querryBuilder=new StringBuilder();
  		querryBuilder.append("SELECT * FROM transaction  ");
  		querryBuilder.append("where User_Code=:UserCode ");
  		
  		
  		SQLQuery query
  		 = session.createSQLQuery(querryBuilder.toString()).addEntity(TrasactionBean.class);
  		
  		query.setParameter("UserCode",UserCode);
         List<TrasactionBean> trasactionList = query.list();
         
         System.out.println("TrasactionBean List Is :: "+trasactionList.size());
         return trasactionList;
  		
  	}
    
    

}
