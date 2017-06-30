package com.news.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TxAspect {
	private PlatformTransactionManager transactionManager;
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	public Object tx(ProceedingJoinPoint pjp){
		//开启事务
		//TransactionDefinition接口:用于描述事务的隔离级别、传播规则、超时时间、是否为只读事务等属性
		//使用默认的事务定义
		TransactionStatus ts=transactionManager.getTransaction(new DefaultTransactionDefinition());
		Object rvt=null;
		try {
			rvt=pjp.proceed();
			transactionManager.commit(ts);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			transactionManager.rollback(ts);
		}
		return rvt;
	}
}
