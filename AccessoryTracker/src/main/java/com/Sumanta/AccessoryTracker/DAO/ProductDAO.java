package com.Sumanta.AccessoryTracker.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Sumanta.AccessoryTracker.Entity.Product;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductDAO extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product>  {
	@Modifying
    @Transactional
    @Query("UPDATE Product p SET p.warranty = :warranty WHERE p.id = :id")
    void updateWarrantyByid(@Param("id") String id, @Param("warranty") String warranty);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.place = :place WHERE p.id = :id")
    void updatePlaceByid(@Param("id") String id, @Param("place") String place);
}
