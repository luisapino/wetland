package model;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Wetland {
    //atributos
    private ArrayList<Specie> arraySpecies = new ArrayList<Specie>();
    private ArrayList<Event> arrayEvent = new ArrayList<Event>();
    private String name;
    private String locationZone;
    private String type;
    private Double km2;
    private String fotoURL;
    private boolean protectedArea;
    private int contadorFlora;
    private int contadorFauna;
    private int contadorTerrestrial_flora;
    private int contadorAquatic_flora;
    private int contadorBird;
    private int contadorMammal;
    private int contadorAquatic;

    //metodos
/**
 * Name: Wetland
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
    public Wetland(String name,String locationZone, String type, Double km2, String fotoURL, boolean protectedArea){
        this.name = name;
        this.locationZone = locationZone;
        this.type = type;
        this.km2 = km2;
        this.fotoURL = fotoURL;
        this.protectedArea = protectedArea;

    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocationZone(){
        return locationZone;
    }
    public void setLocationZone(String locationZone) {
        this.locationZone = locationZone;
    }

    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Double getKm2(){
        return km2;
    }
    public void setName(Double km2) {
        this.km2 = km2;
    }

    public String getFotoURL(){
        return fotoURL;
    }
    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    public boolean getProtectedArea(){
        return protectedArea;
    }
    
    public void setProtectedArea(boolean protectedArea) {
        this.protectedArea = protectedArea;
    }
/**
 * Name: registerNewSpecie
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
    public void registerNewSpecie(String nameSpecie, String scientificName, 
                                boolean migratorySpecies, int type, boolean isFlora){

        SpecieType aux = null;
        switch(type){
            case 1:{

                aux = SpecieType.TERRESTRIAL_FLORA;

                contadorTerrestrial_flora++;
                contadorFlora++;
                break;
            }
            case 2:{

                aux = SpecieType.AQUATIC_FLORA;
                contadorAquatic_flora++;
                contadorFlora++;
                break;
            }
            case 3:{

                aux = SpecieType.BIRD;
                contadorBird++;
                contadorFauna++;

                break;
            }
            case 4:{

                aux = SpecieType.MAMMAL;
                contadorMammal++;
                contadorFauna++;

                break;
            }
            case 5:{

                aux = SpecieType.AQUATIC;
                contadorAquatic++;
                contadorFauna++;

                break;
            }
        }

        Specie newSpecie = new Specie(nameSpecie, scientificName, migratorySpecies, aux, isFlora);
    
        arraySpecies.add(newSpecie);
    }
/**
 * Name: returnCantFlora
 * @return
 */
    public int returnCantFlora(){

        return contadorFlora;

    }
/**
 * Name: returnCantFauna 
 * @return
 */
    public int returnCantFauna(){

        return contadorFauna;
    }
/**
 * Name: returnTerrestrial_flora
 * @return
 */
    public int returnTerrestrial_flora(){

        return contadorTerrestrial_flora;
    }
/**
 * Name: returnAquatic_flora
 * @return
 */
    public int returnAquatic_flora(){

        return contadorAquatic_flora;
    }
/**
 * Name: returnBird
 * @return
 */
    public int returnBird(){

        return contadorBird;
    }
/**
 * Name: returnMammal
 * @return
 */
    public int returnMammal(){

        return contadorMammal;
    }
/**
 * Name: returnAquatic
 * @return
 */
    public int returnAquatic(){

        return contadorAquatic;
    }
/**
 * Name: registerNewEvent
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
    public void registerNewEvent(int typeEvent, String dateEvent, String nameRecorder, 
        double cost, String description) throws Exception {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dateEvent);  
        System.out.println(dateEvent+"\t"+date1); 
        
        EventType aux = null;
        switch(typeEvent){
            case 1:{
                aux = EventType.MAINTAINANCE;
                break;
            }
            case 2:{
                aux = EventType.SCHOOL_VISITS;
                break;
            }
            case 3:{
                aux = EventType.IMPROVEMENT;
                break;
            }
            case 4:{
                aux = EventType.CELEBRATIONS;
                break;
            }
        }
        Event newEvent = new Event(aux, date1, nameRecorder, cost, description);

        arrayEvent.add(newEvent);

    }
/**
 * Name: getEventByID
 * @param id
 * @return
 */
    public Event getEventByID(int id){
        return arrayEvent.get(id);
    }
/**
 * Name:getEventArray
 * @return
 */
    public ArrayList<Event> getEventArray(){
        return arrayEvent;
    }
/**
 * Name: getSpecieByID
 * @param id
 * @return
 */
    public Specie getSpecieByID(int id){
        return arraySpecies.get(id);
    }
/**
 * Name: haveSpecieWithName 
 * @param name name of the specie searched for know if exist in some wetland
 * @return
 */
    public boolean haveSpecieWithName(String name){
        for(int i = 0; i<arraySpecies.size(); i++){
            if(arraySpecies.get(i).getNameSpecie().equals(name)){
                return true;
            }
        }
        return false;
    }
}