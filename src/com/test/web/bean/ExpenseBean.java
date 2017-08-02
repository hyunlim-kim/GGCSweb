package com.test.web.bean;

public class ExpenseBean extends UserBean{

	private String Sex;
	private String Money;
	private String Detail;
	private String Place;
	private String Date;
	private String Memo;
	private String Money_Id;
	private String SumMoney;
	
	public String getSumMoney() {
		return SumMoney;
	}
	public void setSumMoney(String sumMoney) {
		SumMoney = sumMoney;
	}
	public String getDay() {
		return Day;
	}
	public void setDay(String day) {
		Day = day;
	}
	private String Day;
	
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getMoney() {
		return Money;
	}
	public void setMoney(String money) {
		Money = money;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getMemo() {
		return Memo;
	}
	public void setMemo(String memo) {
		Memo = memo;
	}
	public String getMoney_Id() {
		return Money_Id;
	}
	public void setMoney_Id(String money_Id) {
		Money_Id = money_Id;
	}
	

}
