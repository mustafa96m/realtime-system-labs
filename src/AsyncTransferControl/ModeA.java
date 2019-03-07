package AsyncTransferControl;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

public class ModeA implements Interruptible {

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		// TODO Auto-generated method stub
		System.out.println("***Change Mode to B***");
	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		// TODO Auto-generated method stub
		while (true) {
			for (int i=1;i<10;i++) {
			System.out.println("operating in mode A: " + i);
				try {
					Thread.sleep(90);
				}catch (Exception e) {
				
				}
			}
			RealtimeThread.waitForNextPeriod();
		}
	}

}
