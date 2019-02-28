package WatertankSimulation;

import javax.realtime.AsyncEventHandler;
import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;

enum HandlerType {
	MAX, MIN
}

public class MixHandler extends AsyncEventHandler {
	
	ReleaseParameters rel = null;
	RealtimeThread rtt = null;
	HandlerType type = null;
	
	public MixHandler(ReleaseParameters rel, RealtimeThread rtt, HandlerType type) {
		// TODO Auto-generated constructor stub
		this.rel = rel;
		this.rtt = rtt;
		this.type = type;
	}
	
	public void handleAsyncEvent() {
		System.out.println("Event " + this.type.toString() + " Triggered");
		if (this.type == HandlerType.MAX) {
			//this.rtt.deschedulePeriodic();
			this.rescheduleTo(1000 * 5);
		} else {
			this.rescheduleTo(1000 * 1);
		}
	}
	
	public void rescheduleTo(int period) {
		rel = new PeriodicParameters(new RelativeTime(period,0));
		this.rtt.setReleaseParametersIfFeasible(rel);
	}

}
