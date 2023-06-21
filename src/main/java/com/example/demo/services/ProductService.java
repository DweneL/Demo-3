package com.example.demo.services;

import com.example.demo.dao.ProductDAO;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private ProductDAO productDAO;



    @Autowired
    // to inject the dao inside of it, the dao

    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;

    }

    public List<Product> getAllProducts(){
        return this.productDAO.findAll();
    }

    public Product createProduct(Product product){
        return this.productDAO.save(product);
    }



    // if i find the product return it, if I don't find it its saying give a blank product "new product"
    //or else is like a fallback, if all else fails what do i do?
    public Product getProductById(int id){
        return this.productDAO.findById(id).orElse(new Product());
    }

    public Product getProductByName(String name){
        return this.productDAO.getProductByName(name);
    }


    //No need to add product
    public void deleteProduct(int id){
        this.productDAO.deleteById(id);
    }

    public Product updateProduct(Product product, int id){
        //first we get the product by its id
        Product productToUpdate = this.productDAO.findById(id).orElse(null);


        // if the product doesn't exist its null (when you try to update it) they get a blank product
        //otherwise it will execute the logic that's below
        if(productToUpdate == null){
            return new Product();
        }


        //update the properties you want to update
        //allow users what to update
        productToUpdate.setDiscounted(product.isDiscounted());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setQuantityInStock(product.getQuantityInStock());

        return this.productDAO.save(productToUpdate);
    }

}
