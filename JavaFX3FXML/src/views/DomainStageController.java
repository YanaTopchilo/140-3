/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import repositories.*;
import static views.PersonStageController.person;
/**
 *
 * @author Topchilo
 */
public class DomainStageController implements Initializable {
    
    @FXML
    private TableView<DomainTable> table;
    @FXML
    private TableColumn<DomainTable, String> webnameColumn;
    @FXML
    private TableColumn<DomainTable, String>  domainNameColumn;
    @FXML
    private TableColumn<DomainTable, String> IPColumn;   
    @FXML
    private TableColumn<DomainTable, LocalDate> dateRegColumn;
    @FXML
    private TableColumn<DomainTable, String> countryColumn; 
    
    
    private RepositoryImpl repository;
    private PersonStageController personStageController;
    
    public DomainStageController(){
        repository = new RepositoryImpl();
        personStageController = new PersonStageController();
    }
    
    @Override
        public void initialize(URL url, ResourceBundle rb) {
        ObservableList<DomainTable> observableList = FXCollections.observableArrayList();
        repository.getDomainByPerson(person).forEach(domain -> {
            observableList.add(new DomainTable(domain.getWebname(), 
                    domain.getDomainName(), 
                    domain.getIP(), 
                    domain.getDateReg(), 
                    domain.getCountry()));
        });
        
        webnameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("webname"));
        domainNameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("domainName"));
        IPColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("IP"));
        dateRegColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, LocalDate>("dateReg"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("country"));
        table.setItems(observableList);
         
        }          
    }    
    

