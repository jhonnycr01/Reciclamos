package model;

import java.util.ArrayList;
    /**
     * this is class conteins the residues and products
     */
public class Reciclamos {
    /**
     * this arryalist will contain the Residues created by the user
     */
    private ArrayList<Residuos> residuost;
    /**
     * this arryalist will contain the Products created by the user
     */
    private ArrayList<Products> productst;
    /**
     * This is the costructor method, allows you to initialize the objects of the class
     */
    public Reciclamos() {
        this.residuost = new ArrayList<Residuos>();
        this.productst = new ArrayList<Products>();
    }
    /**
     * This method allows you to search a residue by its name
     * @param name the name of the residue that you are going to search
     * @return the method return null if there is no residue with this name, return the residue otherwise
     */
    public Residuos searchResiduoName(String name) {
        int i = 0;
        Residuos answer = null;
        do {
            if (!residuost.isEmpty()) {
                if (name.equalsIgnoreCase(residuost.get(i).getName())) {
                    answer = residuost.get(i);
                }
            }
            i++;
        } while (i < residuost.size());
        return answer;
    }
    /**
     * This methos search a residue by the identification of the producto that generates it
     * @param id identification of the product
     * @return the method return null if there is no residue with this identification product, return the residue otherwise
     */
    public Residuos searchProductId(String id) {
        int i = 0;
        Residuos result = null;
        do {
            if (!residuost.isEmpty()&&residuost.get(i).getProduct()!=null) {
                if (id.equalsIgnoreCase(residuost.get(i).getProduct().getId())) {
                    result = residuost.get(i);
                }
            }
            i++;
        } while (i < residuost.size());
        return result;
    }
    /**
     * Show a list of the created products on screen
     */
    public void getAll(){ 
        int i;
        int position=1;
        if (!productst.isEmpty()) {
         for(i=0;i<productst.size();i++){
            System.out.println (position+". "+productst.get(i).getName()+" ---> ID: "+productst.get(i).getId());
            position++;
        }
       }
    }
    /**
 * This method creates a product add it to the arraylist
 * @param id product identification
 * @param name name identification
 * @param description descripcion
 */
    public void createProduct(String id, String name, String description){
        productst.add(new Products(id, name, description));
    }
   /**
    * Create a new residue type biodegradable and add it to the arraylist
     * @param id Identification
     * @param name Name of the residue
     * @param origen Origin of the residue
     * @param color Color of the residue
     * @param time Time it takes to decompose
     * @param composting Boolean saying if its work to composting or not
    */
    
    public void createBiodegradable(String id, String name, String origen, String color, int time,boolean composting){
        residuost.add(new Biodegradables(id, name, origen, color, time, composting,"Biodegradable"));
    }

 /**
  * Create a new residue type Inert and add it to the arraylist
     * @param id Identification
     * @param name Name of the residue
     * @param origen Origin of the residue
     * @param color Color of the residue
     * @param time Time it takes to decompose
    * @param advice advide to use this residue
  */
    
     public void createInert( String id, String name, String origen, String color, int time,String advice){
        residuost.add(new Inertes(id, name, origen, color, time, advice,"Inert"));
    }
/**
 * Create a new residue type Recyclable and add it to the arraylist
     * @param id Identification
     * @param name Name of the residue
     * @param origen Origin of the residue
     * @param color Color of the residue
     * @param time Time it takes to decompose
     * @param type type of residue 
     * @param description Description of the residue
 */
     public void createRecyclable( String id, String name, String origen, String color, int time,String type,String description){
        residuost.add(new Reciclable(id, name, origen, color, time, type,description,"Recyclable"));
    }
    /**
     * This method assigns a product to a residue
     * @param residuo the residue produced by the product
     * @param producto the product that will be assigned
     */
    public void assignProduct(Residuos residuo, Products producto){
        if(searchResiduoName(residuo.getName())!=null){
             searchResiduoName(residuo.getName()).setProduct(producto);;
        }
    }
    /**
     * This method search a prodcut by its identification
     * @param id identification of the product
     * @return the method return null if there is no product with this identification, return the product otherwise 
     */
    public Products searchProduct(String id){
        Products result=null;
        int i;
        if(!productst.isEmpty()){
            for(i=0;i<productst.size();i++){
                if(id.equalsIgnoreCase(productst.get(i).getId())){
                    result=productst.get(i);
                }

            }
        }

        return result;
    }
/**
 * This method generates a report based con a category
 * @param category category report
 */
    public void generateResidueReportBasedOnCategory(String category){
                
            int position=1;
                if(!residuost.isEmpty()){
                for(int i=0;i<residuost.size();i++){
                if(residuost.get(i).getCategory().equalsIgnoreCase(category)&&residuost.get(i).getProduct()!=null){
                    System.out.println(category+"\n   "
                    +position+". "+residuost.get(i).getName()+" - "+residuost.get(i).getOrigen()+" - "+residuost.get(i).getColor()+" - "+residuost.get(i).getTime()+" days to decompose - "+residuost.get(i).getProduct().getName()+" (identificador  - " + residuost.get(i).getProduct().getId()+" - descripcion - "+residuost.get(i).getProduct().getDescription()+")\n   ");
                    position++;
                }
                }
        
        }
    }
    /**
     * This method gives shows on screen a list of the residues listed by damaging effect from highest to lowest in the followin format:
     * # - Residue name
     */
    public void listResiduesByDamaginEffect(){
        double aux=0;
        String auxResult="";
        double[] arrayData= new double[residuost.size()];
        String[] arrayResult= new String[residuost.size()];
        if(!residuost.isEmpty()){
        for(int i=0; i<residuost.size();i++){
            arrayData[i]=residuost.get(i).calculateDamaginEfect();
            arrayResult[i]=residuost.get(i).getName();
        }

        for(int i=0 ; i<residuost.size() ; i++){
               for(int j=0;j<residuost.size()-1;j++){
                   if(arrayData[j]<arrayData[j+1]){

                    aux=arrayData[j+1];
                    arrayData[j+1]=arrayData[j];
                    arrayData[j]=aux;

                    auxResult=arrayResult[j+1];
                    arrayResult[j+1]=arrayResult[j];
                    arrayResult[j]=auxResult;
                   }
               }        
        }

        for(int i=0;i<residuost.size();i++){
            System.out.println(arrayData[i]+" - "+ arrayResult[i]);
        }
    }
    }
}
