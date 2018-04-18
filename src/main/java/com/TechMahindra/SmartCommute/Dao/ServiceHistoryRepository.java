package com.TechMahindra.SmartCommute.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.TechMahindra.SmartCommute.Domain.ServiceHistory;



public interface ServiceHistoryRepository extends JpaRepository<ServiceHistory, Integer>{
	@Transactional
	List<ServiceHistory> deleteByVehiclenum(String Vehiclenum);
}
