package com.TechMahindra.SmartCommute.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TechMahindra.SmartCommute.Domain.Vehicle;
import com.TechMahindra.SmartCommute.Service.VehicleService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping("/vehicle")
	public String vehicle(@RequestBody String vehicleInfo){
						//请求参数                       变量(json格式)
		//System.out.println(vehicleInfo);
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(vehicleInfo);  //创建jsonObject对象
		//将json数据转为为String型的数据
		String userName = json.get("userName").getAsString();     
		String vehiclenum = json.get("vehiclenum").getAsString(); 
		String brand = json.get("brand").getAsString();
		String model = json.get("model").getAsString();
		String color = json.get("color").getAsString();
		Vehicle vehicle=new Vehicle();
		vehicle.setUserName(userName);
		vehicle.setVehiclenum(vehiclenum);
		vehicle.setBrand(brand);
		vehicle.setColor(color);
		vehicle.setModel(model);
		
		String result=vehicleService.insertVehicle(vehicle);		
		return result;
	}
	
	@RequestMapping("/delvehicle")
	public String delvehicle(@RequestBody String delvehicle){
						//请求参数                       变量(json格式)
		//System.out.println(vehicleInfo);
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(delvehicle);  //创建jsonObject对象
		//将json数据转为为String型的数据   
		String vehiclenum = json.get("vehiclenum").getAsString(); 
		//System.out.println(vehiclenum);		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehiclenum(vehiclenum);
		
		String result=vehicleService.deleteVehicle(vehicle);		
		return result;
	}   
	
	@RequestMapping("/checkvehicle")
	public String checkvehicle(@RequestBody String checkvehicle){
						//请求参数                       变量(json格式)
		//System.out.println(vehicleInfo);
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(checkvehicle);  //创建jsonObject对象
		//将json数据转为为String型的数据   
		String userName = json.get("userName").getAsString(); 
		//System.out.println(userName);		
		Vehicle vehicle=new Vehicle();
		vehicle.setUserName(userName);
		
		String result=vehicleService.checkVehicle(vehicle);		
		return result;
	}    
	@RequestMapping("/selectvehicle")
	public String selectvehicle(@RequestBody String selectvehicle){
						//请求参数                       变量(json格式)
		//System.out.println(vehicleInfo);
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(selectvehicle);  //创建jsonObject对象
		//将json数据转为为String型的数据   
		String vehiclenum = json.get("vehiclenum").getAsString(); 
		//System.out.println(userName);		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehiclenum(vehiclenum);
		
		String result=vehicleService.selectVehicle(vehicle);		
		return result;
	}  
	@RequestMapping("/updatevehicle")
	public String updatevehicle(@RequestBody String uvehicleInfo){
						//请求参数                       变量(json格式)
		JsonParser jsonparse =new JsonParser();  //创建json解析器
		JsonObject json=(JsonObject) jsonparse.parse(uvehicleInfo);  //创建jsonObject对象
		//将json数据转为为String型的数据
		String userName = json.get("userName").getAsString();     
		String vehiclenum = json.get("vehiclenum").getAsString(); 
		String brand = json.get("brand").getAsString();
		String model = json.get("model").getAsString();
		String color = json.get("color").getAsString();
		Vehicle vehicle=new Vehicle();
		vehicle.setUserName(userName);
		vehicle.setVehiclenum(vehiclenum);
		vehicle.setBrand(brand);
		vehicle.setColor(color);
		vehicle.setModel(model);
		
		String result=vehicleService.updateVehicle(vehicle);		
		return result;
	}          
}
