package model;
    /**
     * This class has the information of the product that generates a residue
     */
public class Products {
    /**
     * identification of the product
     */
    private String id;
    /**
     * name of the product
     */
    private String name;
       /**
     * Description of the product
     */
    private String description;
    /**
     * This constructor method initialize the attributes of the class
     * @param id identification of the product
     * @param name name of the product
     * @param description Description of the product
     */
    public Products(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    /**
     * This method gives the identification attribute
     * @return This method gives the identification attribute
     */
    public String getId() {
        return id;
    }
    /**
     *  This method changes the identification attribute
     * @param id new Identification attribute
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * This method gives the name attribute
     * @return This method gives the name attribute
     */
    public String getName() {
        return name;
    }
    /**
    * This method changes the name attribute
    * @param name new Name attribute
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method gives the Description attribute
     * @return This method gives the Description attribute
     */
    public String getDescription() {
        return description;
    }
    /**
     * This method changes the Description attribute
     * @param description new Description attribute
     */
    public void setDescription(String description) {
        this.description = description;
    }

}