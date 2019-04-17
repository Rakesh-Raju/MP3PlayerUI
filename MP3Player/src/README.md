MP3Player
--------

This program is a simple music player coded in Java. It uses the external java libraries JAudioTagger, a library that can extract different pieces of information from a song, and JLayer, a library that can decode/play/convert songs.


Classes:

MP3Driver.java - The driver class that integrates all other necessary classes/components to run the MP3Player. It takes in a directory for music, and provides various commands.

Song.java - A class that makes up a Song Object, which takes a song title, an artist, and the actual file for the song.

Indexer.java - A class that determines the index of a song name in the ArrayList passed in as a parameter.

ByArtistComparator.java - A class that compares the artists of two different songs.

ByTitleComparator.java - A class that compares the titles of two different songs.

ListToArray.java - A class that converts an ArrayList to an Object Array.

MP3Retriever.java - A class that gets all the MP3 files from the provided directory.


Usage:

1.Find a directory of music, and copy the path. 

WARNING! Only songs with valid tags (such as music purchased from the iTunes store) will work. Music downloaded from YouTube will not work.

2.Run MP3Driver.java, making sure that the external libraries mentioned before are in the same directory.

3.When the prompt comes up, simply enter the directory path for the music, and used the buttons on the window to navigate the system.

OR

For your convenience, simply run MP3Player.jar!

Author:
Rakesh Raju
12/7/16
