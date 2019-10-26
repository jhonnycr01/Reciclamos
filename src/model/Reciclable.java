package model;
 /**
     * This class is a residue type (Recyclable)
     */
public class Reciclable extends Residuos {
    /**
     * Type of residue
     */
    private String type;
    /**
     * Description of the residue
     */
    private String description;
    /**
     * this is the contructor method
     */
    public Reciclable() {
        super();
    }
    /**
     * This constructor method initialize the attributes of the class
     * @param id Identification
     * @param name Name of the residue
     * @param origen Origin of the residue
     * @param color Color of the residue
     * @param time Time it takes to decompose
     * @param type type of residue 
     * @param description Description of the residue
    * @param category Category of the residue
     */
    public Reciclable(String id, String name, String origen, String color, int time,String type, String description,String category) {
        super(id, name, origen, color, time,category);
        this.type = type;
        this.description = description;
    }
    /**
     * This method gives the Type attribute
     * @return this method return the type attribute
     */
    public String getType() {
        return type;
    }
    /**
     * This method gives the descrption attribute
     * @return this method return the descrption attribute
     */
    public String getDescription() {
        return description;
    }
    /**
     * This method changes the type attribute
     * @param type new type attribute
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
    * This method changes the description attribute
    * @param description new descrption attribute
    */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * his method shows on screen the type and description of the residue
     */
  @Override
    public void showSpecialAtributes() {
        super.showSpecialAtributes();
        if(product!=null){
            System.out.println("Type: "+type+"\n" 
            +"Description : "+ description);
        }
     }
     /**
     * This method validates deduce 2% from de damaging effect
     */   
    @Override
    public double validatePercentage() {
        double result=super.validatePercentage();
            result=result-0.02;
        return result;
    }
    @Override
     /**
     * This method validates if its usable, it's true when the descrption is not empty
     */   
    public boolean isUsable() {
        boolean result=super.isUsable();
        if(description!=null){
            result=true;
        }
        return result;
    }

}