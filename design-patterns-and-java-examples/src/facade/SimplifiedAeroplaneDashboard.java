package facade;

interface AeroplaneDashboard {
	
	void doPowerOnSelfTest();
	void turnFuelOn();
	void turnFlapsUp();
	void turnFlapsDown();
	void turnEleronsRight();
	void turnEleronsLeft();
	void raiseAcceleratorPad();
	void checkPermissionFromFlighCtrller();
	void engageEngine();
	// ...
}

public interface SimplifiedAeroplaneDashboard extends AeroplaneDashboard {
	
	void startPlane();
	void takeOff();
	void land();
	void turnOffPlane();
}


