package com.chongwu.pettrade.service.dao;

import com.chongwu.pettrade.service.entity.Pet;

import java.util.List;

/**
 * 宠物接口 
 * @author zhaoxianhai
 *
 */
public interface PetDao extends BaseDao<Pet> {
	
	/**
	 * 查询宠物总页数
	 * @return
	 */
	Integer countPetPage();
	
	/**
	 * 分页显示宠物
	 * @param Page
	 * @return
	 */
	List<Pet> findAll(Integer page);
	
	
	/**
	 * 查询最新的宠物
	 * @return
	 */
	List<Pet> fintMostNew();

	/**
	 * 查询最热的宠物
	 * @return
	 */
	List<Pet> findMostHot();
	
	/**
	 * 根据一级分类查询宠物
	 */
	 List<Pet> findByCategoryId(Integer cid, Integer page);
	
	/**
	 * 根据一级分类查询宠物总页数
	 */
	 Integer CountPagePetFromCategory(Integer cid);
	 /**
	  * 根据二级分类查询宠物
	  */
	 List<Pet> findByCategorySecondCsid(Integer csid, Integer page);
	 
	 /**
	  * 根据二级分类查询宠物总页数
	  */
	 Integer CountPagePetFromCategorySecondCsid(Integer csid);

	
}
