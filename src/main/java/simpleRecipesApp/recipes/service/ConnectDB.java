package simpleRecipesApp.recipes.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class which establishes a connection to the relevant
 * PostgreSQL database and returns a connection object.
 * 
 * @author Alex Kelly
 */
public class ConnectDB {

	private final static String DB_NAME = "allrecipes";
    private final static String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private final static String USER = "root";
    private final static String PASS = "stonybrook";

    /**
     * Method for establishing a connection to the database.
     *
     * @return a connection object.
     */
    public static Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
//            System.out.println("connection established to " + DB_NAME);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        
        return conn;
    }

//    /**
//     * Main method to test connection.
//     */
//    public static void main(String[] args) {
//        ConnectDB.connect();
//    }
	
}
