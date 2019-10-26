package model;
    /**
     * This class is a residue type (Inert)
     */
public class Inertes extends Residuos {
    /**
     * Advide to use this residue
     */
    private String advice;
    /**
     * this is the contructor method
     */
    public Inertes() {
        super();
    }
    /**
     * This constructor method initialize the attributes of the class
     * @param id Identification
     * @param name Name of the residue
     * @param origen Origin of the residue
     * @param color Color of the residue
     * @param time Time it takes to decompose
    * @param advice advide to use this residue
    * @param category Category of the residue
    */
    public Inertes(String id, String name, String origen, String color, int time,String advice,String category) {
        super(id, name, origen, color, time,category);
        this.advice = advice;
    }
    /**
    * This method return the advice attribute
    * @return This method return the advice attribute
    */
    public String getAdvice() {
        return advice;
    }
    /**
    * This method change the advice attribute
    * @param advice new advice attribute
    */
    public void setAdvice(String advice) {
        this.advice = advice;
    }
    /**
     * This method shows on screen the type and description of the residue
     */
  @Override
    public void showSpecialAtributes() {
        super.showSpecialAtributes();
        if(product!=null){
            System.out.println("Advice: " + advice);    
        }

    }

}