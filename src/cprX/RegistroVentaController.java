package cprX;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class RegistroVentaController {

    @FXML
    private ChoiceBox<String> sel_productos;

    @FXML
    private ChoiceBox<String> sel_clientes;

    @FXML
    private TextField cantidad_venta;

    @FXML
    private Button btn_registrar;

    @FXML
    private Button crearCliente;

    @FXML
    private TextField identificacion_cliente;

    @FXML
    private TextField nombre_cliente;

    @FXML
    private TextField apellido_cliente;

    @FXML
    private TextField genero_cliente;
    
    private ObservableList<String> productos;
    private ObservableList<String> clientes;
    
    @FXML
    private void initialize() {
    	this.productos = FXCollections.observableArrayList("Seleccione producto");
    	this.clientes = FXCollections.observableArrayList("Seleccione cliente");
        this.obtenerListaProductos();
        this.obtenerListaClientes();
    }
    
    
    @FXML
    void registrarVenta(ActionEvent event) {
    	int producto = Integer.parseInt(this.sel_productos.getValue().split("-")[0]);
    	int cliente = Integer.parseInt(this.sel_clientes.getValue().split("-")[0]);
    	int cantidad = Integer.parseInt(this.cantidad_venta.getText());
    	boolean valid = true;
    	
    	//validaciones
    	
    	
    	
    	
    	
    	
    	//insert en la bd
    	if(valid) {
    		Connect objConexion = new Connect();
            String query = "INSERT INTO ventas (cliente,producto,cantidad) VALUES (?,?,?);";
            try (Connection conn = objConexion.getConexion()) {
            	//consultar fk's            	
            	String sql_producto = "SELECT id from productos where codigo = ?";
            	PreparedStatement stmt_fk_producto = conn.prepareStatement(sql_producto);
            	stmt_fk_producto.setInt(1, producto);
            	ResultSet rs_fk_producto = stmt_fk_producto.executeQuery();
            	int producto_fk = rs_fk_producto.getInt("id");
            	
            	String sql_cliente = "SELECT id from clientes where cedula = ?";
            	PreparedStatement stmt_fk_cliente = conn.prepareStatement(sql_cliente);
            	stmt_fk_cliente.setInt(1, cliente);
            	ResultSet rs_fk_cliente = stmt_fk_cliente.executeQuery();
            	int cliente_fk = rs_fk_cliente.getInt("id");
            	
            	PreparedStatement stmt = conn.prepareStatement(query);
            	stmt.setInt(1, producto_fk);
                stmt.setInt(2, cliente_fk);
                stmt.setInt(3, cantidad);
            	int res = stmt.executeUpdate();
    			if(res > 0) {
    				//limpiar formulario
    				this.sel_productos.setValue("Seleccione producto");
    				this.sel_clientes.setValue("Seleccione cliente");
    				this.cantidad_venta.setText("");
                    stmt.close();
                    conn.close();
    			}
    			else {
    				//enviar mensaje de error
    			}
    			
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    	}
    }
    
    @FXML
    void registrarCliente(ActionEvent event) {
    	String documento = this.identificacion_cliente.getText();
    	String nombre = this.nombre_cliente.getText();
    	String apellido = this.apellido_cliente.getText();
    	String genero = this.genero_cliente.getText();
    	boolean valid = true;
    	
    	//validaciones
    	
    	
    	//insert en la bd
    	if(valid) {
    		Connect objConexion = new Connect();
            String query = "INSERT INTO clientes (cedula,nombre,apellido,genero) VALUES (?,?,?,?);";
            try (Connection conn = objConexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, documento);
                stmt.setString(2, nombre);
                stmt.setString(3, apellido);
                stmt.setString(4, genero);
            	int res = stmt.executeUpdate();
    			if(res > 0) {
    				//limpiar formulario
    				this.identificacion_cliente.setText("");
    				this.nombre_cliente.setText("");
    				this.apellido_cliente.setText("");
    				this.genero_cliente.setText("");
    				
    				
    				//actualizar listado clientes
    				this.clientes.add(documento+"-"+nombre+" "+apellido);
                    stmt.close();
                    conn.close();
    			}
    			else {
    				//enviar mensaje de error
    			}
    			
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    	}
    }
    
    void obtenerListaProductos() {
        Connect objConexion = new Connect();
        String query = "SELECT * from productos order by codigo asc;";
        try (Connection conn = objConexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
                productos.add(resultSet.getInt("codigo") + "-" + (resultSet.getString("nombre")));
            }
			this.sel_productos.setValue("Seleccione producto");
			this.sel_productos.setItems(productos);
			
            stmt.close();
            resultSet.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    void obtenerListaClientes() {
    	Connect objConexion = new Connect();
        String query = "SELECT * from clientes order by cedula asc;";
        try (Connection conn = objConexion.getConexion(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) {
                clientes.add(resultSet.getInt("cedula") + "-" + (resultSet.getString("nombre"))  + " " + (resultSet.getString("apellido")));
            }
			this.sel_clientes.setValue("Seleccione cliente");
			this.sel_clientes.setItems(clientes);
			
            stmt.close();
            resultSet.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




}
