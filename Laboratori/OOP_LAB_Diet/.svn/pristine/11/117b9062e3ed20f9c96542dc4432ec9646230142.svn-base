package diet;

public class WorkingHours {

	private Time open;
	private Time close;
	
	public WorkingHours(String open, String close) {
		String [] open_h_m = open.split(":");
		String [] close_h_m = close.split(":");
		this.open = new Time(Integer.parseInt(open_h_m[0]), Integer.parseInt(open_h_m[1]));
		this.close = new Time(Integer.parseInt(close_h_m[0]), Integer.parseInt(close_h_m[1]));
	}
	
	public Time getOpen() {
		return open;
	}
	public Time getClose() {
		return close;
	}


}
