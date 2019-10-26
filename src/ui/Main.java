package ui;

import java.util.Scanner;

import model.*;
    /**
     * this is the main class, it starts the code
     */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        Reciclamos program;
        int basicOperation;
        String id;
        String nameResidue;
        String nameProduct;
        String origen;
        String color;
        int option;
        int category;
        int time;
        String advice;
        boolean composting;
        String type;
        String description;
        program= new Reciclamos();

        do {
            
            System.out.println("\nWhat operation would yo like to do: (if you would like to exit enter -1)\n\n"
            +   "1. Add a residue \n"
            +   "2. List of regristed products \n"
            +   "3. Add a product \n"
            +   "4. Search information from a residue by name\n"
            +   "5. Search information from a residue by the identification of its product\n"
            +   "6. Assing a residue to a product \n"
            +   "7. generate report of residues \n"
            +   "8. Calculate damaging effect \n"
            +    "9. List residues by damaging effect (From highest to lowest) \n"
            +   "10. Determine if a residue is usable \n");

            basicOperation = reader.nextInt();
            reader.nextLine();
            switch (basicOperation){

            case 1:
            System.out.println("please enter the identification of the residue");
            id = reader.nextLine();
            nameResidue="";
                for(int i=0;i<1;i++){
                System.out.println("please enter the name of the residue");
                nameResidue= reader.nextLine();
                if(program.searchResiduoName(nameResidue)!=null){
                   System.out.println("This name already exists please try another name");
                    i=-1;
                 }
                }
            System.out.println("Please enter the origen of the residue. \n"
            +"1. Industrial.\n"
            +"2. House waste.\n"
            +"3. Contruction.\n"
            +"4. Municipal.\n"
            +"5. Hospital waste.");
            option= reader.nextInt();
            reader.nextLine();
            origen="";

            switch(option){

                case 1:
                origen="Industrial";
                break;
                
                case 2:
                origen="House waste";
                break;

                case 3:
                origen="Contruction";
                break;

                case 4:
                origen="Municipal";
                break;

                case 5:
                origen="Hospital waste";
                break;
            }

            System.out.println("Please enter the color of the residue");
            color=reader.nextLine();

            System.out.println("Please enter the descomposition time of the residue in days");
            time= reader.nextInt();
            reader.nextLine();

            System.out.println("Plese enter the category of the residue.\n" 
            +"1.Inert.\n" 
            +"2.Biodegradable.\n"
            +"3.Recyclable.");
            category=reader.nextInt();
            reader.nextLine();

            switch(category){

                case 1:
                System.out.println("Please enter an advice to reduce its usage");
                advice= reader.nextLine();
                program.createInert(id, nameResidue, origen, color, time, advice);
                break;

                case 2:
                System.out.println("Does it work for composting (Yes/no)");
                if( reader.nextLine().equalsIgnoreCase("Yes")){
                    composting=true;
                }else{
                    composting=false;
                }
                program.createBiodegradable(id, nameResidue, origen, color, time, composting);
                break;

                case 3:
                System.out.println("Plese enter the residues type (Paper, Glass, Plastic...)");
                type= reader.nextLine();

                System.out.println("Please enter the description");
                description= reader.nextLine();
                program.createRecyclable(id, nameResidue, origen, color, time,type,description);
                break;
            }

            break;

            case 2:
            program.getAll();
            break;

            case 3:
            System.out.println("Please enter the identification of the product");
            id= reader.nextLine();
            System.out.println("Please enter the name of the product");
            nameProduct= reader.nextLine();
            System.out.println("Please enter the descrption of the product");
            description= reader.nextLine();
            program.createProduct(id, nameProduct, description);

            break;

            case 4:
            
            System.out.println ("Please enter the name of the residue");
            nameProduct= reader.nextLine();
            if(program.searchResiduoName(nameProduct)!=null){
                    program.searchResiduoName(nameProduct).showSpecialAtributes();
             }
           

            break;

            case 5:

            System.out.println ("Please enter the identification of the product");
            nameProduct= reader.nextLine();
            if(program.searchProductId(nameProduct)!=null){
                    program.searchProductId(nameProduct).showSpecialAtributes();
             }

            break;
            
              case 6:
              id="";
            for(int i=0;i<1;i++){
                System.out.println ("please enter identification of the product");
                id= reader.nextLine();
                if(program.searchProduct(id)==null){
                System.out.println("This identificacion alrady exists please try another one");
                i=-1;
                }
            }
            System.out.println ("Please enter the name of the residue that it produces");
            nameResidue= reader.nextLine();
            if(program.searchProduct(id)!=null&&program.searchResiduoName(nameResidue)!=null){
             program.assignProduct(program.searchResiduoName(nameResidue),program.searchProduct(id));
             System.out.println("Process completed succesfully");
            break;  
            }else{
                System.out.println("Identification or name not found");
            } 

            
            case 7:

            program.generateResidueReportBasedOnCategory("Biodegradable");
            program.generateResidueReportBasedOnCategory("Inert");
            program.generateResidueReportBasedOnCategory("Recyclable");

            break;

            case 8:
             System.out.println ("please enter the name of the residue in order to calculate its effect");
            nameResidue= reader.nextLine();
            if(program.searchResiduoName(nameResidue)!=null){
             System.out.println("The damaging effect ot the residue "+program.searchResiduoName(nameResidue).getName()+" is: "+program.searchResiduoName(nameResidue).calculateDamaginEfect());    
            }
            break;
            case 9:
            program.listResiduesByDamaginEffect();
            break;
            case 10:
            System.out.println ("please enter the name of the residue in order to know if its usable");
            nameResidue= reader.nextLine();
             if(program.searchResiduoName(nameResidue)!=null){
                 if(program.searchResiduoName(nameResidue).isUsable()){
                    System.out.println(" The residue "+program.searchResiduoName(nameResidue).getName()+" is usable");
                 }else{
                     System.out.println(" The residue "+program.searchResiduoName(nameResidue).getName()+" is NOT usable");
                 }
                 
            }
            break;
           
            }
        
            
        }
    while (basicOperation != -1);
                
            }
}