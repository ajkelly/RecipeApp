package simpleRecipesApp.recipes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import simpleRecipesApp.recipes.model.Recipe;

/**
 * Class which contains methods implementing logic
 * for the program.
 * 
 * @author Alex Kelly
 */
public class RecipeService {
	
	private String tableName;
	
	/**
	 * CONSTRUCTOR
	 * @param tableName 
	 */
	public RecipeService() {
		tableName = "katsrecipes";
	}

	/**
	 * Method which will create the relevant table within the database
	 * if it does not already exist
	 * @param tableName the name of the table to be created
	 */
	private void createTable() {
		String createTableSQL = "CREATE TABLE IF NOT EXISTS " + tableName + "\n" + 
				"  (\n" + 
				"  id                  SERIAL NOT NULL PRIMARY KEY,\n" + 
				"  creator_name        VARCHAR(40),\n" + 
				"  date_added          VARCHAR(12),\n" + 
				"  recipe_name         VARCHAR(80),\n" + 
				"  vegan_or_vegetarian VARCHAR(50),\n" + 
				"  meal_type           VARCHAR(25),\n" + 
				"  number_of_servings  INTEGER,\n" + 
				"  preparation_time    INTEGER,\n" + 
				"  total_time          INTEGER,\n" + 
				"  difficulty_rating   DOUBLE PRECISION,\n" + 
				"  about_this_recipe   VARCHAR(5000),\n" + 
				"  ingredients         VARCHAR(5000),\n" + 
				"  instructions        VARCHAR(5000)\n" + 
				");";
		
		try (Connection conn = ConnectDB.connect();
		     PreparedStatement pstmt = conn.prepareStatement(createTableSQL)) {
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to check whether the recipe table is empty.
	 */
	private void checkIfEmpty() {
		
		String isEmptySQL = "SELECT EXISTS (SELECT 1 FROM katsrecipes);";
		
		try (Connection conn = ConnectDB.connect();
		    PreparedStatement pstmt = conn.prepareStatement(isEmptySQL);
			ResultSet rs = pstmt.executeQuery()) {
		         
			int count = 0;
			
			while(rs.next()) {
		        	 count = rs.getInt(1);
		    }
				
			if (count < 1) {
				System.out.println("No recipes found in the database!");
			}

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	
//	private String formatInstructions(String instructions) {
//		
//		for (int i = 0; i < instructions.length(); i++) {
//			
//			char c = instructions.charAt(i);
//			String regex = "[0-9]+";
//			
//			if (Character.toString(c).matches(regex)) {
//				//code to move i-1 to next line (insert \n)
//			}
//		}
//		
//		return instructions;
//	}
	
	/**
	 * Method for retrieving all the recipes.
	 * 
	 * @return a list of all recipes
	 */
	public List<Recipe> getAllRecipes() {
		
		String selectAllSQL = "SELECT * FROM " + tableName + ";";
		List<Recipe> allRecipes = new ArrayList<>();
		
		createTable();
		checkIfEmpty();
		
		try (Connection conn = ConnectDB.connect();
	        PreparedStatement pstmt = conn.prepareStatement(selectAllSQL);
			ResultSet rs = pstmt.executeQuery()) {
	         
			while(rs.next()) {
	        	 	int id = rs.getInt("id");
	        	 	String creatorName = rs.getString("creator_name");
	        	 	String date = rs.getString("date_added");
	        	 	String recipeName = rs.getString("recipe_name");
	        	 	String veganOrVegetarian = rs.getString("vegan_or_vegetarian");
	        	 	String mealType = rs.getString("meal_type");
	        	 	int numServings = rs.getInt("number_of_servings");
	        	 	int prepTime = rs.getInt("preparation_time");
	        	 	int totalTime = rs.getInt("total_time");
	        	 	double difficultyRating = rs.getDouble("difficulty_rating");
	        	 	String about = rs.getString("about_this_recipe");
	        	 	String ingredients = rs.getString("ingredients");
	        	 	String instructions = rs.getString("instructions");
	        	 	
	        	 	Recipe recipe = new Recipe(id, creatorName, date, recipeName, veganOrVegetarian, mealType, numServings, prepTime, totalTime,
	        	 			difficultyRating, about, ingredients, instructions);
	        	 	
	        	 	System.out.println(recipe.toString());
	        	 	
	        	 	allRecipes.add(recipe);
	         }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return allRecipes;
	}
	
	/**
	 * Method for retrieving a recipe by the name.
	 * 
	 * @param name of the individual recipe(s) to retrieve
	 * @return a list of recipes matching the name parameter
	 */
	public List<Recipe> getRecipe(String name) {
		
		String selectAllSQL = "SELECT * FROM " + tableName + " WHERE recipe_name LIKE '" + name + "';";
		List<Recipe> recipes = new ArrayList<>();
		
		createTable();
		checkIfEmpty();
		
		try (Connection conn = ConnectDB.connect();
	        PreparedStatement pstmt = conn.prepareStatement(selectAllSQL);
			ResultSet rs = pstmt.executeQuery()) {
	         
	         while(rs.next()) {
	        	 	int id = rs.getInt("id");
	        	 	String creatorName = rs.getString("creator_name");
	        	 	String date = rs.getString("date_added");
	        	 	String recipeName = rs.getString("recipe_name");
	        	 	String veganOrVegetarian = rs.getString("vegan_or_vegetarian");
	        	 	String mealType = rs.getString("meal_type");
	        	 	int numServings = rs.getInt("number_of_servings");
	        	 	int prepTime = rs.getInt("preparation_time");
	        	 	int totalTime = rs.getInt("total_time");
	        	 	double difficultyRating = rs.getDouble("difficulty_rating");
	        	 	String about = rs.getString("about_this_recipe");
	        	 	String ingredients = rs.getString("ingredients");
	        	 	String instructions = rs.getString("instructions");
	        	 	
	        	 	Recipe recipe = new Recipe(id, creatorName, date, recipeName, veganOrVegetarian, mealType, numServings, prepTime, totalTime,
	        	 			difficultyRating, about, ingredients, instructions);
	        	 	
	        	 	recipes.add(recipe);
	         }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		System.out.println(recipes.toString());
		return recipes;
	}
	
	/**
	 * Method for adding a new recipe.
	 * 
	 * @param recipe the recipe object to be added
	 */
	public void addRecipe(Recipe recipe) {
		
		String insertSQL = "INSERT into " + tableName + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int id = recipe.getId();
		String creatorName = recipe.getCreatorName();
		String date = recipe.getDateAdded();
		String recipeName = recipe.getRecipeName();
		String veganOrVegetarian = recipe.getVeganOrVegetarian();
		String mealType = recipe.getMealType();
		int numServings = recipe.getNumServings();
		int prepTime = recipe.getPrepTime();
		int totalTime = recipe.getTotalTime();
		double difficultyRating = recipe.getDifficultyRating();
		String about = recipe.getAbout();
		String ingredients = recipe.getIngredients();
		String instructions = recipe.getInstructions();
		
		createTable();
		
		try (Connection conn = ConnectDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
			
			pstmt.setInt(1, id);
			pstmt.setString(2, creatorName);
			pstmt.setString(3, date);
			pstmt.setString(4, recipeName);
			pstmt.setString(5, veganOrVegetarian);
			pstmt.setString(6, mealType);
			pstmt.setInt(7, numServings);
			pstmt.setInt(8, prepTime);
			pstmt.setInt(9, totalTime);
			pstmt.setDouble(10, difficultyRating);
			pstmt.setString(11, about);
			pstmt.setString(12, ingredients);
			pstmt.setString(13, instructions);
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to update a recipe.
	 * 
	 * @param id of the recipe to be modified
	 * @param recipe the new recipe object containing the details to be updated
	 */
	public void updateRecipe(int id, Recipe recipe) {
		
		checkIfEmpty();
		
		String updateSQL = "UPDATE " + tableName + " SET id = ?, creator_name = ?, date_added = ?, recipe_name = ?, vegan_or_vegetarian = ?, meal_type = ?, number_of_servings = ?,"
				+ " preparation_time = ?, total_time = ?, difficulty_rating = ?, about_this_recipe = ?, ingredients = ?,"
				+ " instructions = ? WHERE id = " + id + ";";
		
		id = recipe.getId();
		String creatorName = recipe.getCreatorName();
		String date = recipe.getDateAdded();
		String recipeName = recipe.getRecipeName();
		String veganOrVegetarian = recipe.getVeganOrVegetarian();
		String mealType = recipe.getMealType();
		int numServings = recipe.getNumServings();
		int prepTime = recipe.getPrepTime();
		int totalTime = recipe.getTotalTime();
		double difficultyRating = recipe.getDifficultyRating();
		String about = recipe.getAbout();
		String ingredients = recipe.getIngredients();
		String instructions = recipe.getInstructions();
		
		try (Connection conn = ConnectDB.connect();
	        PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
			
				pstmt.setInt(1, id);
				pstmt.setString(2, creatorName);
				pstmt.setString(3, date);
				pstmt.setString(4, recipeName);
				pstmt.setString(5, veganOrVegetarian);
				pstmt.setString(6, mealType);
				pstmt.setInt(7, numServings);
				pstmt.setInt(8, prepTime);
				pstmt.setInt(9, totalTime);
				pstmt.setDouble(10, difficultyRating);
				pstmt.setString(11, about);
				pstmt.setString(12, ingredients);
				pstmt.setString(13, instructions);
				
				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	/**
	 * Method for removing a recipe.
	 * 
	 * @param id the of the recipe to be removed
	 */
	public void removeRecipe(int id) {
		
		checkIfEmpty();
		
		String deleteSQL = "DELETE FROM " + tableName + " WHERE id = " + id + ";";
		
		try (Connection conn = ConnectDB.connect();
	        PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
				
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * MAIN METHOD.
	 */
	public static void main(String[] args) {
		
//		RecipeService rs = new RecipeService();
//		Recipe recipe1 = new Recipe(1, "katja", "21/10/2018", "peanut butters", "this dish is vegetarian friendly", "dinner", 2, 45, 120, 1.5, "yum", "chilli, peanut butter, chicken, lots more..", "add salt, a bit more salt, and loads of salt.. then consume.");
//		rs.addRecipe(recipe1);
//		
//		Recipe recipe2 = new Recipe(2, "alex and katja", "23/10/2018", "spaghetti", "vegan delight", "dinner", 4, 15, 40, 1.5, "delicious", "pasta, meatballs, herbs..", "1. add salt 2. dese nuts 3. consume 4. digest 5. wifi in your pants");
//		rs.addRecipe(recipe2);
//		
//		rs.getAllRecipes();
//		
//		rs.getRecipe("peanut butters");
//		
//		Recipe recipe3 = new Recipe(3, "katja", "23/10/2018", "spaghetti", "vegan delight", "dinner", 4, 15, 40, 1.5, "delicious", "pasta, meatballs, herbs..", "\n1. add salt \n2. dese nuts \n3. consume \n4. digest \n5. wifi in your pants");
//		rs.addRecipe(recipe3);
//		
//		rs.removeRecipe(2);
//		
//		rs.updateRecipe(3, recipe3);
	}
	
}
