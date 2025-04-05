package com.Sumanta.AccessoryTracker.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.Sumanta.AccessoryTracker.Entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product>  {
	
}
