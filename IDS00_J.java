
import java.sql.*;

/**
 * IT 355 - Group Project 1
 * Demonstration of rule IDS00-J with proper usage 
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
 */
    public static void exampleMethod(String username, char[] password) throws SQLException {
        
        try {
            connection = getConnection();
            String hashedPassword = hashPassword(password);
            //validate username length
            if (username.length() > 8) {
                throw new SecurityException("ERROR: Username is incorrect");
            }
            String sqlString = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = connection.prepareStatement(sqlString);
            /*
             * the set*() mitigates the SQL injection vulnerability because the input is properly escaped by 
             * automatic entrapment within double quotes. (REWORD)
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
            // Ensure resources are closed to avoid potential resource leaks
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
