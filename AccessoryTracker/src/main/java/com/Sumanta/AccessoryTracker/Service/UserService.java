package com.Sumanta.AccessoryTracker.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Sumanta.AccessoryTracker.DAO.ProductDAO;
import com.Sumanta.AccessoryTracker.Entity.Product;

import jakarta.persistence.criteria.Predicate;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
@Component
public class UserService {
	@Autowired
	ProductDAO dao;
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;

    private Connection conn;
    @PostConstruct
    public void init() {
        try {
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Product product) {
		dao.save(product);
	}

    //@Transactional
    public List<Product> fetch(Product product) {
        List<Product> result = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM product_data WHERE ");
        List<Object> parameters = new ArrayList<>();
        boolean prev = false;
        if (product.getId() != null && !product.getId().isEmpty()) {
            queryBuilder.append("id = ?");
            parameters.add(product.getId());
            prev = true;
        }
        if (product.getName() != null && !product.getName().isEmpty()) {
            if(prev) {
                queryBuilder.append(" AND name = ?");
            } else {
                queryBuilder.append(" name = ?");
                prev = true;
            }
            parameters.add(product.getName());
        }
        if (product.getType() != null && !product.getType().isEmpty()) {
            if(prev) {
                queryBuilder.append(" AND type = ?");
            } else {
                queryBuilder.append(" type = ?");
                prev = true;
            }
            parameters.add(product.getType());
        }
        if (product.getPlace() != null && !product.getPlace().isEmpty()) {
            if(prev) {
                queryBuilder.append(" AND place = ?");
            } else {
                queryBuilder.append(" place = ?");
                prev = true;
            }
            parameters.add(product.getPlace());
        }
        if (product.getWarranty() != null && !product.getWarranty().isEmpty()) {
            if(prev) {
                queryBuilder.append(" AND warranty = ?");
            } else {
                queryBuilder.append(" warranty = ?");
                prev = true;
            }
            parameters.add(product.getWarranty());
        }
        System.out.println(queryBuilder);
        try {
            PreparedStatement prepst = conn.prepareStatement(queryBuilder.toString());
            for (int i = 0; i < parameters.size(); i++) {
                prepst.setObject(i + 1, parameters.get(i));
            }
            
            ResultSet rs = prepst.executeQuery();
            while(rs.next()) {
                Product pr = new Product();
                pr.setId(rs.getString(1));
                pr.setName(rs.getString(2));
                pr.setType(rs.getString(3));
                pr.setPlace(rs.getString(4));
                pr.setWarranty(rs.getString(5));
                result.add(pr);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Product> FetchAll() {
        //List<Product> allProducts = new ArrayList<>();
        //ResultSet rs =  dao.findAll();
        System.out.println("Fetch all entered of service");
        return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public void updateWarranty(String updatedWarranty) {

    }
}
