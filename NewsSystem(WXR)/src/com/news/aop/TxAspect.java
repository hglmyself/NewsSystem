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
		//��������
		//TransactionDefinition�ӿ�:������������ĸ��뼶�𡢴������򡢳�ʱʱ�䡢�Ƿ�Ϊֻ�����������
		//ʹ��Ĭ�ϵ�������
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
