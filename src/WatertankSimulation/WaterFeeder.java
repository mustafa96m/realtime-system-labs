package WatertankSimulation;

import javax.realtime.RealtimeThread;

public class WaterFeeder implements Runnable {
	
	Tank tank = null;
	
	WaterFeeder(Tank tank) {
		this.tank = tank;
	}
	
	@Override
	public void run() {
		while (true) {
			if (this.tank.reachedMax()) {
				this.tank.didReachMax.fire();
			} else {
				this.tank.pourIn();
			}
			RealtimeThread.waitForNextPeriod();
		}
	}

}
