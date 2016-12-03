import java.util.Random;

public class Driver {
	private static Random r = new Random(); 
	
	public static void main(String[] args) {
		long lowest = 1000000000;
		while (true) {
			long start = System.currentTimeMillis();
			DynamicArray arr = new DynamicArray();
			
			int size = 10000000;
			int removals = 1000;
			
			for (int i = 0; i < size; i++) {
				arr.add(i);
			}
			
			for (int i = 0; i < removals; i++) {
				int removal = r.nextInt(size);
				arr.addToRemoveQueue(removal);
			}
	
			//arr.og_remove();
			arr.remove();
			
			
			//System.out.println(arr.compare());
			long time = System.currentTimeMillis() - start;
			if (time < lowest) {
				lowest = time;
				System.out.println(time);
			}
		}
	}
}
