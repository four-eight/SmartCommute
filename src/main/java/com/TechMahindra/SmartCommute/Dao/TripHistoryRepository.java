package com.TechMahindra.SmartCommute.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.TechMahindra.SmartCommute.Domain.TripHistory;

public interface TripHistoryRepository extends JpaRepository<TripHistory, Integer>{
	@Transactional
	List<TripHistory> deleteByUserName(String UserName);
}
