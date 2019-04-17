
/*
	A class that contains a main method that runs the music player. It takes in a directory for music, and shows various options on what the user can do
 	@author Rakesh Raju
 	12/7/16
 */
import java.awt.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import javazoom.jl.decoder.JavaLayerException;

public class MP3Driver {

	public static void main(String[] args) throws JavaLayerException, CannotReadException, IOException, TagException,
			ReadOnlyFileException, InvalidAudioFrameException {
		try {

			// members for a joptionpane
			Component frame = null;
			Icon icon = null;
			String directoryGet = null;
			ArrayList<File> f = null;
			// if the user provides an input directory, it will store it, and
			// retrieve all mp3 files from there.
			try {
				directoryGet = (String) JOptionPane.showInputDialog(frame, "Please enter a directory for music:",
						"MP3 Player", JOptionPane.PLAIN_MESSAGE, icon, null, null);
				// creates a new MP3Retriever with the provided directory, which
				// will return all MP3 files.
				f = new MP3Retriever(directoryGet).fileExporter();
			} catch (NullPointerException error) {
				System.exit(0);
			}
			// For every file in the ArrayList, it will create a song object be
			
			// getting the Artist tag, the Title Tag, and sending in the file.
			ArrayList<Song> music = new ArrayList<Song>();
			for (int i = 0; i < f.size(); i++) {
				AudioFile a = AudioFileIO.read(f.get(i));
				Tag tag = a.getTag();
				music.add(new Song(tag.getFirst(FieldKey.TITLE), tag.getFirst(FieldKey.ARTIST), f.get(i)));
			}
			boolean loop = true;
			// loops the interface
			while (loop) {
				if (directoryGet != null && f != null) {
					Object[] choices = { "Sorted by Artist", "Sorted by Song", "Exit Program" };
					int k = JOptionPane.showOptionDialog(frame, "How would you like to view your music?", "MP3 Player",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, null);

					// conditional block for all possible outputs from the main
					// window
					if (k == -1) {
						loop = false;
					}

					// Artist sort
					if (k == 0) {
						Collections.sort(music, new ByTitleComparator());
						Collections.sort(music, new ByArtistComparator());
						MP3Player play = new MP3Player(music);
						play.player();

					}
					// Song sort
					if (k == 1) {
						Collections.sort(music, new ByTitleComparator());
						MP3Player play = new MP3Player(music);
						play.player();
					}

					// Cancel
					if (k == 2) {
						System.exit(0);
					}

				}

			}
		}
		// If invalid mp3 files exist, then returns an error with the directory.
		catch (InvalidAudioFrameException error) {
			Component frame = null;
			Object[] options = { "OK" };
			int n = JOptionPane.showOptionDialog(frame,
					"This directory contains invalid mp3 files!\nPlease clean up the directory then try again.",
					"MP3 Player", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		}
	}

}