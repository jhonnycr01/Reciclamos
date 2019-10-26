package model;
    /**
     * this is class conteins the residues information
     */
public class Residuos {
    /**
     * Identification of the residue
     */
    protected String id;
    /**
     * Name of the residue
     */
    protected String name;
     /**
     * Origen of the residue
     */
    protected String origen;
    /**
     * Color of the residue
     */
    protected String color;
    /**
     * time it takes to decompose
     */
    protected int time;
    /**
     * Product that generates this residue
     */
    protected Products product;
    /**
     * Category of the residue
     */
    protected String category;
    /**
     * this is the contructor method
     */
    public Residuos(){

    }
    /**
     * This constructor method initialize the attributes of the class
     * @param id Identification
     * @param name Name of the residue
     * @param origen Origin of the residue
     * @param color Color of the residue
     * @param time Time it takes to decompose
     * @param category Category of the residue
     */
    public Residuos( String id, String name, String origen, String color, int time,String category) {
        this.id = id;
        this.name = name;
        this.origen = origen;
        this.color = color;
        this.time = time;
        this.category= category;
    }
    /**
     * This method gives the identification of the residue
     * @return this method return the identification of the residue
     */
    public String getId() {
        return id;
    }
    /**
     * This method changes the identification of the residue
     * @param id new identification of the residue
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * This method gives the name of the residue
     * @return this method return the name of the residue
     */
    public String getName() {
        return name;
    }
    /**
     * This method changes the name of the residue
     * @param name new name of the residue
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method gives the origin of the residue
     * @return this method return the origin of the residue
     */
    public String getOrigen() {
        return origen;
    }
    /**
     * This method changes the origin of the residue
     * @param origen new origin of the residue
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    /**
     * This method gives the color of the residue
     * @return this method return the color of the residue
     */
    public String getColor() {
        return color;
    }
    /**
     * This method changes the color of the residue
     * @param color new color of the residue
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * This method gives the time to it takes to decompose
     * @return this method return the time to it takes to decompose
     */
    public int getTime() {
        return time;
    }
    /**
     * This method changes the time attribute
     * @param time new time
     */
    public void setTime(int time) {
        this.time = time;
    }
    /**
     * This method gives the product of the residue
     * @return this method return the product of the residue
     */
    public Products getProduct() {
        return product;
    }
    /**
     * This method changes the product attribute
     * @param producut new product
     */
    public void setProduct(Products producut) {
        this.product = producut;
    }
    /**
     * this method shows the attributes of a residue on screen and it will be used by {@link Biodegradables#showSpecialAtributes()} and {@link Reciclable#showSpecialAtributes()} to show its special atributes on screen
     */
    public void showSpecialAtributes(){
       if(product!=null){
        System.out.println ("\nResidue name: "+ name+"\n"
        +"Identification: "+ id+"\n"
        +"Origen: "+ origen +"\n"
        +"Time to decompose(days): "+ time+"\n"
        +"Color : "+ color+"\n"
        +"Category : "+ category+"\n"
        +"Product Name : "+ product.getName()+"\n"
        +"Product Description : "+ product.getDescription());
       }else{
           System.out.println("First you have to assign a producto to this residue");
       }
    }
    /**
     * This method changes the category attribute
     * @param category new new category
     */
    public void setCategory(String category){
        this.category=category;
    }

     /**
     * This method gives the category of the residue
     * @return this method return the category of the residue
     */
    public String getCategory(){
        return category;
    }
    /**
     * this method calculate the damaging effect of a residue
     * @return the number of the damaging effect
     */
    public double calculateDamaginEfect(){
        double result=0;
        result= time * validatePercentage();
        return result;
    }
    /**
     * This method validates the origen of the residue and return the percentage of this origin
     * @return  return the percentage accorind to the origin of the residue
     */
    public double validatePercentage(){
        double result=0;
        if(origen.equalsIgnoreCase("Industrial")){
            result=0.1;
        }else if(origen.equalsIgnoreCase("House waste")){
            result=0.05;
        }else if(origen.equalsIgnoreCase("Contruction")){
            result=0.08;
        }else if(origen.equalsIgnoreCase("Municipal")){
            result=0.12;
        }
        else{
            result=0.15;
        }
        return result;
    }
     /**
     * this method will be used by {@link Biodegradables#isUsable()} and {@link Reciclable#isUsable()} to know its they are usable
     * @return this method return true if its usable false otherwise
     * */
     public boolean isUsable(){
        boolean result=false;
        return result;
    }


}