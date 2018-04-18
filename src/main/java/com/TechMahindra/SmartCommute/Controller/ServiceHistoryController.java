package com.TechMahindra.SmartCommute.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMahindra.SmartCommute.Domain.ServiceHistory;
import com.TechMahindra.SmartCommute.Service.ServiceHistoryService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class ServiceHistoryController {
	@Autowired
	ServiceHistoryService servicehistoryService;
	@RequestMapping("/servicehistory")
	public String insertservicehistory(@RequestBody String serviceInfo){
		//请求参数                       变量(json格式)
    JsonParser jsonparse =new JsonParser();  //创建json解析器
    JsonObject json=(JsonObject) jsonparse.parse(serviceInfo);  //创建jsonObject对象
    //将json数据转为为String型的数据   
    String vehiclenum = json.get("vehiclenum").getAsString(); 
    String date = json.get("date").getAsString();
    String services = json.get("services").toString();
    String servicecenter = json.get("servicecenter").getAsString();
    System.out.println("--"+services);		
    ServiceHistory servicehistory=new ServiceHistory();
    servicehistory.setVehiclenum(vehiclenum);
    servicehistory.setDate(date);
    servicehistory.setServices(services);
    servicehistory.setServicecenter(servicecenter);

    String result=servicehistoryService.insertServicehistory(servicehistory);		
    return result;
 }  
	
	@RequestMapping("/selectservicehistory")
	public String selectservicehistory(@RequestBody String selectservicehistory){
		//请求参数                       变量(json格式)
    JsonParser jsonparse =new JsonParser();  //创建json解析器
    JsonObject json=(JsonObject) jsonparse.parse(selectservicehistory);  //创建jsonObject对象
    //将json数据转为为String型的数据   
    String vehiclenum = json.get("vehiclenum").getAsString(); 
    String seldate = json.get("seldate").getAsString();
    //System.out.println(userName);		
    ServiceHistory servicehistory=new ServiceHistory();
    servicehistory.setVehiclenum(vehiclenum);
    servicehistory.setDate(seldate);
    String result=servicehistoryService.selectServicehistory(servicehistory);		
    return result;
 }  
	@RequestMapping("/deleteservicehistory")
	public String deleteservicehistory(@RequestBody String deleteservicehistory){
		//请求参数                       变量(json格式)
    JsonParser jsonparse =new JsonParser();  //创建json解析器
    JsonObject json=(JsonObject) jsonparse.parse(deleteservicehistory);  //创建jsonObject对象
    //将json数据转为为String型的数据   
    String vehiclenum = json.get("vehiclenum").getAsString(); 
    String deldate = json.get("deldate").getAsString();
    //System.out.println(userName);		
    ServiceHistory servicehistory=new ServiceHistory();
    servicehistory.setVehiclenum(vehiclenum);
    servicehistory.setDate(deldate);
    String result=servicehistoryService.deleteServicehistory(servicehistory);		
    return result;
 }  
}
