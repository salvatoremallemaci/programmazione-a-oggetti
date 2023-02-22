package groups;
import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class GroupHandling {
	
	SortedMap<String,Product> products = new TreeMap<>();
	SortedMap<String,Supplier> suppliers = new TreeMap<>();
	
	SortedMap<String,Group> groups = new TreeMap<>();
	SortedMap<String,Customer> customers = new TreeMap<>();
	
//R1	
	public void addProduct (String productTypeName, String... supplierNames) 
			throws GroupHandlingException {
		
		if(products.containsKey(productTypeName))
			throw new GroupHandlingException("DUPLICATED PRODUCT "+productTypeName);
		Product p = new Product(productTypeName);
		products.put(productTypeName,p);
		
		for(String supplierName : supplierNames)
		{
			Supplier supplier = suppliers.get(supplierName);
			if(supplier == null)
			{
				supplier = new Supplier(supplierName);
				suppliers.put(supplierName, supplier);
			}
			p.suppliers.add(supplierName);
			supplier.products.add(productTypeName);
		}
	}
	
	public List<String> getProductTypes (String supplierName) {
		return new ArrayList<>(suppliers.get(supplierName).products);
	}
	
//R2	
	public void addGroup (String name, String productName, String... customerNames) 
			throws GroupHandlingException {
		if(groups.containsKey(name))
			throw new GroupHandlingException("DUPLICATED GROUP "+name);
		
		Product p = products.get(productName);
		if(p==null)
			throw new GroupHandlingException("UNKNOWN PRODUCT "+productName);
		
		Group group = new Group(name);
		groups.put(name,group);
		group.setProductName(productName);
		
		for(String customerName : customerNames)
		{
			Customer customer = customers.get(customerName);
			if(customer == null)
			{
				customer = new Customer(customerName);
				customers.put(customerName, customer);
			}
			customer.groups.add(name);
			group.customers.add(customerName);
		}
	}
	
	public List<String> getGroups (String customerName) {
		return new ArrayList<>(customers.get(customerName).groups);
	}

//R3
	public void setSuppliers (String groupName, String... supplierNames)
			throws GroupHandlingException {
		Group group = groups.get(groupName);
		if(group == null)
			throw new GroupHandlingException("UNKNOWN GROUP "+groupName);
		Collection<String> suppliersTemp = new ArrayList<String>();
		for(String supplierName : supplierNames)
		{
			Supplier supplier = suppliers.get(supplierName);
			if(supplier == null)
				throw new GroupHandlingException("UNKNOWN SUPPLIER "+supplierName);
			if(!supplier.products.contains(group.getProductName()))
				throw new GroupHandlingException("UNSUITABLE SUPPLIER "+supplierName);
			suppliersTemp.add(supplierName);
		}
//		for(String supplierName : supplierNames)
//			group.suppliers.add(supplierName);
		group.suppliers.addAll(suppliersTemp);
	}
	
	public void addBid (String groupName, String supplierName, int price)
			throws GroupHandlingException {
		Group group = groups.get(groupName);
		if(group == null)
			throw new GroupHandlingException("UNKNOWN GROUP "+groupName);
		if(!group.suppliers.contains(supplierName))
			throw new GroupHandlingException("SUPPLIER NOT IN GROUP "+ supplierName);
		
		Bid bid = new Bid(supplierName, group.getProductName(), price);
		group.bids.put(supplierName,bid);
		
		suppliers.get(supplierName).nBids++;
	}
	
	public String getBids (String groupName) {
		Group group = groups.get(groupName);
//		if(group == null)
//			throw new GroupHandlingException("UNKNOWN GROUP "+groupName);
		return group.bids.values().stream()
				.sorted(comparing(Bid::getPrice).thenComparing(Bid::getSupplierName))
				.map(bid -> {return bid.getSupplierName() + ":" + bid.getPrice();})
				.collect(joining(","));
	}
	
	
//R4	
	public void vote (String groupName, String customerName, String supplierName)
			throws GroupHandlingException {
		Group group = groups.get(groupName);
		if(group == null)
			throw new GroupHandlingException("UNKNOWN GROUP "+groupName);
		if(!group.customers.contains(customerName))
			throw new GroupHandlingException("UNKNOWN CUSTOMER "+customerName);
		Bid bid = group.bids.get(supplierName);
		if(bid == null)
			throw new GroupHandlingException("NO BID FROM SUPPLIER "+ supplierName);
		bid.nVotes++;
	}
	
	public String  getVotes (String groupName) {
		Group group = groups.get(groupName);
//		if(group == null)
//			throw new GroupHandlingException("UNKNOWN GROUP "+groupName);
		return group.bids.values().stream().
				filter(bid -> bid.nVotes > 0)
				.map(bid -> { return bid.getSupplierName() + ":" + bid.nVotes;})
				.collect(joining(","));
	}
	
	public String getWinningBid (String groupName) {
		Group group = groups.get(groupName);
		
		Bid bid = group.bids.values().stream().
			max(comparing(Bid::getnVotes)
			.thenComparing(Bid::getPrice, reverseOrder())).orElse(null);
		
		if(bid == null) return null;
		return bid.getSupplierName() + ":" + bid.nVotes;
	}
	
//R5
	public SortedMap<String, Integer> maxPricePerProductType() { 
		return groups.values().stream()
				.flatMap(g -> g.bids.values().stream())
				//stream di Bid
//				.collect(toMap(
//							Bid::getProductName,
//							Bid::getPrice,
//							(p1,p2) -> { return p1 >= p2 ? p1 : p2; },
//							TreeMap::new
//						));
				.collect(groupingBy(
							Bid::getProductName,
							TreeMap::new,
							collectingAndThen(
									maxBy(comparing(Bid::getPrice)),
									o -> o.get().getPrice()
								)
						));
	}
	
	public SortedMap<Integer, List<String>> suppliersPerNumberOfBids() {
		return suppliers.values().stream()
				.filter(s -> s.getnBids()>0)
				.collect(groupingBy(
									Supplier::getnBids,
									() -> new TreeMap<Integer,List<String>>(reverseOrder()),
									mapping(Supplier::getName,toList())
								)
						);
	}
	
	public SortedMap<String, Long> numberOfCustomersPerProductType() {
		return groups.values().stream()
				.filter(g -> !g.customers.isEmpty())
				.collect(groupingBy(
							Group::getProductName,
							TreeMap::new,
							summingLong(g -> g.customers.size())
						));
	}
	
}
