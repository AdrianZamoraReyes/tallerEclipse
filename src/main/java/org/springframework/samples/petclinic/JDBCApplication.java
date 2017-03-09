package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		
		/***
		 * Ejemplo inicial del taller
		 */
		/*Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			statement = connection.createStatement();
			String sql = "SELECT * FROM vets";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
		         int id = rs.getInt("id");
		         String firstName = rs.getString("first_name");
		         String lastName = rs.getString("last_name");

		         System.out.print("Id: " + id);
		         System.out.print(", Nombre: " + firstName);
		         System.out.println(", Apellidos: " + lastName);
			}
		    rs.close();
		    
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}*/
		
		/***
		 * Ejemplo sobre preparedStatements - número 2
		 */
		/*PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			String sql = "SELECT * FROM vets WHERE id=?;";
			
			preparedStatement = connection.prepareStatement(sql);
			
			// Sustitución de parámetros
			// preparedStatement.setTIPOJAVA(indiceEmpezandoEnUno, valor);
			preparedStatement.setInt(1, 2);
						
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				 // TipoJava nombre = rs.getTipoJava("nombreColumnaEnBaseDeDatos");
		         int id = rs.getInt("id");
		         String firstName = rs.getString("first_name");
		         String lastName = rs.getString("last_name");

		         System.out.print("Id: " + id);
		         System.out.print(", Nombre: " + firstName);
		         System.out.println(", Apellidos: " + lastName);
			}
		    rs.close();
		    
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(preparedStatement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}*/
		
		/***
		 * Taller 02 
		 */
		/*Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			statement = connection.createStatement();
			String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES ('Marcos', 'Ginel', 'Mi dirección', 'Mi ciudad', '666666666')";
			int numeroDeFilasModificadas = statement.executeUpdate(sql);			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}*/
		
		/***
		 * Taller 03
		 */
		/*Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			statement = connection.createStatement();
			String sql = "UPDATE owners "
					+ "SET city = 'Sevilla'"	
					+ "WHERE first_name = 'Marcos'";
			int numeroDeFilasModificadas = statement.executeUpdate(sql);			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}*/	
		
		/***
		 * Taller 04
		 */
		/*
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			String sql = "SELECT * FROM owners WHERE first_name LIKE ? OR last_name LIKE ?";
			String busqueda = "Da";
			String termino = "%"+busqueda+"%";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, termino);
			preparedStatement.setString(2, termino);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
		         int id = rs.getInt("id");
		         String firstName = rs.getString("first_name");
		         String lastName = rs.getString("last_name");

		         System.out.print("Id: " + id);
		         System.out.print(", Nombre: " + firstName);
		         System.out.println(", Apellidos: " + lastName);
			}
		    rs.close();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(preparedStatement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}*/
		
		/***
		 * Taller 05
		 */
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			String[] valores = new String[] {"Marcos", "Ginel", "Mi casa", "Sevilla", "666666666"};
			String sql = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES(?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(sql);
			for(int i=0; i < valores.length; i++)
				preparedStatement.setString(i+1, valores[i]);
			
			int numeroDeFilasModificadas = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(preparedStatement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}

}
