package com.Sumanta.AccessoryTracker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeerequestlog")
public class RequestLog {
    @Column(name = "employeeid")
    String employeeId;
    @Column(name = "productidreq")
    String productIdReq;
    @Column(name = "datetime")
    String dateTime;
    @Column(name = "recievestatus")
    String recieveStatus;

    public RequestLog() {
    }

    public RequestLog(String employeeId, String productIdReq, String dateTime, String recieveStatus) {
        this.employeeId = employeeId;
        this.productIdReq = productIdReq;
        this.dateTime = dateTime;
        this.recieveStatus = recieveStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getProductIdReq() {
        return productIdReq;
    }

    public void setProductIdReq(String productIdReq) {
        this.productIdReq = productIdReq;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getRecieveStatus() {
        return recieveStatus;
    }

    public void setRecieveStatus(String recieveStatus) {
        this.recieveStatus = recieveStatus;
    }

    @Override
    public String toString() {
        return "RequestLog{" +
                "employeeId='" + employeeId + '\'' +
                ", productIdReq='" + productIdReq + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", recieveStatus='" + recieveStatus + '\'' +
                '}';
    }
}

