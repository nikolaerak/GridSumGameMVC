import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;

public class AllTestCases extends TestCase{
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTestCases.class);
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for MyModel class");
		suite.addTest(new TestSuite(ModelTest.class));
		return suite;
	}
}
