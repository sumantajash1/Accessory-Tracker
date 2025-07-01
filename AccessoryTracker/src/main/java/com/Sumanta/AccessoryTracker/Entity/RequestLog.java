package com.Sumanta.AccessoryTracker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "employee_request_logs")
public class RequestLog {
    @Id
    @Column(name = "employeeid")
    String employeeId;
    @Column(name = "productidreq")
    String productIdReq;
    @Column(name = "initialplace")
    String initialPlace;
    @Column(name = "targetplace")
    String targetPlace;
    @Column(name = "datetime")
    String dateTime;
    @Column(name = "recievestatus")
    String recieveStatus;

    public RequestLog() {

    }

    public RequestLog(String employeeId, String productIdReq, String initialPlace, String targetPlace, String dateTime, String recieveStatus) {
        this.employeeId = employeeId;
        this.productIdReq = productIdReq;
        this.initialPlace = initialPlace;
        this.targetPlace = targetPlace;
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

    public String getInitialPlace() {
        return initialPlace;
    }

    public void setInitialPlace(String initialPlace) {
        this.initialPlace = initialPlace;
    }

    public String getTargetPlace() {
        return targetPlace;
    }

    public void setTargetPlace(String targetPlace) {
        this.targetPlace = targetPlace;
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
                ", initialPlace='" + initialPlace + '\'' +
                ", targetPlace='" + targetPlace + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", recieveStatus='" + recieveStatus + '\'' +
                '}';
    }
}

