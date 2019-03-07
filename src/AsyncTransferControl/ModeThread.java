package AsyncTransferControl;

import javax.realtime.AsyncEvent;
import javax.realtime.RealtimeThread;

public class ModeThread extends RealtimeThread{
	ModeInflatter inflatter;
	ModeSwitcher switcher;
	AsyncEvent event;
	
	ModeThread(){
		inflatter = new ModeInflatter(Mode.MODE_A);
		switcher = new ModeSwitcher(inflatter);
		event = new AsyncEvent();
		event.addHandler(switcher);
	}
	
	@Override
	public void run() {
		ModeA modeA = new ModeA();
		ModeB modeB = new ModeB();
		boolean ok = true;
		while (ok) {
			if (inflatter.currentMode() == Mode.MODE_A) {
				inflatter.doInterruptible(modeB);
			}else {
				inflatter.doInterruptible(modeA);
			}
			waitForNextPeriod();
		}
	}

	
	
}
