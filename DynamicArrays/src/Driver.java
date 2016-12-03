import java.util.Random;

public class Driver {
	private static Random r = new Random(); 
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		DynamicArray arr = new DynamicArray();
		
		for (int i = 0; i < 10000000; i++) {
			arr.add(i);
		}
		
		for (int i = 0; i < 1000; i++) {
			arr.addToRemoveQueue(r.nextInt(arr.getArray().length));
		}
		arr.remove();
		
		System.out.println(System.currentTimeMillis() - start);
	}
}
