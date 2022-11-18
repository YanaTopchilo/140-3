/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import models.Person;

/**
 *
 * @author Topchilo
 */
public class DomainStage extends Stage{
    
   private Person person;
    
     public DomainStage(Person person){
       this.person = person;
    }
    
     public void init() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("DomainStage.fxml"));
        initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        setTitle("Список доменов " + person.getFullname());
        setScene(scene);
        show();
    }
        
}

