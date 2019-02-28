package WatertankSimulation;

import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank tank = new Tank();
		
		ReleaseParameters rel = new PeriodicParameters(new RelativeTime(1000,0));
		
		RealtimeThread in = new RealtimeThread(null, rel, null, null, null, new WaterFeeder(tank));
		tank.didReachMax.addHandler(new MixHandler(rel, in, HandlerType.MAX));
		in.start();
		
		RealtimeThread out = new RealtimeThread(null, rel, null, null, null, new WaterExhauster(tank));
		tank.didReachMin.addHandler(new MixHandler(rel, in, HandlerType.MIN));
		out.start();
	}

}
