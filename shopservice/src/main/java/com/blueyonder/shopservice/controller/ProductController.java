package com.blueyonder.shopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.shopservice.entity.Product;

import com.blueyonder.shopservice.exceptions.ProductNotFoundException;

import com.blueyonder.shopservice.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/ecommerce/api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService prodservice;
	
	@PostMapping("/add-product")
	public ResponseEntity<Product> addproduct(@RequestBody Product product) {
		Product p= prodservice.addProduct(product);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
		
	}
	@GetMapping("/delete-product")
	public String deleteproductById(@RequestParam(name="id")Integer productId) throws ProductNotFoundException{
		return prodservice.deleteProductById(productId);
	}
	
	@GetMapping("/all-product")
	public Iterable<Product> ListAllproduct(){
		Iterable<Product> listproduct = prodservice.ListAllProduct();
		return listproduct;
	}
	@GetMapping("/get-product")
	public ResponseEntity<Product> getproductById(@RequestParam(name="id") Integer productId) throws ProductNotFoundException{
		Product p = prodservice.getProductById(productId);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	@GetMapping("/get-product-name")
	public ResponseEntity<Product> getproductByName(@RequestParam(name="name") String cname)throws ProductNotFoundException{
		Product p =  prodservice.getProductByName(cname);
		return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
}
