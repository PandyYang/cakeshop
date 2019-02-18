package com.xzy.pojo;


import java.util.Date;

public class Users {
   private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String  sex;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 签名
	 */
	private String signd;
	/**
	 * 存放图片的地址
	 */
	private String photo;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSignd() {
		return signd;
	}

	public void setSignd(String signd) {
		this.signd = signd;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
