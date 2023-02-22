package sports;
import java.util.*;
import static java.util.stream.Collectors.*;

/**
 * Facade class for the research evaluation system
 *
 */
public class Sports {
	
	Map<String,Activity> attivit‡ = new TreeMap<>();
	Map<String,Category> categorie = new TreeMap<>();
	Map<String,Product> prodotti = new TreeMap<>();
	List<Rating> recensioni = new ArrayList<>();
	int stelle = 0;
	//List<String> elencoAttivit‡ = new ArrayList<>();

    //R1
    /**
     * Define the activities types treated in the portal.
     * The method can be invoked multiple times to add different activities.
     * 
     * @param actvities names of the activities
     * @throws SportsException thrown if no activity is provided
     */
    public void defineActivities (String... activities) throws SportsException {
    	int count = 0;
    	for (String a : activities) {
    		count++;
    	}
    	if(count == 0)
    		throw new SportsException("Non Ë passata alcuna attivit‡.\n");
    	
    	for (String a : activities) {
    		Activity act = new Activity(a);
    		attivit‡.put(a, act);
    		//elencoAttivit‡.add(a);
    	}
    }

    /**
     * Retrieves the names of the defined activities.
     * 
     * @return activities names sorted alphabetically
     */
    public List<String> getActivities() {
        return attivit‡.values().stream()
        		.map(Activity::getAttivit‡)
        		.collect(toList());
        
    }


    /**
     * Add a new category of sport products and the linked activities
     * 
     * @param name name of the new category
     * @param activities reference activities for the category
     * @throws SportsException thrown if any of the specified activity does not exist
     */
    public void addCategory(String name, String... linkedActivities) throws SportsException {
    	for (String s : linkedActivities) {
    		if(!attivit‡.containsKey(s))
    			throw new SportsException("Qualcuna delle attivit‡ non Ë definita.\n");
    	}
    	Category c = new Category(name);
    	for (String s : linkedActivities) {
    		c.getAttivit‡Collegate().add(s);
    		attivit‡.get(s).getCategorieLegate().add(name);
    	}
    	categorie.put(name, c);
    }

    /**
     * Retrieves number of categories.
     * 
     * @return categories count
     */
    public int countCategories() {
        return categorie.size();
    }

    /**
     * Retrieves all the categories linked to a given activity.
     * 
     * @param activity the activity of interest
     * @return list of categories (sorted alphabetically)
     */
    public List<String> getCategoriesForActivity(String activity) {
    	List<String> listaVuota = new ArrayList<>();
    	if(!attivit‡.containsKey(activity))
    		return listaVuota;
    	if(attivit‡.get(activity).getCategorieLegate().size()==0)
    		return listaVuota;
    	return attivit‡.get(activity).getCategorieLegate().stream()
    	.sorted().collect(toList());
    }

    //R2
    /**
     * Add a research group and the relative disciplines.
     * 
     * @param name name of the research group
     * @param disciplines list of disciplines
     * @throws SportsException thrown in case of duplicate name
     */
    public void addProduct(String name, String activityName, String categoryName) throws SportsException {
    	if(prodotti.containsKey(name))
    		throw new SportsException("Questo prodotto esiste gi‡.\n");
    	Product p = new Product(name, activityName, categoryName);
    	prodotti.put(name, p);
    	attivit‡.get(activityName).getProdottiLegati().add(p);
    }

    /**
     * Retrieves the list of products for a given category.
     * The list is sorted alphabetically.
     * 
     * @param categoryName name of the category
     * @return list of products
     */
    public List<String> getProductsForCategory(String categoryName){
    	List<String> listaVuota = new ArrayList<>();
    	if(!categorie.containsKey(categoryName))
    		return listaVuota;
    	
    	List<String> res;
    	res = prodotti.values().stream()
    	.filter(p -> p.getCategoria().equals(categoryName))
    	.map(p -> p.getNome())
    	.sorted()
    	.collect(toList());
    	
    	if(res!=null)
    		return res;
    	return listaVuota;
    }

    /**
     * Retrieves the list of products for a given activity.
     * The list is sorted alphabetically.
     * 
     * @param activityName name of the activity
     * @return list of products
     */
    public List<String> getProductsForActivity(String activityName){
    	List<String> listaVuota = new ArrayList<>();
    	if(!attivit‡.containsKey(activityName))
    		return listaVuota;
    	
    	List<String> res;
    	res = prodotti.values().stream()
    	.filter(p -> p.getNomeAttivit‡().equals(activityName))
    	.map(p -> p.getNome())
    	.sorted()
    	.collect(toList());
    	
    	if(res!=null)
    		return res;
    	return listaVuota;
    }

    /**
     * Retrieves the list of products for a given activity and a set of categories
     * The list is sorted alphabetically.
     * 
     * @param activityName name of the activity
     * @param categoryNames names of the categories
     * @return list of products
     */
    public List<String> getProducts(String activityName, String... categoryNames){
    	List<String> listaVuota = new ArrayList<>();
    	Set<String> insiemeCategorie = new TreeSet<>();
 
    	int count = 0;
    	
    	for (String s : categoryNames) {
    		insiemeCategorie.add(s);
    	}
    	
    	if(!attivit‡.containsKey(activityName))
    		return listaVuota;
    	
    	for (String s : insiemeCategorie) {
    		if(categorie.containsKey(s)) {
    			count++;
    		}
    			
    	}
    	if(count==0)
    		return listaVuota;
    	
    	List<String> res;
    	res = prodotti.values().stream()
    	.filter(p -> p.getNomeAttivit‡().equals(activityName))
    	.filter(p -> insiemeCategorie.contains(p.getCategoria()))
    	.map(p -> p.getNome())
    	.sorted()
    	.collect(toList());
    	
    	
    	return res;
    }

    //    //R3
    /**
     * Add a new product rating
     * 
     * @param productName name of the product
     * @param userName name of the user submitting the rating
     * @param numStars score of the rating in stars
     * @param comment comment for the rating
     * @throws SportsException thrown numStars is not correct
     */
    public void addRating(String productName, String userName, int numStars, String comment) throws SportsException {
    	
    	Rating r = new Rating(productName, userName, numStars, comment);
    	if(numStars<0 || numStars>5)
    		throw new SportsException("Range voto infranto.\n");
    	recensioni.add(r);
    	prodotti.get(productName).getRecensioniProdotto().add(r);
    }



    /**
     * Retrieves the ratings for the given product.
     * The ratings are sorted by descending number of stars.
     * 
     * @param productName name of the product
     * @return list of ratings sorted by stars
     */
    public List<String> getRatingsForProduct(String productName) {
    	List<String> listaVuota = new ArrayList<>();
    	if(prodotti.get(productName).getRecensioniProdotto().isEmpty())
    		return listaVuota;
    	return prodotti.get(productName).getRecensioniProdotto().stream()
    	.sorted(Comparator.comparing((Rating r) -> r.getNumeroStelle()).reversed())
    	.map( (Rating r) -> r.getNumeroStelle() + " : " + r.getCommento())
    	.collect(toList());
    }


    //R4
    /**
     * Returns the average number of stars of the rating for the given product.
     * 
     * 
     * @param productName name of the product
     * @return average rating
     */
    public double getStarsOfProduct (String productName) {
    	double numeroMedioStelle;
    	stelle = 0;
    	int totaleRecensioni = prodotti.get(productName).getRecensioniProdotto().size();
    	prodotti.get(productName).getRecensioniProdotto().stream()
    	.forEach(r -> stelle += r.getNumeroStelle());
    	
    	numeroMedioStelle = (double) stelle/totaleRecensioni;
    	
        return numeroMedioStelle;
    }

    /**
     * Computes the overall average stars of all ratings
     *  
     * @return average stars
     */
    public double averageStars() {
    	double numeroMedieStelle;
    	stelle = 0;
    	int totaleRecensioniGenerali = recensioni.size();
    	
    	recensioni.stream()
    	.forEach(r -> stelle += r.getNumeroStelle());
    	
    	numeroMedieStelle = (double) stelle/totaleRecensioniGenerali;
        return numeroMedieStelle;

    }

    //R5 Statistiche
    /**
     * For each activity return the average stars of the entered ratings.
     * 
     * Activity names are sorted alphabetically.
     * 
     * @return the map associating activity name to average stars
     */
    public SortedMap<String, Double> starsPerActivity() {
    	SortedMap<String,Double> m = new TreeMap<>();
    	for (Product p : prodotti.values()) {
    		if(!p.getRecensioniProdotto().isEmpty())
    			m.put(p.getNomeAttivit‡(),getStarsOfProduct(p.getNome()));
    	}
    	return m;
    }

    /**
     * For each average star rating returns a list of
     * the products that have such score.
     * 
     * Ratings are sorted in descending order.
     * 
     * @return the map linking the average stars to the list of products
     */
    public SortedMap<Double, List<String>> getProductsPerStars () {
    	return prodotti.values().stream()
    	.filter(a -> !a.getRecensioniProdotto().isEmpty())
    	.collect(groupingBy(
    			(Product p) -> getStarsOfProduct(p.getNome()),toList()))
    	.entrySet().stream()
    	.collect(toMap(e -> (double)e.getKey(), e -> (List<String>)e.getValue().stream().map(f -> f.getNome())
    			.collect(toList()), (a,b) -> a, TreeMap::new)).descendingMap();
    }

}