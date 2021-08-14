package cprX;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import db.Connect;

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
				Connect c = new Connect();
				Connection conn = c.getConexion();
				
				String sql = "select count(*) from usuarios where username = ? and passwd = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, password);
				ResultSet result = stmt.executeQuery();
				int res = result.getInt(1);
				
				if(res > 0) {
					FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("Inicio.fxml")); 
					Parent root;
					root = loader.load();
					InicioController controller = loader.getController();
					Scene scene = new Scene(root,452,327);
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.show();	
					this.login_btn.getScene().getWindow().hide();
				}
				else {
					this.mensajeError.setText("Error! No se encuentra el usuario en la BD!");
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}
}