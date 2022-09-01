/*
 * EventsClass.java
 * This is the EventsClass(POJO) class
 * Cebisani Lamani (219104409)
 */
package za.ac.cput;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class EventsClass {
    private SimpleIntegerProperty eventNumber;
    private SimpleStringProperty eventName;
    private SimpleStringProperty eventType;
    private SimpleStringProperty eventDue;
    private CheckBox eventPriority;
    
    EventsClass(int eventNumber, String eventName, String eventType, String eventDue ){
        this.eventNumber = new SimpleIntegerProperty(eventNumber);
        this.eventName = new SimpleStringProperty(eventName);
        this.eventType = new SimpleStringProperty(eventType);
        this.eventDue = new SimpleStringProperty(eventDue);
        this.eventPriority = new CheckBox();
    }
 /////////GETTERS
    public Integer getEventNumber(){
        return eventNumber.get();
    }
    public String getEventName(){
        return eventName.get();
    }
    public String getEventType(){
        return eventName.get();
    }
    public String getEventDue(){
        return eventDue.get();
    }
    public CheckBox geteEventPriority(){
        return eventPriority;  
    }
////////////SETTTERS
     public void setEventNumber(Integer eventNumber){
        this.eventNumber.set(eventNumber);
    }
     public void setEventName(String eventName){
        this.eventName.set(eventName);
    }
     public void setEventType(String eventType){
         this.eventType.set(eventType);
     }
     public void setEventDue(String eventDue){
         this.eventDue.set(eventDue);
     }
    public void setPriority(CheckBox eventPriority){
        this.eventPriority = eventPriority;
    }
}