import java.util.Random;

public class Driver {
	private static Random r = new Random(); 
	
	public static void main(String[] args) {
		long lowest = 1000000000;
		while (true) {
			long start = System.currentTimeMillis();
			DynamicArray arr = new DynamicArray();
			
			int size = 10000000;
			int numRemovals = 1000;
			
			for (int i = 0; i < size; i++) {
				arr.add(i);
			}
			
			int removals[] = new int[numRemovals];
			for (int i = 0; i < numRemovals; i++) {
				removals[i] = r.nextInt(size);
			}
	
			//arr.og_remove();
			arr.remove(removals);
			
			
			//System.out.println(arr.compare());
			long time = System.currentTimeMillis() - start;
			if (time < lowest) {
				lowest = time;
				System.out.println(time);
			}
		}
	}
}
