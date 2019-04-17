
/*
	A class that converts an ArrayList to an Object Array
 	@author Rakesh Raju
 	12/7/16
 */
import java.util.ArrayList;

public class ListToArray {
	Object[] array;

	public ListToArray(ArrayList<Song> list) {
		array = convert(list);
	}

	// converts the list to an object array
	public Object[] convert(ArrayList<Song> list) {
		Object[] temp = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			temp[i] = list.get(i).getTitle();
		}

		return temp;
	}

	public Object[] getArray() {
		return array;
	}

}
