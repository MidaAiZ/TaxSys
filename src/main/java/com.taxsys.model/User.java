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

	// 用户昵称
	@Column(length = 32)
	private String nickname;

	// 用户头像
	@Column(length = 255)
	private String avatar;

	// 用户手机
	@Column(length = 15)
	private String cellphone;

	// 用户密码
	@Column(length = 32)
	private String password;

	// 用户创建时间
	@Column(length = 32)
	private String createTime;

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getavatar() {
		return avatar;
	}

	public void setavatar(String avatar) {
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", gender=" + gender +
				", nickname='" + nickname + '\'' +
				", avatar='" + avatar + '\'' +
				", cellphone='" + cellphone + '\'' +
				", password='" + password + '\'' +
				", createTime='" + createTime + '\'' +
				'}';
	}
}
