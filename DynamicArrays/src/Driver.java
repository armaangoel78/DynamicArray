import java.util.Random;


public class Driver {
	private static Random r = new Random(); 
	private static final int size = 10000000;
	private static final int numRemovals = 1000;

	public static void main(String[] args) {
		long lowest = 1000000000;
	
		while (true) {
			int[] randoms = new int[numRemovals];
			for (int i = 0; i < randoms.length; i++) {
				randoms[i] = r.nextInt(size);
			}
			
			
			long start = System.currentTimeMillis();
		
			DynamicArray arr = new DynamicArray();
			
			int[] array = new int[size];
			for (int i = 0; i < size; i++) {
				array[i] = i;
			}
			
			arr.add(array);
			
			arr.remove(randoms);
			
			long time = System.currentTimeMillis() - start;
			if (time < lowest) {
				lowest = time;
				System.out.println(lowest);
			}
		}
	}
}