
/*
 	A class that determines the index of a song name in the provided ArrayList
 	@author Rakesh Raju
 	12/7/16
 */
import java.util.ArrayList;

public class Indexer {
	int index;

	public Indexer(ArrayList<Song> o, String s) {
		// Checks the entire ArrayList to determine whether it equals the input
		// String
		for (int i = 0; i < o.size(); i++) {
			// if true, sets index to be where it was true
			if (o.get(i).getTitle().equals(s)) {
				index = i;
			}
		}
	}

	public int getIndex() {
		return index;
	}
}
