/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import repositories.*;
/**
 *
 * @author Topchilo
 */
    
  public class PersonStage extends Stage{
    
    private RepositoryImpl repository;
   
    public PersonStage(){
       repository = new RepositoryImpl();
    }
    
    public void init() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("PersonStage.fxml"));
        Scene scene = new Scene(root);
        setTitle("Persons");
        setScene(scene);
        show();
    }
}

