package cprX;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioController {

    @FXML
    private Button createSaleButton;

    @FXML
    void createSale(ActionEvent event) {
    	
		
		try {
			FXMLLoader loader = new FXMLLoader(InicioController.class.getResource("RegistroVenta.fxml")); 
			Parent root;
			root = loader.load();
			RegistroVentaController controller = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();	
			this.createSaleButton.getScene().getWindow().hide();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

}
