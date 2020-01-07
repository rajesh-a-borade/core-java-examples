package factory;

import factory.industry.Car;
import factory.industry.CarFactory;

public class Test {

	public static void main(String[] args) {
			
		Car car = CarFactory.getCarInstance();
	}
}