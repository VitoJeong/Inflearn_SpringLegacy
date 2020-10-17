package ch06Pjt001.toy;

import ch06Pjt001.battery.Battery;
import ch06Pjt001.battery.NormalBattery;

public class ElectronicCarToy {
	
	private Battery battery;
	
	public ElectronicCarToy() {
		battery = new NormalBattery();
	}
	
}