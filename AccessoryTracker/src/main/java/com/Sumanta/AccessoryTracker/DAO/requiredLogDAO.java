package com.Sumanta.AccessoryTracker.DAO;

import com.Sumanta.AccessoryTracker.Entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface requiredLogDAO extends JpaRepository<RequestLog, String> {
}
