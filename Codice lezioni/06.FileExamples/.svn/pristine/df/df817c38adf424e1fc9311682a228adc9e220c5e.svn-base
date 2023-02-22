package it.polito.po.fileexamples;

import java.util.Optional;

public class TemplateCSV {
	
	static final char SEPARATOR = ",";
	
	
	private List<YourJavaItem> processInputFile(String inputFilePath) {
		
		
	    List<YourJavaItem> inputList = new ArrayList<YourJavaItem>();
	    
	    try{
//	      File inputF = new File(inputFilePath);
//		  InputStream inputFS = new FileReader(inputF);
//	      BufferedReader br = new BufferedReader(new FileReader(inputFS));
	      //OR
		  BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
		  
		  
		  
		  // skip or process the header of the csv
	      inputList = br.lines().skip(1).map(processLine).collect(Collectors.toList());
		  //OR
		  //String[] headers = br.remove(0);
		  //processHeaders(headers);
		  //inputList = br.lines().map(processLine).collect(Collectors.toList());
		  
	      br.close();
	    } catch (FileNotFoundException|IOException e) {
	      ....
	    }
	    return inputList ;
	}
	

	private class StudentMark{
		private name;
		private Optional<String> nick;
		private id;
		private mark;
		
		StudentMark(String name, String nick, String id, String mark)
		{
			this.name=name;
			this.nick=nick;
			this.id=id;
			this.mark = Optional.ofNullable(mark);
//			if(mark==null)
//				this.mark=Optional.empty();
//			else
//				this.mark=mark;
		}
	}


	private Function<String, YourJavaItem> processLine = (line) -> {
	
	  String[] p = line.split(SEPARATOR);// a CSV has comma separated values, however better use a constant for the separator
	  YourJavaItem item = new YourJavaItem();
	  
	  if(p.length==3)
		  sm = new StudentMark(p[0],p[1],p[2],null);
	  else
		  sm = new StudentMark(p[0],p[1],p[2],p[3]);
	  
	  StudentMark sm = new StudentMark(p[0],p[1],p[2]);
	  
	  item.doSomethingOnTheFirstValue(p[0]);//<-- this is the first column in the csv file
	  
	  //do something on an optional value
//	  if (p[3] != null && p[3].trim().length() > 0) {
//		item.setSomeProperty(p[3]);
//	  }
	  
	  
	  
	  //more operations on values go here
	  //..
	  return item;
	}
	
	
	private void processHeaders(){
	
	//...
	
	}
	
	
	
}
