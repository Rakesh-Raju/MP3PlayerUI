
/*
	Title Comparator
 	@author Rakesh Raju
 	12/7/16
 */
import java.util.Comparator;

public class ByTitleComparator implements Comparator<Song> {

	@Override
	public int compare(Song o1, Song o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}

}
