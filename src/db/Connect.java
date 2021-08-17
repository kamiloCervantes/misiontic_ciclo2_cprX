package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
private Connection conexion;
	
	public Connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			/*
			 * Reemplazar la ruta '/home/bits/eclipse-workspace/cprX/almacen.db' por la ruta
			 * donde se encuentre su base de datos SQLite.
			 */
			this.conexion = DriverManager.getConnection("jdbc:sqlite:/home/bits/eclipse-workspace/cprX/almacenV2.db");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConexion() {
		return this.conexion;
	}

}
