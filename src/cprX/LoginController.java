package cprX;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	private Button login_btn;
	@FXML
	private TextField user, pwd;
	@FXML
	private Label mensajeError;
	
	private String error = "";
	
	
	public void login(ActionEvent event) {
		String username = this.user.getText();
		String password = this.pwd.getText();
		
		if(username.contains("prueba")) {
			this.error = "Usuario no válido";
		}
		
		if(password.length() < 6) {
			this.error = "Contraseña debe contar con más de 6 caracteres. Intente nuevamente";
		}
		
		if(password.equals(username)) {
			this.error = "Contraseña no puede ser igual a usuario. Intente nuevamente.";
		}
		
		if(this.error != "") {
			this.mensajeError.setText(this.error);
		}
		else {				
			try {
				FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("Inicio.fxml")); 
				Parent root;
				root = loader.load();
				InicioController controller = loader.getController();
				Scene scene = new Scene(root,452,327);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();	
				this.login_btn.getScene().getWindow().hide();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}
}