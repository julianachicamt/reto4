package com.intento4.intento4.Servicio;

import com.intento4.intento4.Modelo.Category;
import com.intento4.intento4.Repositorio.CategoryRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio;
    
    public List<Category> getAll() {
        return categoryRepositorio.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return categoryRepositorio.getCategory(categoryId);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepositorio.save(category);
        } else {
            Optional<Category> category1 = categoryRepositorio.getCategory(category.getId());
            if (category1.isPresent()) {
                return category;
            } else {
                return categoryRepositorio.save(category);
            }
        }
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g= categoryRepositorio.getCategory(category.getId());
            if(g.isPresent()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                categoryRepositorio.save(g.get()); 
                return g.get();
            }else{
                return category;
            }

        }else{
            return category;
        }
    }
    
    

    
    public boolean deleteCategory (int id){
        Boolean d = getCategory(id).map(category -> {
            categoryRepositorio.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
    

    
}
