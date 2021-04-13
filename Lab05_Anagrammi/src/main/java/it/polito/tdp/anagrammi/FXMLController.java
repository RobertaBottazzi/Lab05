/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab05.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtAnagramma"
    private TextField txtAnagramma; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammiCorretti"
    private TextArea txtAnagrammiCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammiErrati"
    private TextArea txtAnagrammiErrati; // Value injected by FXMLLoader
    
    private Model anagramma;
    
    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	String parola= this.txtAnagramma.getText();
    	List<String> anagrammi= this.anagramma.anagrammi(parola);
    	List<String> anagrammiCorretti= this.anagramma.getAnagrammiCorretti(anagrammi);
    	List<String> anagrammiErrati=this.anagramma.getAnagrammiErrati(anagrammi);
    	for(String a: anagrammiCorretti) 
    		this.txtAnagrammiCorretti.appendText(a+"\n");
    	for(String a: anagrammiErrati)
    		this.txtAnagrammiErrati.appendText(a+"\n");    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtAnagramma.clear();
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtAnagramma != null : "fx:id=\"txtAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.anagramma=new Model();		
	}
}
