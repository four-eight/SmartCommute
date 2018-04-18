package com.TechMahindra.SmartCommute.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMahindra.SmartCommute.Domain.TripHistory;
import com.TechMahindra.SmartCommute.Service.TripHistoryService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class TripHistoryController {
	@Autowired
	TripHistoryService tripHistoryService;
	//插入旅行数据
	@RequestMapping("/insertTrip")
	public String insertTrip(@RequestBody String tripInfo){
						//请求参数                       变量(json格式)
		//System.out.println(UserInfo);
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(tripInfo);  //创建jsonObject对象
		
		//将json数据转为为String型的数据
		String userName = json.get("userName").getAsString();     
		String startPlace = json.get("startPlace").getAsString(); 
		String endPlace = json.get("endPlace").getAsString(); 	
		String startDate = json.get("startDate").getAsString(); 
		String startTime = json.get("startTime").getAsString(); 
		//System.out.println(userName+userPassword+encrypt);
		
		TripHistory tripHistory = new TripHistory();
		tripHistory.setUserName(userName);
		tripHistory.setStartPlace(startPlace);
		tripHistory.setEndPlace(endPlace);
		tripHistory.setStartDate(startDate);
		tripHistory.setStartTime(startTime);
		
		String result=tripHistoryService.insertTrip(tripHistory);		
		return result;
	}
	//查询旅行数据
	@RequestMapping("/selectTrip")
	public String selectTrip(@RequestBody String selectTripInfo){
							//请求参数                       变量(json格式)
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(selectTripInfo);  //创建jsonObject对象
		
		//将json数据转为为String型的数据
		String userName = json.get("userName").getAsString();
		String startDate = json.get("startDate").getAsString();
		
		TripHistory tripHistory = new TripHistory();
		tripHistory.setUserName(userName);
		tripHistory.setStartDate(startDate);
		
		String result=tripHistoryService.selectTrip(tripHistory);	
		return result;
	}
	//删除旅行数据
	@RequestMapping("/deleteTrip")
	public String deleteTrip(@RequestBody String deleteTripInfo){
							//请求参数                       变量(json格式)
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(deleteTripInfo);  //创建jsonObject对象
			
		//将json数据转为为String型的数据
		String userName = json.get("userName").getAsString();
			
		TripHistory tripHistory = new TripHistory();
		tripHistory.setUserName(userName);
			
		String result=tripHistoryService.deleteTrip(tripHistory);	
		return result;
	}
}
