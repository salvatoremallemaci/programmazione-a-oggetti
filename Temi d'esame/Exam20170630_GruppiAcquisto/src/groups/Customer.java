package groups;

import java.util.TreeSet;

public class Customer {
	private String name;

	public Customer(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	TreeSet<String> groups = new TreeSet<>();
	
	
}
