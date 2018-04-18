package com.TechMahindra.SmartCommute.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechMahindra.SmartCommute.Dao.TripHistoryRepository;
import com.TechMahindra.SmartCommute.Domain.TripHistory;
import com.google.gson.Gson;

@Service
public class TripHistoryService {
	@Autowired
	TripHistoryRepository tripHistoryRepository;

	// 插入数据
	public String insertTrip(TripHistory tripHistory) {
		try {
			List<TripHistory> tripHistories = tripHistoryRepository.findAll();
			for (TripHistory tripHistorySigle : tripHistories) {
				if (tripHistory.getStartDate().equals(tripHistorySigle.getStartDate())) {
					return "dateRepeat";
				}
			}
			tripHistoryRepository.save(tripHistory);
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "success";
	}

	// 查询   deleteTrip
	public String selectTrip(TripHistory tripHistory) {
		try {
			List<TripHistory> tripHistories = tripHistoryRepository.findAll();			
			for (TripHistory tripHistorySigle : tripHistories) {
				if (tripHistory.getUserName().equals(tripHistorySigle.getUserName())) {
					if (tripHistory.getStartDate().equals(tripHistorySigle.getStartDate())) {
						//把匹配的数据变成json格式返回
						Gson gson=new Gson();
						String jsonData=gson.toJson(tripHistorySigle, TripHistory.class);
						return jsonData;
					}
				}
			}
		} catch (Exception e) {
			return "error";
		}
		return "dateError";
	}
	// 删除   
	public String deleteTrip(TripHistory tripHistory) {
		try {
			tripHistoryRepository.deleteByUserName(tripHistory.getUserName());
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "deleteSuccess";
	}
}
