/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.hyunseda.market.service;

import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.domain.acess.IProductRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura Sofia
 */
public class ProductService {
    
    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
    private IProductRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IProductRepository
     */
    public ProductService(IProductRepository repository) {
        this.repository = repository; //NO HAY  new
                                       //Se hace por inyección de dependencia
    }

    public double calculateProductTax(Product product) {

        //Validate product.
        if (product == null) {
            return 0;
        }
        double TAX = 0.19d;
        double productTax = product.getProductPrice() * TAX;
        return productTax;
    }

    public boolean saveProduct(int productId,String productName,String productDescripcion) {

        //Validate product
        Product newProduct = new Product();
        newProduct.setProductId(productId);
        newProduct.setProductName(productName);
        newProduct.setProductDescripcion(productDescripcion);
        
        if (newProduct.getProductId() < 0 || newProduct.getProductName().isEmpty()) {
            return false;
        }
        repository.save(newProduct);
       return true;
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        products = repository.findAll();

        return products;
    }
    
    public boolean editProduct(int productId, Product prod) {
        
        //Validate product
        if (prod == null || prod.getProductName().isEmpty() ) {
            return false;
        }
        repository.edit(productId, prod);
        return true;
    }
    public boolean deleteProduct(int productId){
        return repository.delete(productId);
    }
    
    public List<Product> findAllProducts() {
         List<Product> products = new ArrayList<>();
         products = repository.findAll();

         return products;
     }
    
    /*public List<Product> findAllProducts() {
        return product.findAll();
    }*/
    
   public Product findProductById(int productId) {
        return repository.findById(productId);
    }

    
}
