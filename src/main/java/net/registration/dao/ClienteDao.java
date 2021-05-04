package net.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.registration.model.Cliente;

public class ClienteDao {
	int id;
	
	public int registerCliente(Cliente cliente) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO client" +
				"(id, first_name, last_name, address, contact) VALUES" +
				"(?,?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "root");

		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select max(id) from client ")) {

				System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	id = rs.getInt(1) +1;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "root");

	            PreparedStatement preparedStatement = connection
	            .prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, id);
	            preparedStatement.setString(2, cliente.getFirstName());
	            preparedStatement.setString(3, cliente.getLastName());
	            preparedStatement.setString(4, cliente.getAddress());
	            preparedStatement.setString(5, cliente.getContact());

	            System.out.println(preparedStatement);
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return result;
	}
	
	public List<Cliente> selectAllCliente() {
		List<Cliente> cliente = new ArrayList<>();

		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "root");

	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from client")) {

				System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	int id = rs.getInt("id");
	            	String firstName = rs.getString("first_name");
	            	String lastName = rs.getString("last_name");
	            	String address = rs.getString("address");
	            	String contact = rs.getString("contact");
	            	cliente.add(new Cliente(firstName, lastName, address, contact, id));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		return cliente;
	}
	
	public Cliente selectCliente(int id) {
		Cliente cliente = null;
		
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "root");
				
	            PreparedStatement preparedStatement = connection
        		.prepareStatement("select id,first_name,last_name,address,contact from client where id =?")) {
            		preparedStatement.setInt(1, id);

					System.out.println(preparedStatement);
		            ResultSet rs = preparedStatement.executeQuery();

		            while (rs.next()) {
		            	String firstName = rs.getString("first_name");
		            	String lastName = rs.getString("last_name");
		            	String address = rs.getString("address");
		            	String contact = rs.getString("contact");
		            	cliente = new Cliente(firstName, lastName, address, contact, id);
		            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return cliente;
	}
	
	public boolean updateCliente(Cliente cliente) throws SQLException {
		boolean rowUpdated = false;
		
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "root");
				
	            PreparedStatement preparedStatement = connection
        		.prepareStatement("update client set first_name = ?,last_name= ?, address =?, contact =?  where id = ?;")) {
					preparedStatement.setString(1, cliente.getFirstName());
		            preparedStatement.setString(2, cliente.getLastName());
		            preparedStatement.setString(3, cliente.getAddress());
		            preparedStatement.setString(4, cliente.getContact());
		            preparedStatement.setInt(5, cliente.getId());

					System.out.println(preparedStatement);
		            rowUpdated = preparedStatement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return rowUpdated;
	}
	
	public boolean deleteCliente(Cliente cliente) throws SQLException {
		boolean rowDeleted = false;
		
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "root");
				
	            PreparedStatement preparedStatement = connection
        		.prepareStatement("delete from client where id = ?;")) {
		            preparedStatement.setInt(1, cliente.getId());

					System.out.println(preparedStatement);
					rowDeleted = preparedStatement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return rowDeleted;
	}
}
