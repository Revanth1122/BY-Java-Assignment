package com.blueyonder.shopservice.service;

import com.blueyonder.shopservice.entity.Product;
import com.blueyonder.shopservice.exceptions.ProductNotFoundException;

public interface ProductService {
	
	public Product addProduct(Product Product);
	public String deleteProductById(Integer ProductId) throws ProductNotFoundException;
//	public Product updateProductById(Integer ProductId);
//	public Product updateProductByName(String ProductName);
	public Iterable<Product> ListAllProduct();
	public Product getProductById(Integer ProductId)throws ProductNotFoundException;
	public Product getProductByName(String cname)throws ProductNotFoundException;
}
