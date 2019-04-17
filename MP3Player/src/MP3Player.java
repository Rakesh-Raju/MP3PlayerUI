
/*
	A class that contains the actual functionality of the music player. Allows the user to pick a song, and will play it until the user prompts it to stop.
 	@author Rakesh Raju
 	12/7/16
 */
import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MP3Player {
	Object[] list;
	ArrayList<Song> songs;

	public MP3Player(ArrayList<Song> list) {
		// converts the list to an array so it can be used with joptionpane
		this.list = new ListToArray(list).getArray();
		songs = list;
	}

	public void player() throws FileNotFoundException, JavaLayerException {
		Component frame = null;
		Icon icon = null;

		// shows a drop-down window which allows the user to pick a song from
		// the provided directory, and stores the output in a String
		String musicChoice = (String) JOptionPane.showInputDialog(frame, "Please select a song:", "MP3 Player",
				JOptionPane.PLAIN_MESSAGE, icon, list, null);

		if (musicChoice != null) {
			int index = new Indexer(songs, musicChoice).getIndex();
			// creates a new Player object with the chosen song, and creates a
			// thread for it to run.
			Player player = new Player(new FileInputStream(songs.get(index).getFile()));
			Thread t = new Thread() {
				public void run() {
					try {
						player.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			t.start();

			// Displays a window showing you what song is playing, and gives you
			// the option to stop at any time
			Object[] options = { "Stop Song" };
			int n = JOptionPane.showOptionDialog(frame, "Now Playing: " + musicChoice, "MP3 Player",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
			if (n == 0) {
				player.close();
			}
		}

	}

}
