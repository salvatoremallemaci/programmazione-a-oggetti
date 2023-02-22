package it.polito.oop.esempislide;

public class Point {
	
	private int x,y;
	
	public int getX() 
	{
		return x;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public Point (int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void move (int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public String toString()
	{
		return " x = " + x + "y = " +y;
	}
	
	public static Point sum (Point p1, Point p2)
	{
		return new Point (p1.x + p2.x,p1.y + p2.y);
		
	}
	
	
	public static void main(String[] args)
	{
		int coord_x;
		int coord_y;
		
		coord_x=Integer.parseInt(args[0]);
		coord_y=Integer.parseInt(args[1]);
		
		Point p1 = new Point(coord_x,coord_y);
		
		//stampo coordinata x di p1 mediante metodo getX
		System.out.println("Coordinata x=" + p1.getX());
		
		//stampo coordinata y di p2 mediante metodo getY
		System.out.println("Coordinata y=" + p1.getY());
		
		//stampo p1
		System.out.println(p1);
		/* OSSERVAZIONE:
		   System.out.println(p1.toString()) ===== System.out.println(p1);
		   queste ultime sono equivalenti, ma attenzione!
	       E' necessario a prescindere il metodo toString... */
		
		//Sposto il punto p1, mediante il metodo /move/
		p1.move(20, 35);
		//stampo p1 post spostamento
		
		System.out.println(p1);
		Point p2 = new Point(10,20);
		Point p3 = new Point(100,200);
		Point p4 = sum(p2,p3);
		System.out.println(p4);
	}
	
}
