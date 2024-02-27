package com.blueyonder.shopservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.shopservice.entity.Category;
import com.blueyonder.shopservice.entity.Product;

import com.blueyonder.shopservice.exceptions.ProductNotFoundException;
import com.blueyonder.shopservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository prodrepo;
	
	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	public Product addProduct(Product Product) {
		logger.info("Product created successfully...");
		return prodrepo.save(Product);
	}

	@Override
	public String deleteProductById(Integer ProductId) throws ProductNotFoundException {
		
		Product c = getProductById(ProductId);
		if(c!=null) {
			prodrepo.deleteById(ProductId);
			logger.info("product deleted successfully...(deleteProductById)");
			return "Product deleted successfully...";
		}else {
			logger.error("Product not present...(deleteProductById)");
			throw new ProductNotFoundException();
		}
	}

	@Override
	public Iterable<Product> ListAllProduct() {
		Iterable<Product> prod= prodrepo.findAll();
		return prod;
	}

	@Override
	public Product getProductById(Integer ProductId) throws ProductNotFoundException {
		Optional<Product> prod = prodrepo.findById(ProductId);
		if(prod.isPresent()) {
			logger.info("product present ...(getProductById)");
			return prod.get();
		}
		logger.error("Product not present...(getProductById)");
		throw new ProductNotFoundException();
	}

	@Override
	public Product getProductByName(String cname) throws ProductNotFoundException {
		Product p = prodrepo.findProductByName(cname);
		 if(p!=null) {
			 logger.info("product present ...(getProductByName)");
			return p;
		}else {
			logger.error("Product not present...(deleteProductById)");
			throw new ProductNotFoundException();
		}
	}

}
