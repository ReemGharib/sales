package com.sales.sales.controller;

import com.sales.sales.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("products")
@Controller
public class ProductController {

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<>();
    }
}
