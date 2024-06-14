package com.devsuperior.workshopcassandra.controllers;

import com.devsuperior.workshopcassandra.model.dto.ProductDTO;
import com.devsuperior.workshopcassandra.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
        ProductDTO obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
}