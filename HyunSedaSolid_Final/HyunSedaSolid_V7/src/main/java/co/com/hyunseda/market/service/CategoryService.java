package co.com.hyunseda.market.service;

import co.com.hyunseda.market.domain.Category;
import co.com.hyunseda.market.domain.acess.ICategoryRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura Sofia
 */
public class CategoryService {
    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
    private ICategoryRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de IProductRepository
     */
    public CategoryService(ICategoryRepository repository) {
        this.repository = repository; //NO HAY  new
                                       //Se hace por inyección de dependencia
    }

    public boolean saveCategory(int categoryId,String categoryName) {
        
         //Validate product
        Category newCategory = new Category();
        newCategory.setCategoryId(categoryId);
        newCategory.setCategoryName(categoryName);

        //Validate product
        if (newCategory == null || newCategory.getCategoryId() < 0 || newCategory.getCategoryName().isBlank()) {
            return false;
        }

        repository.save(newCategory);
        return true;
    }

    public List<Category> listCategory() {
        List<Category> categories  = new ArrayList<>();
        categories = repository.findAll();// mirrar

        return categories;
    }

    
    
}
