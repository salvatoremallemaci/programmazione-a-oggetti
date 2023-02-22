package it.polito.test;
import junit.framework.TestCase;
import java.util.*;
import groups.*;

public class TestReq2 extends TestCase {
	GroupHandling gh = new GroupHandling();
	protected void setUp() throws Exception {
		super.setUp();
		try{	
			gh.addProduct("beta", "f1","f3","f2");
			gh.addProduct("alfa", "f2","f5","f3");
			gh.addProduct("gamma", "f6","f3","f4","f1");
			gh.addGroup("betaGroup", "beta", "q5","p3","p2");
			gh.addGroup("alfaGroup", "alfa", "q4","p3","p1");
		}catch(Exception e){
			fail("no exception must be thrown");
		}
	}
	
	public void testAddGroup() {
		try {
			gh.addGroup("alfaGroup", "beta", "q3","q1");
			fail("group duplicated");
		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}
		}
	public void testAddGroup2() {
		try {
			gh.addGroup("deltaGroup", "delta", "q3","q1");
			fail("unknown product");
		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}
		}
		
	public void testGetGroups() {
		try {
			List<String> list = gh.getGroups("p3");  
			assertNotNull(list);
			//System.out.println(list);
			String s = "[alfaGroup, betaGroup]";
			assertTrue(list.toString().equals(s));
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	
}
