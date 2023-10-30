package mk.ukim.finki.vebprogramiranje.service.impl;

import mk.ukim.finki.vebprogramiranje.model.Category;
import mk.ukim.finki.vebprogramiranje.repository.INMemoryCategoryRepository;
import mk.ukim.finki.vebprogramiranje.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoryService {

    private final INMemoryCategoryRepository categoryRepository;

    public CategoriesServiceImpl(INMemoryCategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }


    @Override
    public Category create(String name, String description){
        if(name==null || name.isEmpty()){
            throw new RuntimeException();
        }
        Category c=new Category(name, description);
        categoryRepository.save(c);
        return c;
    }

    @Override
    public Category update(String name, String description) {
        if(name==null || name.isEmpty()){
            throw new RuntimeException();
        }
        Category c=new Category(name, description);
        categoryRepository.save(c);
        return c;
    }

    @Override
    public void delete(String name)  {
        if(name==null || name.isEmpty()){
            throw new RuntimeException();
        }
        categoryRepository.delete(name);
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String searchText) {
        return categoryRepository.search(searchText);
    }
}
