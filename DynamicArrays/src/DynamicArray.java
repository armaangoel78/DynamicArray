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
			int[] temp = new int[array.length * 10];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
			array[max_index] = value;
		} else {
			array[max_index] = value;
		}
	}
	
	public void add (int[] array) {
		if (max_index == -1) {
			this.array = array;
		}
		
		else {
			int temp[] = new int[max_index + 1 + array.length];
			for (int i = 0; i < temp.length; i++) {
				int value = (i <= max_index ? this.array[i] : array[i-max_index-1]);
				temp[i] = value;
			}
			
			this.array = temp;
			max_index = array.length-1;
		}
	}
	
	public void removeQueue(int[] removals) {
		this.removals = removals;
	}
	
	public void remove(int[] removals) {
		this.removals = removals;
		remove();
	}
	
	public void addToRemoveQueue(int index) {
		max_removal_index++;
		if (max_removal_index + 1 < removals.length) {
			removals[max_removal_index] = index;
		} else {
			int[] temp = new int[removals.length * 10];
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
				
				if (removals[index] != -1) removals[index] = removals[index-1] - 1; //compensation for sorting
				else removals[index] = removals[index-1];
				
				removals[index-1] = temp;
				index--;
			}
		}
		
		int movement = 0;
		int removeIndex = 0;
		boolean evaluate = true;
		while (removals[removeIndex] == -1) {
			removeIndex++;
		}
		for (int i = removals[removeIndex]; i < max_index + movement; i++) {
			int index1 = i + 1;
			if (evaluate) {
				if (i - movement == removals[removeIndex]){
					movement++;
					removeIndex++;
					
					if (removeIndex >= removals.length) {
						evaluate = false;
					}
				}
			}
			int index2 = index1;
			if (index2 + 1 > array.length) index2 = array.length-1;
			array[index1-movement] = array[index2];
		}
	}
	
	public int[] getRemovals () {
		return removals;
	}
	
	public void og_remove() {
		og_array = new int[array.length];
		
		//set each value of og_array to array w/out making og_array point to array
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
