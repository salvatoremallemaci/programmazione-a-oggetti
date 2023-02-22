package it.polito.test;
import junit.framework.TestCase;
import java.util.*;
import groups.*;

public class TestReq1 extends TestCase {
	GroupHandling gh = new GroupHandling();
	protected void setUp() throws Exception {
		super.setUp();
		try{	
			gh.addProduct("beta", "f1","f3","f2");
			gh.addProduct("alfa", "f2","f5","f3");
			gh.addProduct("gamma", "f6","f3","f4","f1");
		}catch(Exception e){
			fail("no exception must be thrown");
		}
	}
	
	public void testAddProduct() {
		try {
			gh.addProduct("alfa", "f6");
			fail("product duplicated");
		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}
		}
		
	public void testGetProductTypes() {
		try {
			List<String> list = gh.getProductTypes("f3");  
			assertNotNull(list);
			//System.out.println(list);
			String s = "[alfa, beta, gamma]";
			assertTrue(list.toString().equals(s));
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	
}
