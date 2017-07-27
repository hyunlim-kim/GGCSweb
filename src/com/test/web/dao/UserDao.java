package com.test.web.dao;

import java.util.List;

import com.test.web.bean.UserBean;

public interface UserDao {

	public UserBean selectUSER(UserBean bean);
	
	public List<UserBean> selectUserList();
	
	/** 회원가입 */
	public int insertUSER(UserBean bean);
	
	/** 회원수정 **/
	public int updateUSER(UserBean bean);
	
	/** 회원삭제 **/
	public int deleteUSER(UserBean bean);
	
	/** 회원 로그인 정보 조회 **/
	public UserBean loginProc(UserBean bean);
	

}
