package model;
    /**
     * This class is a residue type (Biodegradable)
     */
public class Biodegradables extends Residuos {
    /**
     * Attribute that says if it works for composting
     */
    private boolean composting;
    /**
     * Constant with a year in days
     */
    static final int year= 365;
    /**
     * this is the contructor method
     */
    public Biodegradables() {
        super();
    }
    /**
     * This constructor method initialize the attributes of the class
     * @param id Identification
     * @param name Name of the residue
     * @param origen Origin of the residue
     * @param color Color of the residue
     * @param time Time it takes to decompose
     * @param composting Boolean saying if its work to composting or not
     * @param category Category of the residue
     */
    public Biodegradables( String id, String name, String origen, String color, int time,boolean composting,String category) {
        super(id, name, origen, color, time,category);
        this.composting = composting;
    }
    /**
     *  This method gives the composting attribute
     * @return this method return the composting attribute
     */
    public boolean getComposting() {
        return composting;
    }
    /**
     * This method changes the composting attribute
     * @param composting new state of the attribute composting
     */
    public void setComposting(boolean composting) {
        this.composting = composting;
    }
    /**
     * This method shows on screen if its composting or not
     */
    @Override
    public void showSpecialAtributes() {
        super.showSpecialAtributes();
        if(product!=null){
            System.out.println("Composting: "+ composting );
        }
   }
    /**
     * This method validates if it works for composting, when true it deduce 1% from de damaging effect
     */
    @Override
    public double validatePercentage() {
        double result=super.validatePercentage();
        if(composting){
            result=result-0.01;
        }
        return result;
    }
    /**
     * This method validates if its usable, it's true when the time to decompose is less than a year and it works for composting
     */
    @Override
    public boolean isUsable() {
        boolean result=super.isUsable();
        if(time<year&&composting){
            result=true;
        }
        return result;
    }

}