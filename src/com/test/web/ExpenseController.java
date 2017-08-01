package com.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.ExpenseBean;
import com.test.web.dao.ExpenseDao;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseDao ExpenseDao;


	//DB --> Bean ---> JSON
	@RequestMapping("/rest/selecExpense")
	@ResponseBody
	public Map<String, Object> selectExpense(ExpenseBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();

		try {
			ExpenseBean resBean = ExpenseDao.selectExpense(mBean);

			resMap.put("result", "ok");
			resMap.put("ExpenseBean", resBean);

		} catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}

		return resMap;
	}


	//DB --> Bean ---> JSON
	//회원 목록 부분 
	@RequestMapping("/rest/selectExpenseList")
	@ResponseBody
	public Map<String, Object> selectExpenseList(ExpenseBean mbean) {

		Map<String, Object> resMap = new HashMap<String, Object>();

		try {
			List<ExpenseBean> list = ExpenseDao.selectExpenseList(mbean);

			resMap.put("result", "ok");
			resMap.put("ExpenseList", list);

		} catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}

		return resMap;
	}


	//DB --> Bean ---> JSON
	//회원가입 
	@RequestMapping("/rest/insertExpense")
	@ResponseBody
	public Map<String, Object> insertExpense(ExpenseBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {

			int resVal = ExpenseDao.insertExpense(mBean);
			if(resVal > 0) {
				resMap.put("result", "ok");
			}

		} 
		
		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}

		return resMap;
	}


	//DB --> Bean ---> JSON
	//회원수정 
	@RequestMapping("/rest/updateExpense")
	@ResponseBody
	public Map<String, Object> updateExpense(ExpenseBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {

			int resVal = ExpenseDao.updateExpense(mBean);
			if(resVal > 0) {
				resMap.put("result", "ok");
				resMap.put("resultMsg", "업데이트에 성공 하였습니다.");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다.");
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}

		return resMap;
	}


	//DB --> Bean ---> JSON
	//회원 삭제부분 
	@RequestMapping("/rest/deleteExpense")
	@ResponseBody
	public Map<String, Object> deleteUser(ExpenseBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {

			int resVal =ExpenseDao.deleteExpense(mBean);
			if(resVal > 0) {
				resMap.put("result", "ok");
				resMap.put("resultMsg", "삭제에 성공 하였습니다.");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다.");
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}

		return resMap;
	}


}
