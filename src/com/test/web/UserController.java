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
public class UserController {

	@Autowired
	private UserDao UserDao;

	//DB --> Bean ---> JSON
	//로그인 하는 부분 
	@RequestMapping("/rest/loginProc")
	@ResponseBody
	public Map<String, Object> selectUser(UserBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();

		try {
			UserBean resBean = UserDao.loginProc(mBean);

			if(resBean == null) {
				resMap.put("result", "fail");
				resMap.put("resultMsg", 
						"해당하는 유져가 없습니다. \n아이디와 비밀번호를 확인 해주세요.");
			} else {
				resMap.put("result", "ok");
				resMap.put("resultMsg", "로그인 성공");
				resMap.put("UserBean", resBean);				
			}

		} catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}

		return resMap;
	}


	//로그인을 위한 부분 
	//DB --> Bean ---> JSON
	@RequestMapping("/rest/selectUser")
	@ResponseBody
	public Map<String, Object> selectUSER(UserBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();

		try {
			UserBean resBean = UserDao.selectUser(mBean);

			resMap.put("result", "ok");
			resMap.put("UserBean", resBean);

		} catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}

		return resMap;
	}


	//DB --> Bean ---> JSON
	//회원 목록 부분 
	@RequestMapping("/rest/selectUserList")
	@ResponseBody
	public Map<String, Object> selectUserList() {

		Map<String, Object> resMap = new HashMap<String, Object>();

		try {
			List<UserBean> list = UserDao.selectUserList();

			resMap.put("result", "ok");
			resMap.put("UserList", list);

		} catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}

		return resMap;
	}


	//DB --> Bean ---> JSON
	//회원가입 
	@RequestMapping("/rest/insertUser")
	@ResponseBody
	public Map<String, Object> insertUser(UserBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {

			int resVal = UserDao.insertUser(mBean);
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
	//회원수정 
	@RequestMapping("/rest/updateUser")
	@ResponseBody
	public Map<String, Object> updateUser(UserBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {

			int resVal = UserDao.updateUser(mBean);
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
	@RequestMapping("/rest/deleteUser")
	@ResponseBody
	public Map<String, Object> deleteUser(UserBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {

			int resVal = UserDao.deleteUser(mBean);
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
