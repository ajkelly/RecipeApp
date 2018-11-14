package simpleRecipesApp.recipes.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import simpleRecipesApp.recipes.model.Recipe;
import simpleRecipesApp.recipes.service.RecipeService;

/**
 * Class for retrieving, adding, updating and removing recipes.
 * 
 * @author Alex Kelly
 */
@Path("recipes")
public class RecipeResource {

	RecipeService service = new RecipeService();
	
	/**
	 * Method that handles http GET requests.
	 * 
	 * @return JSON media type of all recipe objects
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getAllRecipes() {
		
		return service.getAllRecipes();
	}
	
	/**
	 * Method that also handles http GET requests.
	 * 
	 * @param recipeName unique identifier for the recipe being retrieved
	 * @return JSON media type of a list of recipe objects matching the
	 * parameter name
	 */
	@GET
	@Path("/{recipeName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Recipe> getRecipe(@PathParam("recipeName") String recipeName) {
		
		return service.getRecipe(recipeName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addRecipe(Recipe recipe) {
		
		service.addRecipe(recipe);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateRecipe(int id, Recipe recipe) {
		
		service.updateRecipe(id, recipe);
	}
	
	@DELETE
	@Path("/{recipeID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removeRecipe(@PathParam("recipeID") int recipeID) {
		
		service.removeRecipe(recipeID);
	}
	
}
