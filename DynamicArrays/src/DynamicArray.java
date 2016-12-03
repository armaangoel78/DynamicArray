
public class DynamicArray {

	private int[] og_array;
	private int[] array = new int[2];
	private int max_index = -1;
	
	private int max_removal_index = -1;
	private int[] removals = new int[2];
	
	
	public int[] getArray() {
		return array;
	}
	
	public void add(int value) {
		max_index++;
		if (max_index + 1 > array.length) {
			int[] temp = new int[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
			array[max_index] = value;
		} else {
			array[max_index] = value;
		}
	}
	
	public void addToRemoveQueue(int index) {
		
		max_removal_index++;
		if (max_removal_index + 1 < removals.length) {
			removals[max_removal_index] = index;
		} else {
			int[] temp = new int[removals.length * 2];
			for (int i = 0; i < temp.length; i++) {
				if (i + 1 < removals.length) temp[i] = removals[i];
				else if (i + 1 == removals.length) temp[i] = index;
				else temp[i] = -1;
			}
			removals = temp;
		}
		
	}
	
	public void remove() {
		//insertion sort of the removals
		for (int i = 1; i < removals.length; i++) {
			int index = i;
			while ((index > 0 ? removals[index] < removals[index-1] : false)) {
				int temp = removals[index];
				
				if (removals[index] != -1) removals[index] = removals[index-1] - 1;
				else removals[index] = removals[index-1];
				
				removals[index-1] = temp;
				index--;
			}
		}
		
		int movement = 0;
		int removeIndex = 0;
		boolean evaluate = true;
		for (int i = 0; i < array.length-1; i++) {
			int index = i + 1;
			if (evaluate) {
				while (removals[removeIndex] == -1) {
					removeIndex++;
				}
				
				if (i - movement == removals[removeIndex]){
					movement++;
					removeIndex++;

					if (removeIndex >= removals.length) {
						evaluate = false;
					}
				}
			}
			
			array[index-movement] = array[index];
		}
	}
	
	public int[] getRemovals () {
		return removals;
	}
	
	public void og_remove() {
		og_array = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			og_array[i] = array[i];
		}
	
		for (int i = 0; i < removals.length; i++) {
			if (removals[i] != -1) {
				for (int x = removals[i]; x < og_array.length-1; x++) {
					og_array[x] = og_array[x+1];
				}
			}
		}
	}
	
	public boolean compare() {
		boolean same = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != og_array[i]) {
				same = false;
			}
		}
		return same;
	}
}
