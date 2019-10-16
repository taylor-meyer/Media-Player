
package pkg327;

//import java.util.ArrayList;

/**
 * Stores references to current logged in user and the list of
 * that user's playlists.
 * @author Taylor Meyer
 */
public class PlaylistServices {
    
    // Current account
    //private Account current_account;
    // ArrayList of Playlists
    //ArrayList<Playlist> playlists;
    
    
    /**
     * Default constructor currently does nothing
     * @param A current account
     */
    public PlaylistServices() {
        // Do nothing
    }
    
    /**
     * Creates an empty playlist with its name passed as a parameter
     * @param s name of playlist to be created
     */
    public void createPlaylist(String playlist_name, Account A) {
        A.getPlaylists().add(new Playlist(playlist_name));
    }
    
    /**
     * Delete a playlist based on the playlist's name.
     * @param s 
     */
    public void deletePlaylist(String playlist_name, Account A) {
        for (Playlist p : A.getPlaylists()) {
            if (p.getName().toLowerCase().equals(playlist_name.toLowerCase())) {
                A.getPlaylists().remove(p);
            }
        }
    }
    
    /**
     * Using given name s, adds song id i to that playlist.
     * @param s name of the playlist. Calls that Playlist objects
     * add function.
     * @param i id of the song
     */
    public void addSongToPlaylist(int id, String playlist_name, Account A) {
        for (Playlist p : A.getPlaylists()) {
            if (p.getName().toLowerCase().equals(playlist_name.toLowerCase())) {
                p.addSong(id);
            }
        }
    }
    
    /**
     * Removes a song from a playlist based on the playlist's name
     * and the specific song's id. Calls that Playlist objects remove
     * functon.
     * @param s the name of the playlist
     * @param i the id of the song to be removed
     */
    public void removeSongFromPlaylist(int id, String playlist_name, Account A) {
        for (Playlist p : A.getPlaylists()) {
            if (p.getName().toLowerCase().equals(playlist_name.toLowerCase())) {
                p.removeSong(id);
            }
        }
    }
    
    /**
     * Returns playlist based on the index in the list of
     * playlists. Programmer might need this.
     * @param i the index
     * @return Playlist
     */
    public Playlist getPlaylist(int i, Account A) {
        return A.getPlaylists().get(i);
    }
    
    /**
     * Returns playlist based on the playlist's name.
     * UI will need this.
     * @param s the name
     * @return Playlist
     */
    public Playlist getPlaylist(String playlist_name, Account A) {
        for (Playlist p : A.getPlaylists()) {
            if (p.getName().toLowerCase().equals(playlist_name.toLowerCase())) {
                return p;
            }
        }
        return null;
    }
    
    /*
    public void setCurrentAccount(Account A) {
        this.current_account = A;
        this.playlists = A.getPlaylists();
        System.out.println(this.current_account.getUsername());
    }
    */
}