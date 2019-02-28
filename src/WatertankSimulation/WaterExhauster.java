package WatertankSimulation;

import javax.realtime.RealtimeThread;

public class WaterExhauster implements Runnable {
	
	Tank tank = null;
	
	WaterExhauster(Tank tank) {
		this.tank = tank;
	}
	
	@Override
	public void run() {
		while (true) {
			if (this.tank.reachedMin()) {
				this.tank.didReachMin.fire();
			} else {
				this.tank.pourOut();
			}
			RealtimeThread.waitForNextPeriod();
		}
	}

}