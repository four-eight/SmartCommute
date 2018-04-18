package com.TechMahindra.SmartCommute.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMahindra.SmartCommute.Domain.User;
import com.TechMahindra.SmartCommute.Service.UserService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	
	@RequestMapping("/insert")
	public String insert(@RequestBody String UserInfo){
						//请求参数                       变量(json格式)
		//System.out.println(UserInfo);
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(UserInfo);  //创建jsonObject对象
		//将json数据转为为String型的数据
		String userName = json.get("userName").getAsString();     
		String userPassword = json.get("userPassword").getAsString(); 
		String encrypt = json.get("encrypt").getAsString(); 		
		//System.out.println(userName+userPassword+encrypt);		
		User user=new User();
		user.setUserName(userName);
		user.setPassword(userPassword);
		user.setEncrypt(encrypt);
		
		String result=userService.insertUser(user);		
		return result;
	}
	@RequestMapping("/login")
	public String login(@RequestBody String loginInfo){	
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(loginInfo);  //创建jsonObject对象
		//将json数据转为为String型的数据
		String userName = json.get("userName").getAsString();     
		String userPassword = json.get("userPassword").getAsString(); 
		User user=new User();
		user.setUserName(userName);
		user.setPassword(userPassword);
		String result=userService.loginUser(user);	
		return result;
	}
	@RequestMapping("/mibao")
	public String encrypt(@RequestBody String encrypted){	
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(encrypted);  //创建jsonObject对象
		//将json数据转为为String型的数据
		String userName = json.get("userName").getAsString();     
		String encrypt = json.get("encrypt").getAsString(); 
		
		User user=new User();
		user.setUserName(userName);
		user.setEncrypt(encrypt);
		
		String result=userService.encryptUser(user);		
		return result;
	}
	@RequestMapping("/resetPw")
	public String resetPw(@RequestBody String password){	
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(password);  //创建jsonObject对象
		//将json数据转为为String型的数据
		String userName = json.get("userName").getAsString();     
		String passWord = json.get("passWord").getAsString(); 
		
		User user=new User();
		user.setUserName(userName);
		user.setPassword(passWord);
		
		String result=userService.resetPassword(user);		
		return result;
	}
	
}
