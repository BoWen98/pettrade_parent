package com.chongwu.pettrade.service.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * 二级类目实体
 * @author zhaoxianhai
 *
 */
@Table(name="categorysecond")
@Entity
public class CategorySecond implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="csid")
	private Integer csId;
	
	@Column(name="csname",nullable=false,length=255)
	private String csName;
	
	@JoinColumn(name = "cid")
	//(cascade = CascadeType.ALL)
	@ManyToOne
	private Categorys category;
	
	@OneToMany(fetch= FetchType.EAGER, mappedBy = "categorySecond")
	private Set<Pet> pets;
	
	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public Categorys getCategory() {
		return category;
	}

	public void setCategory(Categorys category) {
		this.category = category;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	
}
