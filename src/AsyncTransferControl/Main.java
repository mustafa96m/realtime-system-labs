package AsyncTransferControl;

import java.util.Scanner;

import javax.realtime.PeriodicParameters;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;

import WatertankSimulation.*;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		ModeThread modeThread = new ModeThread();
		RelativeTime rt = new RelativeTime(300,0);
		ReleaseParameters rp = new PeriodicParameters(rt);
		modeThread.setReleaseParameters(rp);
		//modeThread.start();
		
		
		Tank tank = new Tank();
		
		ReleaseParameters rel = new PeriodicParameters(new RelativeTime(1000,0));
		
		RealtimeThread in = new RealtimeThread(null, rel, null, null, null, new WaterFeeder(tank));
		tank.didReachMax.addHandler(new MixHandler(rel, in, HandlerType.MAX));
		in.start();
		
		RealtimeThread out = new RealtimeThread(null, rel, null, null, null, new WaterExhauster(tank));
		tank.didReachMin.addHandler(new MixHandler(rel, in, HandlerType.MIN));
		out.start();
		
		
		while (true) {
			scanner.nextLine();
			modeThread.event.fire();
		}
		
	}
	
}
