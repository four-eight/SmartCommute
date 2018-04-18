package com.TechMahindra.SmartCommute.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicehistory")
public class ServiceHistory {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer serviceId;	
	private String vehiclenum;
	private String servicecenter;
	private String date;
	private String services;
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getVehiclenum() {
		return vehiclenum;
	}
	public void setVehiclenum(String vehiclenum) {
		this.vehiclenum = vehiclenum;
	}
	public String getServicecenter() {
		return servicecenter;
	}
	public void setServicecenter(String servicecenter) {
		this.servicecenter = servicecenter;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
}
