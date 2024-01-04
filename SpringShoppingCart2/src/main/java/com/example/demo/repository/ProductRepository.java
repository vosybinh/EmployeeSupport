package com.example.demo.repository;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
import com.example.demo.form.ProductForm;



@Repository
public class ProductRepository {
	
	@Autowired
	SessionFactory productFactory;
	
	public Product save1(ProductForm productForm) {
		 
        Session session = this.productFactory.getCurrentSession();
        String code = productForm.getCode();
 
        Product product = null;

            product = new Product();
            product.setCreateDate(new Date());
        
        product.setCode(code);
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
 
        if (productForm.getFileData() != null) {
            byte[] image = null;
            try {
                image = productForm.getFileData().getBytes();
            } catch (IOException e) {
            }
            if (image != null && image.length > 0) {
                product.setImage(image);
            }
        }
            session.persist(product);
        
        // If error in DB, Exceptions will be thrown out immediately
        session.flush();
        
        
        return product;
    }

}
