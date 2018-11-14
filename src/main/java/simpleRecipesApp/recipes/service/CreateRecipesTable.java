package simpleRecipesApp.recipes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class which contains the method for creating the database
 * table which stores all the recipes.
 * 
 * @author Alex Kelly
 */
public class CreateRecipesTable {
	
	/**
     * Creates the recipes table
     */
    public void createRecipesTable() {

        String createTableSQL = 
        			"CREATE TABLE karbsysRecipes (\n" +
                "id SERIAL PRIMARY KEY,\n" +
                "creator_name VARCHAR(40),\n" +
                "date_added VARCHAR(12),\n" +
                "recipe_name VARCHAR(80),\n" +
                "vegan_or_vegetarian VARCHAR(40),\n" +
                "meal_type VARCHAR(25),\n" +
                "number_of_servings INT,\n" +
                "preparation_time INT,\n" +
                "total_time INT,\n" +
                "difficulty_rating DOUBLE PRECISION,\n" +
                "about_this_recipe VARCHAR(5000),\n" +
                "ingredients VARCHAR(5000),\n" +
                "instructions VARCHAR(8000)\n" +
                ");";

        //use auto closable for resources throughout
        try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(createTableSQL)) {

            pstmt.executeUpdate();
            System.out.println("karbsysRecipes table created");

        } catch (SQLException e) {
            System.err.println("Error creating karbsysRecipes table: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
//    public static void main(String[] args) {
//    	
//	    	 CreateRecipesTable c = new CreateRecipesTable();
//	    	 c.createRecipesTable();
//    }

}
