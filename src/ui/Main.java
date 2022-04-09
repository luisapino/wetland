package ui;
import java.util.Scanner;
import model.Controladora;
public class Main{
    public static Scanner lector;
    public static Controladora control;

/**
 * Author : Luisa Castaño
 * in this method, you will be able to enter an option according to 
 * a menu that will be presented to you, with which you will be 
 * presented with a series of information.
 * <b>pre. </b> That the person enters valid values, otherwise a 
 * successful registration is not possible, And choose a valid 
 * number from the menu of options.<br>
 * <b>post: </b> Information related to the option chosen by the user.
 * @param option option is the integer type variable that will store 
 * the number entered by the user as an option. poption != null && poption !="".
*/
    public static void main(String[] args)throws Exception{

        control = new Controladora();
        lector=new Scanner(System.in);

        int option = options();

        while (option!=9){
            switch (option){
                case 1:{
                    createWetland();//a wetland number will be created with its respective information.
                    break;
                }
                case 2:{
                    registerNewSpecieMain();//new species to be recorded in a sought-after wetland
                    break;
                }
                case 3:{
                    registerNewEventMain();//a new event will be recorded in a sought-after wetland
    
                    break;
                }
                case 4:{
                    amountOfMaintenanceMain();//It will show the amount of maintenance given according to a year entered by the user.
    
                    break;
                }
                case 5:{
                    lessSpeciesFloraMain();//the wetland with the least amount of flora type species can be shown.
    
                    break;
                }
                case 6:{
                    wetlandsSpecies();//it will show where the species are found according to the species name
    
                    break;
                }
                case 7:{
                    infoWetland();//information on wetlands and their species will be displayed.
                    
    
                    break;
                }
                case 8:{
                    moreWetlandsFauna();//the wetland with the least amount of flora type species can be shown.
                    
    
                    break;
                }
            }
            option = options();
        }
    }
    /**
     * Name : options
     * user options menu
     * <b>pre: </b> the person enters a whole number. <br>
     * <b>post: </b> the action is performed according to the option chosen by the user.
     * @return return of the option chosen in the menu.
     */
    public static int options(){
        System.out.println("""
            Menu: you have the following options
            Type the number 1 if you want to create a wetland.
            Type the number 2 if you want to record a new specie.
            Type the number 3 if you want to record an event in the wetland.
            Type the number 4 to enter the date of a wetland and know the amount of maintenance in that year.
            Type the number 5 if you want know the name of the wetland with the fewest species of flora.
            Type the number 6 if you want enter a name of an specie and to know in which wetland it is located.
            Type the number 7 if you want to know the wetland information.
            Type the number 8 if you want to know the name of the wetland with the highest number of animals.
            Type the number 9 to close the process.
            """);
            int menu = lector.nextInt();
            lector.nextLine();
            return menu;
    }
/**
 * Name: createWetland
 * This method is necessary to be able to create 
 * a wetland according to a series of requested information. poption.
 * <b>pre: </b> that the person enters values according to what is asked of him/her <br>.
 * <b>post: </b> a new wetland is created.
 * @param name name of the wetland you are creating. pname != null && pname != "".
 * @param locationZone location zone in which the person is located, whether urban or rural. plocationZone != null && plocationZone != "".
 * @param type type of wetland, whether public or private. ptype != null && ptype != "".
 * @param km2 square kilometers wetland size. pkm2 != null && pkm2 != "".
 * @param fotoURL URL of the photo provided by the user. pfotoURL != null && pfotoURL != "".
 * @param protectedArea check whether the area has been declared a protected area or not. pprotectedArea != null && pprotectedArea != "".
 */
    public static void createWetland(){
        System.out.println("Enter the name of the wetland");
        String name = lector.nextLine();
        System.out.println("Enter the wetland location zone (urban, rural)");
        String locationZone = lector.nextLine();
        System.out.println("Enter wetland type(public or private).");
        String type = lector.nextLine();
        System.out.println("Enter the number of km2 of the wetland.");
        Double km2 = lector.nextDouble();
        lector.nextLine();
        System.out.println("Enter the URL of the photo of the wetland");
        String fotoURL = lector.nextLine();
        System.out.println("Enter true if the wetland has been declared a protected area, otherwise enter false");
        boolean protectedArea = lector.nextBoolean();
        lector.nextLine();

        control.createNewWetland(name, locationZone, type, km2, fotoURL, protectedArea);
    }
/**
 * Name: registerNewSpecieMain
 * This method will record a new species in a wetland previously given by the user.
 * <b>pre: </b> that the person enters values according to what is asked of him/her <br>.
 * <b>post: </b> a new species is recorded.
 * @param name name of the wetland to which you want to register a new species.
 * @param isFlora this is necessary to know whether the species recorded is flora or fauna.
 * @param nameSpecie name of the species to be registered.
 * @param scientificName scientific name of the species to be registered.
 * @param migratorySpecies necessary condition to know if the species is migratory or not.
 * @param type the type of species according to all its classifications
 */
    public static void registerNewSpecieMain(){
        System.out.println("Enter the name of the wetland");
        String name = lector.nextLine();
        System.out.println("is flora?(enter true) otherwise (enter false)");
        boolean isFlora = lector.nextBoolean();
        lector.nextLine();
        System.out.println("Enter the name of the specie");
        String nameSpecie = lector.nextLine();
        System.out.println("Enter the specie scientific name");
        String scientificName = lector.nextLine();
        System.out.println("The specie is migratory?(enter true), otherwise (enter false)");
        boolean migratorySpecies = lector.nextBoolean();
        lector.nextLine();
        System.out.println("Enter the type of the specie");
        System.out.println("1: TERRESTRIAL_FLORA, 2: AQUATIC_FLORA, 3: BIRD, 4: MAMMAL, 5: AQUATIC");
        int type = lector.nextInt();
        lector.nextLine();

        control.registerNewSpecieControladora(name, nameSpecie, scientificName, 
        migratorySpecies, type, isFlora);
    }
/**
 * Name: registerNewEventMain
 * This method will record a new event in a wetland previously given by the user.
 * <b>pre: </b> that the person enters values according to what is asked of him/her <br>.
 * <b>post: </b> a new event is recorded.
 * @param name name of the wetland to which you want to register a new event.
 * @param typeEvent this is necessary to know the type of event.
 * @param dateEvent to know the type and date on which the event occurred.
 * @param nameRecorder to find out who registered the event.
 * @param cost to know who the cost of the event.
 * @param description a short description.
 * @throws Exception
 */
    public static void registerNewEventMain()throws Exception{
        System.out.println("Enter the name of the wetland");
        String name = lector.nextLine();
        System.out.println("Enter the number of the type of activity ");
        System.out.println("1: MAINTAINANCE, 2: SCHOOL_VISITS, 3: IMPROVEMENT, 4: CELEBRATIONS ");
        int typeEvent = lector.nextInt();
        lector.nextLine();
        System.out.println("Enter the date of the activity(dd/MM/yyyy)");
        String dateEvent = lector.nextLine();
        System.out.println("Enter who performs the event");
        String nameRecorder = lector.nextLine();
        System.out.println("Enter the cost of the event");
        double cost = lector.nextDouble();
        lector.nextLine();
        System.out.println("Enter the description of the event");
        String description = lector.nextLine();

        control.registerNewEventControladora(name, typeEvent, dateEvent, nameRecorder, cost, description);
    }
/**
 * Name: amountOfMaintenanceMain
 * This method will reflect the amount of maintenance given according to a year.
 * <b>pre: </b> that the person enters values according to what is asked of him/her <br>.
 * <b>post: </b> events held during the year.
 * @param yearMaintenance year entered by the user to be able to search for their number of maintenances.
 */
    public static void amountOfMaintenanceMain(){
        System.out.println("Enter the year to know the amount of maintenance");
        String yearMaintenance = lector.nextLine();

        control.amountOfMaintenanceControladora(yearMaintenance);

    }

    public static void lessSpeciesFloraMain(){

        control.lessSpeciesFloraControladora();

    }

    public static void wetlandsSpecies(){
        System.out.println("Enter the name of a species to know the wetlands where it is located.");
        String name = lector.nextLine();

        control.wetlandsSpeciesControladora(name);
    }

    public static void infoWetland(){
        control.infoWetlandControladora();
    }

    public static void moreWetlandsFauna(){
        control.moreWetlandsFaunaControladora();

    }
}