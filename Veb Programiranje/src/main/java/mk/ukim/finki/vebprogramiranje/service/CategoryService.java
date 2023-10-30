package mk.ukim.finki.vebprogramiranje.service;

import mk.ukim.finki.vebprogramiranje.model.Category;

import java.util.List;

public interface CategoryService {
    Category create(String name, String description);
    Category update(String name, String description) ;
    void delete(String name) throws RuntimeException;
    List<Category> listCategories();
    List<Category> searchCategories(String searchText);
}
