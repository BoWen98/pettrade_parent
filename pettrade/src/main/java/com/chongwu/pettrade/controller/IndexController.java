package com.chongwu.pettrade.controller;


import com.chongwu.pettrade.service.service.CategorysService;
import com.chongwu.pettrade.service.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 宠物交易首页
 * @author zhaoxianhai
 *
 */
@Controller
public class IndexController {
	
	@Autowired
	 private CategorysService categorysService;
	
	@Autowired
	private PetService petService;
	
	@RequestMapping(value = "/index")
	public String showIndex(Map<String, Object> map, HttpSession session){
		//查询所有的一级分类存到session中
		session.setAttribute("categoryList", categorysService.findAll());
		//最新的10只宠物存到map
		map.put("mostNewPet", petService.fintMostNew());
		//最热的10只宠物存到map
		map.put("mostHotPet", petService.findMostHot());
		return "index";
	}
	/**
	 * 跳转到Admin登录
	 * @return
	 */
	@RequestMapping(value = "/userLogin")
    public String userLogin() {
        return "login";
    }
	/**
	 *  跳转用户注册
	 * @return
	 */
	@RequestMapping("/userRegister")
    public String register() {
        return "regist";
    }
}
