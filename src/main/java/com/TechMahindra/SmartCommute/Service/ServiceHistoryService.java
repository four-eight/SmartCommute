package com.TechMahindra.SmartCommute.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMahindra.SmartCommute.Dao.ServiceHistoryRepository;
import com.TechMahindra.SmartCommute.Domain.ServiceHistory;
import com.google.gson.Gson;


@Service
public class ServiceHistoryService {
	@Autowired
	ServiceHistoryRepository servicehistoryRepository;
	public String insertServicehistory(ServiceHistory servicehistory) {
		try {
			List<ServiceHistory> servicehistorys = servicehistoryRepository.findAll();
			for (ServiceHistory servicehistorySigle : servicehistorys) {
				if (servicehistory.getVehiclenum().equals(servicehistorySigle.getVehiclenum())) {
				 if (servicehistory.getDate().equals(servicehistorySigle.getDate())) {
					return "repeat";
				}
			}
			}
			servicehistoryRepository.save(servicehistory);
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "SaveSuccess";
	}
	
	public String selectServicehistory(ServiceHistory servicehistory) {
		try {
			List<ServiceHistory> servicehistorys = servicehistoryRepository.findAll();			
			for (ServiceHistory servicehistorySigle : servicehistorys) {
				if (servicehistory.getVehiclenum().equals(servicehistorySigle.getVehiclenum())) {
					if (servicehistory.getDate().equals(servicehistorySigle.getDate())) {
					Gson gson=new Gson();
					String jsonData=gson.toJson(servicehistorySigle, ServiceHistory.class);
					System.out.println(jsonData);
					return jsonData;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "SelectFailed";
	}
	
	public String deleteServicehistory(ServiceHistory servicehistory) {
		try {
			List<ServiceHistory> servicehistorys = servicehistoryRepository.findAll();			
			for (ServiceHistory servicehistorySigle : servicehistorys) {
				if (servicehistory.getVehiclenum().equals(servicehistorySigle.getVehiclenum())) {
					if (servicehistory.getDate().equals(servicehistorySigle.getDate())) {
					servicehistoryRepository.deleteByVehiclenum(servicehistory.getVehiclenum());
					return "DeleteSuccess";
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "DeleteFailed";
	}
}
