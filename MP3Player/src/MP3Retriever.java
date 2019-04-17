
/*
	A class that gets all the MP3 files from the provided directory.
 	@author Rakesh Raju
 	12/7/16
 */
import java.util.ArrayList;
import java.awt.Component;
import java.io.File;
import javax.swing.JOptionPane;

public class MP3Retriever {

	ArrayList<File> f;
	String directory;

	public MP3Retriever(String directory) {
		f = fileGetter(directory);
	}

	public ArrayList<File> fileGetter(String directory) {
		f = new ArrayList<File>();
		fileGetter(new File(directory), f);
		return f;
	}

	// recursively gets all mp3 files in the provided directory (backbone
	// provided by @srollins)
	public void fileGetter(File input, ArrayList<File> f2) {
		try {
			if (input.isFile()) {
				if (input.getName().contains(".mp3")) {
					f.add(input);
				}
			}

			else if (input.isDirectory()) {
				File[] children = input.listFiles();
				for (File file : children) {
					fileGetter(file, f2);

				}
			}

			else {
				throw null;
			}
		}

		// if function catches an nullpointerexception when getting files,
		// displays this message
		catch (NullPointerException error) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame, "There was an error with this directory!");
			System.exit(0);
		}

	}

	public ArrayList<File> fileExporter() {
		return f;
	}

}
