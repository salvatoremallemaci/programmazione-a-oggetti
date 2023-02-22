package diet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import diet.Order.OrderStatus;

/**
 * Represents a restaurant in the take-away system
 *
 */
public class Restaurant {

	private String name;
	private Food food;
	private ArrayList<WorkingHours> working_hours; //08:30-14:00  19:00-00:00
	private Map<String, Menu> menus;
	

	/**
	 * Constructor for a new restaurant.
	 * 
	 * Materials and recipes are taken from the food object provided as argument.
	 * 
	 * @param name
	 *            unique name for the restaurant
	 * @param food
	 *            reference food object
	 */
	public Restaurant(String name, Food food) {
		this.name = name;
		this.food = food;
		working_hours = new ArrayList<WorkingHours>();
		menus = new HashMap<String, Menu>();
	}

	/**
	 * gets the name of the restaurant
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Define opening hours.
	 * 
	 * The opening hours are considered in pairs. Each pair has the initial time and
	 * the final time of opening intervals.
	 * 
	 * for a restaurant opened from 8:15 until 14:00 and from 19:00 until 00:00, is
	 * thoud be called as {@code setHours("08:15", "14:00", "19:00", "00:00")}.
	 * 
	 * @param hm
	 *            a list of opening hours
	 */
	/*
	 * es., per un ristorante aperto dalle 8:15 alle 14:00 e dalle 19:00 alle 00:00,
	 * gli argomenti devono essere "08:15", "14:00", "19:00", "00:00").
	 */

	public void setHours(String... hm) {
		
		working_hours.clear();
		for(int i=0; i<hm.length/2; i++) {
			working_hours.add(new WorkingHours(hm[2*i], hm[2*i+1]));
		}
		
	}

	public Menu getMenu(String name) {
		return menus.get(name);
	}

	/**
	 * Creates a new menu
	 * 
	 * @param name
	 *            name of the menu
	 * 
	 * @return the newly created menu
	 */
	public Menu createMenu(String name) {
		Menu m = food.createMenu(name);
		menus.put(name, m);
		return m;
	}

	/**
	 * Find all orders for this restaurant with the given status.
	 * 
	 * The output is a string formatted as:
	 * 
	 * <pre>
	 * Napoli, Judi Dench : (19:00):
	 * 	M6->1
	 * Napoli, Ralph Fiennes : (19:00):
	 * 	M1->2
	 * 	M6->1
	 * </pre>
	 * 
	 * The orders are sorted by name of restaurant, name of the user, and delivery
	 * time.
	 * 
	 * @param status
	 *            the status of the searched orders
	 * 
	 * @return the description of orders satisfying the criterion
	 */
	public String ordersWithStatus(OrderStatus status) {
		return null;
	}
}
