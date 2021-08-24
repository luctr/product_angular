package com.example.demo.repository;

import com.example.demo.model.Manufacturer;
import com.example.demo.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer,Long> {
}
