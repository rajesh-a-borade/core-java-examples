package template;

public abstract class Home {
	
	final public void build() {
		buildFloor();
		buildWalls();
		buildCeiling();
	}
	
	public abstract void buildWalls();
	public abstract void buildFloor();
	public abstract void buildCeiling();

}
