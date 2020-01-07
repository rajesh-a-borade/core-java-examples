package facade;

public class DashboardFactory {

	public static SimplifiedAeroplaneDashboard getInstance() {
		return new MySimplifiedAeroplaneDashboardImpl();
	}
}
