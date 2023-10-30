package mk.ukim.finki.vebprogramiranje.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.vebprogramiranje.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class  DataHolder {
    public static List<Category> categories = new ArrayList();

    @PostConstruct
    public void init(){
        this.categories.add(new Category("Software", "Software categories"));
        this.categories.add(new Category("Books", "Books categories"));
    }
}
