package it.polito.tdp.lab05.DAO;

import java.sql.Connection;
//import java.sql.DriverManager; non mi serve più
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {
	// check user e password
		static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=root";
		
		static private HikariDataSource ds = null;
		
		public static Connection getConnection() {
			
			if(ds==null) {
				ds = new HikariDataSource(); //la connessione viene creata la prima volta che chiamo getConnection() dopodichè le volte successive la connessione verrà sempre presa dal dataSource 
				ds.setJdbcUrl(jdbcUrl);
				
				//ds.setUsername("root");
				//ds.setPassword("root"); già fatto nella URL quindi non devo rifarlo
			
			}
			try {
				//Connection connection = DriverManager.getConnection(jdbcUrl);
				Connection connection = ds.getConnection();	
				return connection;

			} catch (SQLException e) {

				e.printStackTrace();
				throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
			}

		}
}
