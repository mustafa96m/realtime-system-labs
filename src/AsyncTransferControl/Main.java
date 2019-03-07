package AsyncTransferControl;

import java.util.Scanner;

import javax.realtime.PeriodicParameters;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ModeThread modeThread = new ModeThread();
		RelativeTime rt = new RelativeTime(300,0);
		ReleaseParameters rp = new PeriodicParameters(rt);
		modeThread.setReleaseParameters(rp);
		modeThread.start();
		
		while (true) {
			scanner.nextLine();
			modeThread.event.fire();
		}
		
	}
	
}
