package com.example.demo.service.manufacturer;

import com.example.demo.model.Manufacturer;
import com.example.demo.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManufacturerService implements IManufacturer{
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Iterable<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public void save(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }

}
