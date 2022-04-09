package model;
import java.util.Date;

public class Event{
    //Atributos
    private EventType typeEvent;
    private Date dateEvent;
    private String nameRecorder;
    private double cost;
    private String description;

    //métodos

    public Event(EventType typeEvent,Date dateEvent, String nameRecorder, double cost, String description){
        this.typeEvent = typeEvent;
        this.dateEvent = dateEvent;
        this.nameRecorder = nameRecorder;
        this.cost = cost;
        this.description = description; 
    }

    public EventType getTypeEvent() {
        return typeEvent;
    }
    public void setTypeEvent(EventType typeEvent) {
        this.typeEvent = typeEvent;
    }
    public Date getDateEvent() {
        return dateEvent;
    }
    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }
    public String getNameRecorder() {
        return nameRecorder;
    }
    public void setNameRecorder(String nameRecorder) {
        this.nameRecorder = nameRecorder;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }    
}
