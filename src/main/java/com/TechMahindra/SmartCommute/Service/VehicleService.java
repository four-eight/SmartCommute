package com.TechMahindra.SmartCommute.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMahindra.SmartCommute.Dao.VehicleRepository;
import com.TechMahindra.SmartCommute.Domain.Vehicle;
import com.google.gson.Gson;




@Service
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepository;
	public String insertVehicle(Vehicle vehicle) {
		try {
			List<Vehicle> vehicles = vehicleRepository.findAll();
			for (Vehicle vehicleSigle : vehicles) {
				if (vehicle.getVehiclenum().equals(vehicleSigle.getVehiclenum())) {
					return "repeat";
				}
			}
			vehicleRepository.save(vehicle);
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "SaveSuccess";
	}
	
	public String deleteVehicle(Vehicle vehicle){
		try {
			vehicleRepository.deleteByVehiclenum(vehicle.getVehiclenum());
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "DeleteSuccess";
	}
	
	public String checkVehicle(Vehicle vehicle){
		try{
			List<Vehicle> vehicles=vehicleRepository.findByUserName(vehicle.getUserName());
			Gson gson=new Gson();
			String jsonData=gson.toJson(vehicles);
			System.out.println(jsonData);
			return jsonData;	 
		}catch (Exception e) {
			System.out.println(e);
			return "error";
		}
	}
	
	public String selectVehicle(Vehicle vehicle){
		try{
			List<Vehicle> vehicles = vehicleRepository.findAll();			
			for (Vehicle vehicleSigle : vehicles) {
				if (vehicle.getVehiclenum().equals(vehicleSigle.getVehiclenum())) {
					Gson gson=new Gson();
					String jsonData=gson.toJson(vehicleSigle, Vehicle.class);
					System.out.println(jsonData);
					return jsonData;
				}
			}
		}catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "nocar";
	}
	
	public String updateVehicle(Vehicle vehicle) {
		try {
			List<Vehicle> vehicles = vehicleRepository.findAll();
			for (Vehicle vehicleSigle : vehicles) {
				if (vehicle.getVehiclenum().equals(vehicleSigle.getVehiclenum())) {
					vehicleRepository.deleteByVehiclenum(vehicle.getVehiclenum());
				}
			}
			vehicleRepository.save(vehicle);
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "SaveSuccess";
	}        
}
