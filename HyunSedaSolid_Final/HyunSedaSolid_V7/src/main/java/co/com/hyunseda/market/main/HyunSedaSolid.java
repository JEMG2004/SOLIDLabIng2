/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.com.hyunseda.market.main;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.domain.acess.Factory;
import co.com.hyunseda.market.domain.acess.IProductRepository;
import co.com.hyunseda.market.domain.acess.ICategoryRepository;
import co.com.hyunseda.market.presentation.GUIMENUPRINCIPAL;
import co.com.hyunseda.market.presentation.GUIProducts;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import java.security.Provider.Service;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Laura Sofia
 */
public class HyunSedaSolid {

    public static void main(String[] args) {
        
      
     /*   ICategoryRepository repositoryCategory = Factory.getInstance().getCategoryRepository("default");
        
        IProductRepository repository = Factory.getInstance().getProductRepository("default");
        ProductService service = new ProductService(repository);
        

        GUIMENUPRINCIPAL guiMenuPrincipal = new GUIMENUPRINCIPAL(service);
        guiMenuPrincipal.setSize(400, 300);
        guiMenuPrincipal.setVisible(true);*/
        
       /*//Le decimos a la fábrica que nos de el repositorio por defecto
        IProductRepository repository = Factory.getInstance().getProductRepository("default");
        ProductService service = new ProductService(repository);//llama a servivios y pasa el repositorio

        Product newProduct = new Product(1, "Product One", "10d");
        service.saveProduct(newProduct);

        newProduct = new Product(2, "Product Two", "50");
        service.saveProduct(newProduct);
        
        
        for (Product p : service.listProducts()) {
            System.out.println(p);
        }*/
    Scanner scanner = new Scanner(System.in);  
    IProductRepository repository = Factory.getInstance().getProductRepository("default");
    ProductService service = new ProductService(repository);
   
    GUIMENUPRINCIPAL guiMenuPrincipal = new GUIMENUPRINCIPAL(service);
    //GUIProducts guiMenuPrincipal = new GUIProducts(service);
     guiMenuPrincipal.setSize(400, 300);
     guiMenuPrincipal.setVisible(true);
        
    System.out.println("Ingrese el id del producto");
    int productId = scanner.nextInt();
    System.out.println("Ingrese el nomnre del producto");
    String nombre = scanner.next();
    
    System.out.println("Ingrese la descipcion del producto");
    String descripcion  = scanner.next();
    
    //Product newProduct = new Product(productId,nombre,descripcion);
    service.saveProduct(productId,nombre,descripcion);

    List<Product> productList = service.listProducts();

    if (productList.isEmpty()) {
        System.out.println("La lista de productos está vacía.");
    } else {
        for (Product p : productList) {
            System.out.println(p);
        }
    }
    
    
    /*ICategoryRepository repositoryC = Factory.getInstance().getCategoryRepository("default");
    CategoryService serviceC = new CategoryService(repositoryC);

    Category newCategory = new Category(1, "Product One");
    serviceC.save(newCategory);

    newCategory = new Category(2, "Product Two");
    serviceC.save(newCategory);

    List<Category> categoryList = serviceC.listCategory();

    if (categoryList.isEmpty()) {
        System.out.println("La lista de Categoria está vacía.");
    } else {
        for (Category p : categoryList) {
            System.out.println(p);
        }
    }*/
}
}