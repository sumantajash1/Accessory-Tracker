package com.Sumanta.AccessoryTracker.Service;

import com.Sumanta.AccessoryTracker.DAO.requiredLogDAO;
import com.Sumanta.AccessoryTracker.Entity.RequestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class ReqLogService {
    @Autowired
    private requiredLogDAO dao;
    @Autowired
    private RequestLog requestLog;
    @Autowired
    ProductService productService;

    public void logUpdate(String productId, String employeeId, String updatedPlace) {
        requestLog.setProductIdReq(productId);
        requestLog.setEmployeeId(employeeId);
        requestLog.setInitialPlace(productService.getInitialPlaceFromId(productId));
        requestLog.setTargetPlace(updatedPlace);
        requestLog.setDateTime(new Date().toString());
        requestLog.setRecieveStatus("true");
        System.out.println("Request Log Object --> " + requestLog);
        dao.save(requestLog);
    }
}
