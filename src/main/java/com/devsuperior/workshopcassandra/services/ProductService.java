package com.devsuperior.workshopcassandra.services;

import com.devsuperior.workshopcassandra.model.dto.ProductDTO;
import com.devsuperior.workshopcassandra.model.entities.Product;
import com.devsuperior.workshopcassandra.repositories.ProductRepository;
import com.devsuperior.workshopcassandra.repositories.ProductRepository;
import com.devsuperior.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO findById(UUID id) {
        Product entity = getById(id);
        return new ProductDTO(entity);
    }

    private Product getById(UUID id) {
        Optional<Product> result = repository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
    }

}