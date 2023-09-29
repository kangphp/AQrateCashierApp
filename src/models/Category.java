package models;

public class Category {
    private String catID;
    private String catName;
    
    public Category(String id, String name)
    {
        this.catID = id;
        this.catName = name;
    }
    
    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }
    
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
