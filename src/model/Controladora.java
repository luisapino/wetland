package model;
public class Controladora{
    public static final int MAX = 80;
    private int contador;
    private Wetland[] arrayWetland;

    public Controladora() {
        arrayWetland = new Wetland[MAX];
        contador = 0;
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
    public void createNewWetland(String name,String locationZone, 
                            String type, Double km2, String fotoURL, 
                            boolean protectedArea){

        Wetland newWetland = new Wetland(name, locationZone, type, km2, fotoURL, protectedArea);

        System.out.println("The wetland that has been created is: "+newWetland.getName());

        arrayWetland[contador] = newWetland;
        contador++;
    }
/**
 * Name: searchWetland
 * With this method you can search for a specific wetland 
 * and be able to record a species or event in it.
 * @param name name of the wetland
 * @return
 */
    public Wetland searchWetland(String name){

        for(int i = 0; i < contador; i++){
            String nameWetland =arrayWetland[i].getName();
            if (nameWetland.equals(name)){
                return arrayWetland[i];
            }
        } 
        return null;

    }
/**
 * Name: registerNewSpecieControladora
 * This method will record a new species in a wetland previously given by the user.
 * <b>pre: </b> that the person enters values according to what is asked of him/her <br>.
 * <b>post: </b> a new species is recorded.
 * @param name name of the wetland to which you want to register a new species.
 * @param nameSpecie name of the species to be registered.
 * @param scientificName scientific name of the species to be registered.
 * @param migratorySpecies necessary condition to know if the species is migratory or not.
 * @param type the type of species according to all its classifications
 * @param isFlora this is necessary to know whether the species recorded is flora or fauna.
 */
    public void registerNewSpecieControladora(String name, String nameSpecie, String scientificName, 
                                boolean migratorySpecies, int type, boolean isFlora){
        
        Wetland foundWetland = searchWetland(name);
        if (foundWetland != null){
            foundWetland.registerNewSpecie(nameSpecie, scientificName, migratorySpecies, type, isFlora);
            System.out.println("Species successfully registered");
        }
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
    public void registerNewEventControladora(String name, int typeEvent, String dateEvent,
                                             String nameRecorder, double cost, String description) throws Exception{
        
        Wetland foundWetland = searchWetland(name);
        if (foundWetland != null){
            foundWetland.registerNewEvent(typeEvent, dateEvent, nameRecorder, cost, description);
            System.out.println("Event successfully registered");
        }
    }
    /**
     *  Name: amountOfMaintenanceMain
     * This method will reflect the amount of maintenance given according to a year.
     * <b>pre: </b> that the person enters values according to what is asked of him/her <br>.
     * <b>post: </b> events held during the year.
     * @param yearMaintenance year entered by the user to be able to search for their number of maintenances.
     * @return
     */
    public int amountOfMaintenanceControladora(String yearMaintenance){

        int aux = Integer.parseInt(yearMaintenance); 

        int contador = 0;
        for(int i = 0; i<contador; i++){
            for(int j = 0; j<arrayWetland[i].getEventArray().size(); j++){
                Event eventAux = arrayWetland[i].getEventByID(j);

                if(aux == eventAux.getDateEvent().getYear()){

                    contador++;
                }

            }
        }
        return contador;
    }
   
    public void lessSpeciesFloraControladora(){

        Wetland auxHumedal;

        if(arrayWetland[0]!=null){
            auxHumedal = arrayWetland[0];
        }else{
            System.out.println("No wetlands exist");
            return;
        }

        for(int i = 0; i<contador; i++){
           if (arrayWetland[i].returnCantFlora() < auxHumedal.returnCantFlora()){
               auxHumedal = arrayWetland[i];

           }

        } System.out.println("The wetland with less fauna is: "+auxHumedal.getName());

    }

    /**
     * Name: wetlandsSpeciesControladora 
     * In this method we search for the wetland where a species is found.
     * @param name name of the specie for search
     */
    public void wetlandsSpeciesControladora(String name){
        for(int i =0; i < contador; i++){
            if(arrayWetland[i].haveSpecieWithName(name)){
                System.out.println("The name entered is found in the wetland: "+arrayWetland[i].getName());
            }
        }
    }

    public void infoWetlandControladora(){

        for(int i = 0; i < contador; i++){
            Wetland auxHumedal = arrayWetland[i];
            System.out.println("The name of the wetland is: "+auxHumedal.getName());
            System.out.println("The location of the wetland is: "+auxHumedal.getLocationZone());
            System.out.println("The wetland type is: "+auxHumedal.getType());
            System.out.println("The km2 of the wetland is: "+auxHumedal.getKm2());
            System.out.println("The URL of the photo of the wetland is: "+auxHumedal.getFotoURL());
            if(arrayWetland[i].getProtectedArea()){

                System.out.println("The wetland was declared a protected area.");

            }else{
                System.out.println("The wetland was NOT declared a protected area.");
            }
            System.out.println("The total number of terrestrial flora type species is: "+auxHumedal.returnTerrestrial_flora());
            System.out.println("The total number of aquatic flora type species is: "+auxHumedal.returnAquatic_flora());
            System.out.println("The total number of bird species is: "+auxHumedal.returnBird());
            System.out.println("The total number of mammal type species is: "+auxHumedal.returnMammal());
            System.out.println("The total number of aquatic type species is: "+auxHumedal.returnAquatic());
        }
    }

    public void moreWetlandsFaunaControladora(){

        Wetland aux1Humedal;

        if(arrayWetland[0]!=null){
            aux1Humedal = arrayWetland[0];
        }else{
            System.out.println("No wetlands exist");
            return;
        }

        for(int i = 0; i<contador; i++){
            if(arrayWetland[i].returnCantFauna() > aux1Humedal.returnCantFauna()){
                aux1Humedal = arrayWetland[i];

            }
        }System.out.println("The wetland with the largest number of animals is: "+aux1Humedal.getName());
    }
}