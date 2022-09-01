/*
 * FXML.java
 * This is the FXML Controller class
 * Cebisani Lamani (219104409)
 */
package za.ac.cput;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController implements Initializable {
    @FXML
    private Label lblSearchBox;
    @FXML
    private TextField txtSearchBox;
    @FXML
    private TableView myTable;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//Adding Table Colimns
        TableColumn eventNumCol = new TableColumn("Event Number:");
        TableColumn eventNameCol = new TableColumn("Event Name:");
        TableColumn eventTypeCol = new TableColumn("Event Type:");
        TableColumn eventDueCol = new TableColumn("Due Date:");
       // TableColumn eventPriorityCol = new TableColumn("Priorty:");
        myTable.getColumns().addAll(eventNumCol, eventNameCol, eventTypeCol, eventDueCol);
//Create a seperate events to represent the data
//Define data in a Observable List and add data in a table
        CheckBox ch = new CheckBox();
       ObservableList<EventsClass> tableData = FXCollections.observableArrayList(
               new EventsClass(1,"Information Management","LinkedIn","25-08-22"),
               new EventsClass(2,"MultimediaApplications Fundamentals","Study","09-09-22"),
               new EventsClass(3,"Information Systems","Exam","06-09-22"),
               new EventsClass(4,"Application Devolopment Theory", "Assignment", "24-08-22"),
               new EventsClass(5,"Professional Communications","Assignment","18-08-22"),
               new EventsClass(6,"Information Systems","Exam","06-09-22"),
               new EventsClass(7,"Applications Development Practice","Exam","06-09-22"),
               new EventsClass(8,"Project","Assignment","21-09-22"),
               new EventsClass(9,"Electives- Python ","Exam","07-09-22"),
               new EventsClass(10,"Applications Development Fundamentals","Exam","08-09-22")
       );
//Associate data with columns
        eventNumCol.setCellValueFactory(new PropertyValueFactory<EventsClass,Integer>("eventNumber"));
        eventNameCol.setCellValueFactory(new PropertyValueFactory<EventsClass,String>("eventName"));
        eventTypeCol.setCellValueFactory(new PropertyValueFactory<EventsClass,String>("eventType"));
        eventDueCol.setCellValueFactory(new PropertyValueFactory<EventsClass,String>("eventDue"));
        //eventPriorityCol.setCellValueFactory(new PropertyValueFactory<Events,CheckBox>("eventPriority"));
//Add data inside the table
        myTable.setItems(tableData);
//Wrap ObsevableList in a FilteredList       
        FilteredList<EventsClass> filterData = new FilteredList<>(tableData, b -> true);
            //Set the Filter Predicate whenever the Filter changes
            txtSearchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(event -> {
                //If filter text is empty display all the events
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                // Compare these events with filter text
                String lowerCaseFilter = newValue.toLowerCase();
                if (event.getEventName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if (event.getEventType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if(event.getEventDue().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else if(event.getEventNumber().toString().indexOf(lowerCaseFilter) != -1){
                    return true;
                } else {
                    return false; //Does Not match
                }
            });
        });
        SortedList<EventsClass> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(myTable.comparatorProperty());
        myTable.setItems(sortedList);
    }      
}