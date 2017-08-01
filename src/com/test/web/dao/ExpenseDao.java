
package com.test.web.dao;

import java.util.List;

import com.test.web.bean.ExpenseBean;

public interface ExpenseDao {

	/**목록 보기 */
	public ExpenseBean selectExpense(ExpenseBean bean);
	
	public List<ExpenseBean> selectExpenseList(ExpenseBean bean);
	
	/** 목록 등록  */
	public int insertExpense(ExpenseBean bean);
	
	/** 목록 수정 **/
	public int updateExpense(ExpenseBean bean);
	
	/** 목록 삭제 **/
	public int deleteExpense(ExpenseBean bean);
	
	
}