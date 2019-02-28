package WatertankSimulation;

import javax.realtime.AsyncEvent;

public class Tank {
	
	static final double OUT_RATE = 10;
	static final double IN_RATE = 20;
	static final double MAX = 110;
	static final double MIN = 20;
	
	AsyncEvent didReachMax = new AsyncEvent();
	AsyncEvent didReachMin = new AsyncEvent();
	
	double level = 0;
	
	Tank(){
		this.printLevel();
	}
	
	public void pourIn() {
		level += IN_RATE;
		this.printLevel();
	}
	
	public void pourOut() {
		level -= OUT_RATE;
		this.printLevel();		
	}
	
	public void printLevel() {
		System.out.println("Water Level : " + level);
	}
	
	public Boolean reachedMax() {
		return level == MAX || level + IN_RATE == MAX;
	}
	
	public Boolean reachedMin() {
		return level <= MIN;
	}
	
}
