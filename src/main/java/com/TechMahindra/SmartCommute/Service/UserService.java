package com.TechMahindra.SmartCommute.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMahindra.SmartCommute.Dao.UserRepository;
import com.TechMahindra.SmartCommute.Domain.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	// 插入数据
	public String insertUser(User user) {
		try {
			List<User> users = userRepository.findAll();
			for (User userSigle : users) {
				if (user.getUserName().equals(userSigle.getUserName())) {
					return "repeat";
				}
			}
			userRepository.save(user);
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "success";
	}
	// 登录
	public String loginUser(User user) {
		List<User> users;
		try {
			users = userRepository.findAll();
		} catch (Exception e) {
			return "error";
		}
		for (User userSigle : users) {
			if (user.getUserName().equals(userSigle.getUserName())) {
				if (user.getPassword().equals(userSigle.getPassword())) {
					return "loginSuccess";
				} else {
					return "passwordError";
				}
			}
		}
		return "usernameError";
	} 
	// 验证密保问题
	public String encryptUser(User user) {
		List<User> users;
		try {
			users = userRepository.findAll();
		} catch (Exception e) {
			return "error";
		}
		for (User userSigle : users) {
			if (user.getUserName().equals(userSigle.getUserName())) {
				if (user.getEncrypt().equals(userSigle.getEncrypt())) {
					return "verifySuccess";
				} else {
					return "encryptError";
				}
			}
		}
		return "usernameError";
	}
	// 重设密码
	public String resetPassword(User user) {
		try{
			User resetPw = userRepository.findByUserName(user.getUserName());
			resetPw.setPassword(user.getPassword());
			userRepository.save(resetPw);
		}catch(Exception e){
			return "error";
		}	
		return "resetSuccess";
	}
}
