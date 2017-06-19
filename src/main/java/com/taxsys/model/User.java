package com.taxsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 此类为User实体类
 */
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(generator="sid")
	@GenericGenerator(name="sid",strategy="assigned")
	@Column(length = 32)
	private String id;

	// 用户性别.
	@Column(length = 2)
	private int gender;

	// 用户账号
	@Column(length = 16)
	private String number;

	// 用户账号
	@Column(length = 16)
	private String role;

	// 用户手机
	@Column(length = 15)
	private String cellphone;

	// 用户密码
	@Column(length = 32)
	private String password;

	// 用户头像
	@Column(length = 255)
	private String avatar;

	// 用户创建时间
	@Column(length = 32)
	private String created_at;

	// 用户信息修改时间
	@Column(length = 32)
	private String updated_at;

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String number, String cellphone, String password) {
		this.number = number;
		this.cellphone = cellphone;
		this.password = password;
	}

	public User(String number, String password) {
		this.number = number;
		this.password = password;
	}

	public User(int gender, String avatar) {
		this.gender = gender;
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", number='" + number + '\'' +
				", role='" + role + '\'' +
				", gender=" + gender +
				", cellphone='" + cellphone + '\'' +
				", avatar='" + avatar + '\'' +
				", createTime='" + created_at + '\'' +
				", updateTime='" + updated_at + '\'' +
				'}';
	}
}
