package AsyncTransferControl;

import javax.realtime.AsyncEventHandler;
import javax.realtime.AsynchronouslyInterruptedException;

enum Mode {
	MODE_A, MODE_B
}

public class ModeInflatter extends AsynchronouslyInterruptedException{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Mode current;
	public ModeInflatter(Mode initial) {
		super();
		current = initial;
	}
	public synchronized Mode currentMode() {
		return current;
	}
	public synchronized void setMode(Mode nextMode) {
		current = nextMode;
	}
	public synchronized void toggleMode() {
		if (current== Mode.MODE_A) {
			current=Mode.MODE_B;
		} else {
			current = Mode.MODE_A;	
		}
	}
}

class ModeSwitcher extends AsyncEventHandler {
	ModeInflatter inflatter;
	public ModeSwitcher(ModeInflatter inflatter) {
		this.inflatter=inflatter;
	}
	public void handleAsyncEvent() {
		System.out.println("fired\n\n");
		inflatter.toggleMode();
		inflatter.fire();
	}
}
