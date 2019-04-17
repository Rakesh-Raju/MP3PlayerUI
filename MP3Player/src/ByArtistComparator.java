
/*
	Artist Comparator
 	@author Rakesh Raju
 	12/7/16
 */
import java.util.Comparator;

public class ByArtistComparator implements Comparator<Song> {

	@Override
	public int compare(Song o1, Song o2) {
		return o1.getArtist().compareTo(o2.getArtist());
	}

}
