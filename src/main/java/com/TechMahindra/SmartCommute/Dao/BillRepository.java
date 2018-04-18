package com.TechMahindra.SmartCommute.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.TechMahindra.SmartCommute.Domain.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{
	@Transactional
	List<Bill> deleteByTripId(String tripId);
	//public Bill findByTripId(String tripId);
}
