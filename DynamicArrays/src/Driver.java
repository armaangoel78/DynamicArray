import java.util.Random;

public class Driver {
	private static Random r = new Random(); 
	private static final int size = 10000000;
	private static final int numRemovals = 1000;
	
	public static void main(String[] args) {
		long lowest = 1000000000;
		long total = 0;
		long loops = 0;
		while (true) {
			loops++;
			long start = System.currentTimeMillis();
		
			DynamicArray arr = new DynamicArray();
					
			Long add = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				arr.add(i);
			}
			add = System.currentTimeMillis() - add;
			
			long remove = System.currentTimeMillis();
			int removals[] = new int[numRemovals];
			for (int i = 0; i < numRemovals; i++) {
				removals[i] = r.nextInt(size);
			}
			//arr.og_remove();
			arr.remove(removals);
			remove = System.currentTimeMillis() - remove;
			
			//System.out.println(arr.compare());
			long time = System.currentTimeMillis() - start;
			total += time;
			if (time < lowest) {
				lowest = time;
			}
			long average = total/loops;
			System.out.println("Time: " + time + " Add: " + add + " Remove: " + remove + " Lowest: " + lowest + " Avg: " + average);
		}
	}
}
