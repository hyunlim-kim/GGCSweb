package com.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.UserBean;
import com.test.web.dao.UserDao;

@Controller
public class RESTController {

	@Autowired
	private UserDao USERDao;
	
	//DB --> Bean ---> JSON
	@RequestMapping("/rest/selectUSER")
	@ResponseBody
	public Map<String, Object> selectUSER(UserBean mBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
			UserBean resBean = USERDao.selectUSER(mBean);
			
			resMap.put("result", "ok");
			resMap.put("USERBean", resBean);
			
		} catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		
		return resMap;
	}
	
	
	//DB --> Bean ---> JSON
	@RequestMapping("/rest/selectUserList")
	@ResponseBody
	public Map<String, Object> selectUserList() {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
			List<UserBean> list = USERDao.selectUserList();
		
			resMap.put("result", "ok");
			resMap.put("USERList", list);
			
		} catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		
		return resMap;
	}
	
	
	//DB --> Bean ---> JSON
	@RequestMapping("/rest/insertUSER")
	@ResponseBody
	public Map<String, Object> insertUSER(UserBean mBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");
		
		try {
			
			int resVal = USERDao.insertUSER(mBean);
			if(resVal > 0) {
				resMap.put("result", "ok");
			}
				
		} 
		catch(DuplicateKeyException dke) {
			resMap.put("resultMsg", "이미 존재하는 USER_ID 입니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}
		
		return resMap;
	}
	
	
	//DB --> Bean ---> JSON
	@RequestMapping("/rest/updateUSER")
	@ResponseBody
	public Map<String, Object> updateUSER(UserBean mBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");
		
		try {
			
			int resVal = USERDao.updateUSER(mBean);
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
	@RequestMapping("/rest/deleteUSER")
	@ResponseBody
	public Map<String, Object> deleteUSER(UserBean mBean) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");
		
		try {
			
			int resVal = USERDao.deleteUSER(mBean);
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
