package com.example.demo.controller;

import com.example.demo.model.Manufacturer;
import com.example.demo.service.manufacturer.IManufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/manufacturers")
public class ManufacturerController {
    @Autowired
    private IManufacturer manufacturerService;


    @GetMapping
    public ResponseEntity<Iterable<Manufacturer>> findAll() {
        Iterable<Manufacturer> cityIterable = manufacturerService.findAll();
        return new ResponseEntity<>(cityIterable, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Manufacturer> createNewCity(@RequestBody Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Manufacturer> deleteById(@PathVariable Long id) {
        Optional<Manufacturer> productOptional = manufacturerService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        manufacturerService.delete(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> editCity(@PathVariable Long id, @RequestBody Manufacturer manufacturer) {
        Optional<Manufacturer> cityOptional = manufacturerService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        manufacturer.setId(id);
        manufacturerService.save(manufacturer);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Long id) {
        Optional<Manufacturer> cityOptional = manufacturerService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }
}
