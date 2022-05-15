package com;

import java.sql.*;

public class user {

	public Connection connect() 
	{ 
	 Connection conn = null; 
	 
	 try 
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid", "root", ""); 
	 //For testing
	 System.out.print("Successfully connected"); 
	 } 
	 catch(Exception e) 
	 { 
	 e.printStackTrace(); 
	 } 
	 
	 return conn; 
	}
    
    
    //method to insert data
    public String insertUser(String CustomerfName, String CustomerlName, String AccountNumber, String CustomerNIC, String CustomerEmail, String CustomerPhone) {
    	
    	
    	String Output = "";
    	
    	try {
    		Connection conn = connect();
        	if (conn == null) {
        		return "Database connection error";
        	}
        	
        	//SQL query
        	String query = " insert into user(`CustomerfName`,`CustomerlName`,`AccountNumber`,`CustomerNIC`,`CustomerEmail`,`CustomerPhone`)"
					 + " values (?, ?, ? , ?,?,?)";
        	
        	//binding data to SQL query
        	PreparedStatement preparedStatement = conn.prepareStatement(query);
        	//preparedStatement.setInt(1, 0); 
        	preparedStatement.setString(1, CustomerfName);
        	preparedStatement.setString(2, CustomerlName);
        	preparedStatement.setString(3,AccountNumber);
        	preparedStatement.setString(4, CustomerNIC);
        	preparedStatement.setString(5, CustomerEmail);
        	preparedStatement.setString(6, CustomerPhone);
        	
        	//execute the SQL statement
        	preparedStatement.execute();
        	conn.close();
        	
        	String newItems = readUser(); 
        	 Output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}"; 
        	
        	
        	
    	} catch(Exception e) {
    		Output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}"; 
    		System.err.println(e.getMessage());
    	}
    	
    	return Output;
    }
    
    //method to update data
    public String UpdateUser(String CustomerID,String CustomerfName,String CustomerlName,String AccountNumber,String CustomerNIC,String CustomerEmail,String CustomerPhone) {
    	
    	
    	String Output = "";
    	
    	try {
    		Connection conn = connect();
        	if (conn == null) {
        		return "Database connection error";
        	}
        	
        	//SQL query
        	String query = "UPDATE user SET CustomerfName=?,CustomerlName=?,AccountNumber=?,CustomerNIC=?,CustomerEmail=?,CustomerPhone=? WHERE CustomerID=?";
        	
        	//binding data to SQL query
        	PreparedStatement preparedStatement = conn.prepareStatement(query);
        	preparedStatement.setString(1, CustomerfName);
        	preparedStatement.setString(2, CustomerlName);
        	preparedStatement.setString(3,AccountNumber);
        	preparedStatement.setString(4, CustomerNIC);
        	preparedStatement.setString(5, CustomerEmail);
        	preparedStatement.setString(6, CustomerPhone);
        	//preparedStatement.setString(7, CustomerID);
        	preparedStatement.setInt(7, Integer.parseInt(CustomerID)); 
        	
        	//execute the SQL statement
        	preparedStatement.executeUpdate();
        	conn.close();
        	String newItems = readUser(); 
        	
        	 Output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}"; 

        	
        	
    	} catch(Exception e) {
    		Output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}"; 
    		System.err.println(e.getMessage());
    	}
    	
    	return Output;
    }
    
    
    //method to read data
    public String readUser() {
    	
    	
    	String Output = "";
    	
    	try {
    		Connection conn = connect();
        	
        	if (conn == null) {
        		return "Database connection error";
        	}
        	
        	//SQL query
        	String query = "SELECT * FROM user";
        	
        	//executing the SQL query
        	Statement statement = conn.createStatement();
        	ResultSet resultSet = statement.executeQuery(query);
        	
        	// Prepare the HTML table to be displayed
    		 
    				
    				
        	Output ="<table border=\"1\" class=\"table\"><tr><th>First Name</th>"
    		 		+ "<th>Last Name</th><th>Account Number</th>"
    		 		+ "<th>NIC</th>"
    		 		+ "<th>Email</th>"
    		 		+ "<th>Phone Number</th>"
    		 		+ "<th>Update</th>"
    		 		+ "<th>Remove</th></tr>"; 
        	
        	while(resultSet.next()) {
        		String CustomerID = Integer.toString(resultSet.getInt("CustomerID"));
        		String CustomerfName = resultSet.getString("CustomerfName");
        		String CustomerlName = resultSet.getString("CustomerlName");
        		String AccountNumber =resultSet.getString("AccountNumber");
        		String CustomerNIC = resultSet.getString("CustomerNIC");
        		String CustomerEmail = resultSet.getString("CustomerEmail");
        		String CustomerPhone = resultSet.getString("CustomerPhone");
        		
        		// Add a row into the HTML table
        		 
        		Output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='"+CustomerID+"'>"+CustomerfName+"</td>";  
        		Output += "<td>" + CustomerlName + "</td>"; 
        		Output += "<td>" + AccountNumber + "</td>"; 
        		Output += "<td>" + CustomerNIC + "</td>";
        		Output += "<td>" + CustomerEmail + "</td>";
        		Output += "<td>" + CustomerPhone + "</td>";
        		
        		// buttons
        		Output += "<td><input name='btnUpdate' type='button' value='Update' "
       				 + "class='btnUpdate btn btn-secondary' data-customerid='" + CustomerID + "'></td>"
       				 + "<td><input name='btnRemove' type='button' value='Remove' "
       				 + "class='btnRemove btn btn-danger' data-customerid='" + CustomerID + "'></td></tr>";
        				
        	}

        	conn.close();
        	
        	// Complete the HTML table
        	Output += "</table>";
        	
    	} catch(Exception e) {
    		Output = "Failed to read the items";
    		System.err.println(e.getMessage());
    	}
    	
    	return Output;
    }
    
    //method to delete data
    public String deleteUser(String CustomerID) {
    	String Output = "";
    	
    	
    	try {
    		Connection conn = connect();
        	if (conn == null) {
        		return "Database connection error";
        	}
        	
        	//SQL query
        	String query = "DELETE FROM user WHERE CustomerID = ?";
        	
        	//binding data to the SQL query
        	PreparedStatement preparedStatement = conn.prepareStatement(query);
        	preparedStatement.setInt(1, Integer.parseInt(CustomerID));
        	
        	//executing the SQL statement
        	preparedStatement.execute();
        	conn.close();
        	
        	String newItems = readUser(); 
        	 Output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}"; 
        	
        	
        	
    	} catch(Exception e) {
    		Output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}"; 

    		System.err.println(e.getMessage());
    	}
    	return Output;
    }
}
