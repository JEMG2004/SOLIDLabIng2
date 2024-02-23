/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.com.hyunseda.market.domain.acess;

import co.com.hyunseda.market.domain.Category;
import java.util.List;

/**
 *
 * @author Laura Sofia
 */
public interface ICategoryRepository {
    
    boolean save(Category category);
    
    List<Category> findAll();
    
    boolean edit(int categoryId, Category category);
    boolean delete(int categoryId);
    Category findById(int categoryId);
    Category findByName(Long categoryName);
    
}
