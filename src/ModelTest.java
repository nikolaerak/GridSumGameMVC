import junit.framework.TestCase;

public class ModelTest extends TestCase{

	private MyModel model;
	
	protected void setUp(){
		model = new MyModel();
		for(int i = 0; i < model.SIZE; i++){
			for(int j = 0; j < model.SIZE; j++){
				model.setValue(i, j, 1);
			}
		}
	}
	
	public void testRowSum(){
		assertEquals("Value should be 3", 3, model.getRowSum(0));
		assertEquals("Value should be 3", 3, model.getRowSum(1));
		assertEquals("Value should be 3", 3, model.getRowSum(2));
	}
	
	public void testColSum(){
		assertEquals("Value should be 3", 3, model.getColSum(0));
		assertEquals("Value should be 3", 3, model.getColSum(1));
		assertEquals("Value should be 3", 3, model.getColSum(2));
	}
	
	public void testReset(){
		model.reset();
		assertEquals("Value should be 0", 0, model.getColSum(0));
		assertEquals("Value should be 0", 0, model.getColSum(1));
		assertEquals("Value should be 0", 0, model.getColSum(2));
		assertEquals("Value should be 0", 0, model.getRowSum(0));
		assertEquals("Value should be 0", 0, model.getRowSum(1));
		assertEquals("Value should be 0", 0, model.getRowSum(2));
	}
	
	public void testCheckStatus(){
		assertTrue(model.checkStatus());
		model.setValue(1, 1, 30);
		assertFalse(model.checkStatus());
	}
	
}
