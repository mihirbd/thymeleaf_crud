package com.idb.mvccrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idb.mvccrud.entity.Product;

@Repository
public interface  ProductRepository extends JpaRepository<Product, Long> {

}
