package simpleRecipesApp.recipes.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model Class for creating an object of type recipe.
 * 
 * @author Alex Kelly
 */
@XmlRootElement
public class Recipe {

	private int id;
	private String creatorName;
	private String dateAdded;
	private String recipeName;
	private String veganOrVegetarian;
	private String mealType;
	private int numServings;
	private int prepTime;
	private int totalTime;
	private double difficultyRating;
	private String about;
	private String ingredients;
	private String instructions;
	
	/**
	 * No argument constructor
	 */
	public Recipe() {
		
	}

	/**
	 * Constructor for getting a recipe from database
	 * (includes the recipe id and dateAdded)
	 * 
	 * @param id - unique identifier for Recipe in database
	 * @param creatorName - chef
	 * @param recipeName - name of the Recipe
	 * @param veganOrVegetarian - whether the recipe is vegan or vegetarian
	 * @param mealType - type of meal (eg. breakfast, lunch, dinner)
	 * @param numServings - how many people it feeds
	 * @param prepTime - how long to prepare before cooking
	 * @param totalTime - the total time including preparation and cooking time
	 * @param difficultyRating - how difficult it is to make, 3 being hardest and 1 easiest
	 * @param about - additional information about the Recipe
	 * @param ingredients - the ingredients included
	 * @param instructions - directions on how to make
	 */
	public Recipe(int id, String creatorName, String dateAdded, String recipeName, String veganOrVegetarian, String mealType,
			int numServings, int prepTime, int totalTime, double difficultyRating, String about, String ingredients,
			String instructions) {
		
		this.id = id;
		this.creatorName = creatorName;
		this.dateAdded = dateAdded;
		this.recipeName = recipeName;
		this.veganOrVegetarian = veganOrVegetarian;
		this.mealType = mealType;
		this.numServings = numServings;
		this.prepTime = prepTime;
		this.totalTime = totalTime;
		this.difficultyRating = difficultyRating;
		this.about = about;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getVeganOrVegetarian() {
		return veganOrVegetarian;
	}

	public void setVeganOrVegetarian(String veganOrVegetarian) {
		this.veganOrVegetarian = veganOrVegetarian;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public int getNumServings() {
		return numServings;
	}

	public void setNumServings(int numServings) {
		this.numServings = numServings;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public double getDifficultyRating() {
		return difficultyRating;
	}

	public void setDifficultyRating(double difficultyRating) {
		this.difficultyRating = difficultyRating;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	@Override
	public String toString() {
		return "\nRecipe id: " + id + " --> " + recipeName + "\n-> chef(s) = " + creatorName + "\n-> date added = " + dateAdded + "\n-> vegan/vegetarian details = " 
				+ veganOrVegetarian + "\n-> meal type = " + mealType + "\n-> number of servings = " + numServings + 
				"\n-> prep time = " + prepTime + "mins" + " -> total time = " + totalTime + "mins" + "\n-> difficulty rating = "
				+ difficultyRating + "\n-> about this recipe.. " + about + "\n-> ingredients = " + ingredients + "\n-> instructions: \n   "
				+ instructions;
	}
	
}
