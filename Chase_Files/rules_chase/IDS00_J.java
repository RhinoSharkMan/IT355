package rules_chase;
import java.sql.*;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule IDS00-J - Prevent SQL Injection
 */
class IDS00_J {

    /**
 * Main method 
 */
    public static void main(String[] args) {
        //Example usage of exampleMethod
        try {
            exampleMethod("exampleUser", "examplePassword".toCharArray());
        } 
        catch (SQLException e) {
            System.out.println("ERROR: could not connect");
        }
    }

    
/**
* Example of IDS00-J with proper usage.
* 
* This method connects to the database, checks if the provided username is within 
* the allowed length, hashes the provided password, and verifies if the 
* combination of username and password exists in the database. 

* @param username the username to be authenticated
* @param password the password associated with the username, provided as a character array for security
* @throws SQLException if a database access error occurs or the connection cannot be closed
*/
    public static void exampleMethod(String username, char[] password) throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            String hashedPassword = hashPassword(password);
            //validate username length
            if (username.length() > 10) {
                throw new SecurityException("ERROR: Username is incorrect");
            }
            String sqlString = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = connection.prepareStatement(sqlString);
            /*
             * Use of PrepareedStatement and set*() mitigates the SQL injection vulnerability because the input is properly escaped by 
             * the user input. If you manually concatenat user input into an SQL query 
             * string, you can allow attackers to inject malicious SQL code
             */
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            ResultSet rs = stmt.executeQuery();
            //no result
            if (rs.next() == false) {
                throw new SecurityException("ERROR: Username or password incorrect");
            }
            //authenticated succesfully
            System.out.println("User authenticated successfully.");
        } 
        catch(Exception e)
        {
            System.out.println("ERROR: no SQL connection");
        }
        finally {
            //close resources
            if (connection != null) connection.close();
        }
    }


//Dummy method to simulate getting a connection
    private static Connection getConnection() {
        //Implement actual connection logic here
        return null;
    }


//Dummy method to simulate password hashing
    private static String hashPassword(char[] password) {
        //Implement actual hashing logic here
        return new String(password);
    }
}
