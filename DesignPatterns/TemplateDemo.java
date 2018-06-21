package designpatterns;

/* emplate method should consists of certain steps whose order is fixed and for some of the methods, implementation differs from base class to subclass. 
 * Template method should be final. */

abstract class House{
	
	public final void  buildHouse()
	{
		buildFoundation();
		buildPillars();
		buildwalls();
	}

	private void buildFoundation() {
		System.out.println("Foundation");
	}
	
	private void buildPillars(){
		System.out.println("Pillars");
	}
	
	public abstract void buildwalls();
}

class GlassHouse extends House{
	
	@Override
	public void buildwalls() {
		System.out.println("Glass Walls");
	}
}

public class TemplateDemo {
	
	public static void main(String[] args){
		House glasshouse = new GlassHouse();
		glasshouse.buildHouse();
	}

}
