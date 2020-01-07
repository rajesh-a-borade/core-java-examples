package factory.industry;

public class CarFactory {

	public static Car getCarInstance() {
		return new Audi();
	}
}
