/*
	A class that makes up a Song Object, which takes a song title, an artist, and the actual file for the song.
 	@author Rakesh Raju
 	12/7/16
 */
import java.io.File;

public class Song {
	String title;
	File f;
	String artist;

	//creates a song based off of title, artist, and the actual file
	public Song(String title, String artist, File f) {
		this.f = f;
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public File getFile() {
		return f;
	}

	public String getArtist() {
		return artist;
	}

	public String toString() {
		return "Title: " + title + "Artist: " + artist;
	}

}
