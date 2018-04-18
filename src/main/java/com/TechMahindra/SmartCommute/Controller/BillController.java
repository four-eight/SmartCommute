package com.TechMahindra.SmartCommute.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMahindra.SmartCommute.Domain.Bill;
import com.TechMahindra.SmartCommute.Service.BillService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@RestController
public class BillController {
	@Autowired
	BillService billService;

	@RequestMapping("/insertBill")
	public String insertBill(@RequestBody String BillInfo){
						//请求参数                       变量(json格式)
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(BillInfo);  //创建jsonObject对象
		
		//将json数据转为为String型的数据
		String tripId = json.get("tripId").getAsString(); 
		String userName = json.get("userName").getAsString(); 		
		String jsonData = json.get("jsonData").toString(); 	
		//System.out.println(tripId+"---"+userName+"---"+jsonData);	
		
		Bill bill=new Bill();
		bill.setTripId(tripId);
		bill.setUserName(userName);
		bill.setData(jsonData);
		
		String result=billService.insertBill(bill);		
		return result;
	}  
	@RequestMapping("/selectBill")
	public String selectBill(@RequestBody String BillSelect){
						//请求参数                       变量(json格式)
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(BillSelect);  //创建jsonObject对象
		
		//将json数据转为为String型的数据
		String tripId = json.get("tripId").getAsString(); 
		String userName = json.get("userName").getAsString(); 		
		//System.out.println(tripId+userName);
		Bill bill=new Bill();
		bill.setTripId(tripId);
		bill.setUserName(userName);
		
		
		String result=billService.selectBill(bill);		
		//System.out.println(result);
		return result;
	}
}
