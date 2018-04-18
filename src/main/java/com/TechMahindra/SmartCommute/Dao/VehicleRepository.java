package com.TechMahindra.SmartCommute.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.TechMahindra.SmartCommute.Domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	@Transactional
	List<Vehicle> deleteByVehiclenum(String Vehiclenum);
	List<Vehicle> findByUserName(String userName);
}
