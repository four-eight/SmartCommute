package com.TechMahindra.SmartCommute.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TechMahindra.SmartCommute.Dao.BillRepository;
import com.TechMahindra.SmartCommute.Domain.Bill;
import com.google.gson.Gson;

@Service
public class BillService {
	@Autowired
	BillRepository billRepository;
	
	// 插入数据
	public String insertBill(Bill bill) {		
		try {
			List<Bill> bills = billRepository.findAll();
			for (Bill billSigle : bills) {
				if (bill.getUserName().equals(billSigle.getUserName())) {
					billRepository.deleteByTripId(bill.getTripId());
				}
			}	
			billRepository.save(bill);
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "saveSuccess";
	} 
	//查询数据
	public String selectBill(Bill bill) {		
		try {
			List<Bill> bills = billRepository.findAll();
			for (Bill billSigle : bills) {
				if (bill.getUserName().equals(billSigle.getUserName())) {
					if(bill.getTripId().equals(billSigle.getTripId())){
						//把匹配的数据变成json格式返回
						Gson gson=new Gson();
						String jsonData=gson.toJson(billSigle, Bill.class);
						return jsonData;
						
					}
				}
			}	
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		return "noBill";
	} 
}
