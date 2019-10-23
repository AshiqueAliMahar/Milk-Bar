package milkbar.model;

import java.util.List;

public class Category {
    private String name;
    private List<SubCategory> subcategories;
    public Category() {
    }
    
    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<SubCategory> subcategories) {
        this.name = name;
        
        this.subcategories = subcategories;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubCategory> subcategories) {
        this.subcategories = subcategories;
    }
    
}
