package it.polito.oop.esempislide;

public class DynamicString {

	
	private String ds = "";
	
	public DynamicString append (String s)
	{
		ds= ds + s;
		return this;
		
	}
	
	public String toString()
	{
		return ds;
	}
	
	public static void main(String[] args)
	{
		DynamicString ds = new DynamicString();
		ds.append("Ciao ").append("bello").append(" che fai?");
		System.out.println(ds);
	}	

	
}