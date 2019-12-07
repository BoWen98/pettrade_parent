package com.chongwu.pettrade.service.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 客户的电子钱包，在创建客户的时候生成，用触发器
 * @author zhaoxianhai
 *
 */
 
@Entity
@Table(name = "wallet")
public class Wallet implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wid")
	private Integer wid;

	@Column(name = "money")
	private Float money;

	/**
	 * 客户外键
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "uid", unique = true, nullable = false, updatable = false, insertable = false)
	private User user;

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
