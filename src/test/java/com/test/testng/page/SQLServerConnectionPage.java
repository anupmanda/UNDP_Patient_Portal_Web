/**
 * 
 */
package com.test.testng.page;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mongodb.connection.Connection;
import com.test.browser.setup.GeneralBrowserSetting;

/**
 * @author Anup
 *
 * 27-May-2025
 */
          public class SQLServerConnectionPage{
        	  
        	  public static void main(String []args) {
        		  
        		  //Database connection parameters
        		  
        		  String serverName= "103.234.185.88";
        		  String databaseName = "UNDP_TestingNew";
        		  String username = "Sa";
        		  String password = "ServerAdmin@123";
        		  
        		  java.sql.Connection connection = null;
        		  
        System.out.println("Hello...........");		  
        		  try {
        			  //Load the SQL Server JDBC driver
        			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        			  	
        			  //Create a connection URL 
        			  String url = "jdbc:sqlserver://"+ serverName+":2499;databaseName ="+ databaseName;
        			  
        			  System.out.println("Hello11111...........");
        			  
        			  //Establish the database connection 
        			  connection = DriverManager.getConnection(url,username,password);
        			  
        			  System.out.println("Hello33333333...........");		  
        			  //SQL query to retrieve the value from the messageText column
        			  String sqlQuery = "Select * from D_SMS order by 1 desc";
        			  
        			  System.out.println("Hello222222...........");	  
        			  //create a PreparedStatement for the query 
        			  PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        			   
        			  //Execute the query and retrieve the result
        			  
        			  ResultSet resultSet = preparedStatement.executeQuery();
        			  
        			  //Iterate through the result set
        			  
        	/*		  while(resultSet.next()) {
        				  
        				  String messageText = resultSet.getString("MessageText");
        				  System.out.println("Message Text:"+ messageText);
        				  
        			  }*/
        			  //Check if there is a result
        			  if(resultSet.next()) {
        				  //Retrieve the values from the columns
        				   int column1value = resultSet.getInt(1);
        				   //Assuming column 1 is an integer, change the data type accordingly
        				   String messageText = resultSet.getString("MessageText");
        				    
        				   //Extract OTP from the message text using regex
        				   String otp = extractOTP(messageText);
        				   System.out.println(otp);
        				    
        				   //Print the retrieved values
        				   System.out.println("Column 1 Value:"+ column1value);
        				   
        				   System.out.println("MessageText:" + messageText);
        						  
        			  }
        			  else {
        				  System.out.println("No records found");
        			  }
        			  
        		  }
        		  catch (ClassNotFoundException | SQLException e) {
        	            e.printStackTrace();
        		  }   
        		  finally {
        			  
        			// Close the connection when done
        			  try {
        				  if (connection != null) {
        	                    connection.close();
        	                }
        	            } catch (SQLException e) {
        	                e.printStackTrace();
        	            }
        	         
        		  }
        		  
        	            
        	  }

			
			private static String extractOTP(String input) {
				
				 // Define a regex pattern to match a series of digits (OTP)
		        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");          // Matches a 6-digit number
		        
		     // Create a Matcher object
		        Matcher matcher = pattern.matcher(input);
		        
		     // Find the first match in the input string
		        if (matcher.find()) {
		            return matcher.group(); // Extract the matched OTP
		        }

		        return null; // If no OTP is found
		        
				
			}
        
     }
