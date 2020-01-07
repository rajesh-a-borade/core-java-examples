
package singleton;

public class NormalSingleton {

	private NormalSingleton() {
	}
	
	private static NormalSingleton normalSingleton = null;
	
	public static NormalSingleton getInstance() {
		
		if(normalSingleton == null)  {		
			synchronized (Singleton.class) {
				if(normalSingleton == null) {
					normalSingleton = new NormalSingleton();
				}
			}
		}
		return normalSingleton;
	}
	
}
