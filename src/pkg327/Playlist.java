/*
Taylor Meyer
327 Media Player
Fall 2019
Dr. Oscar Morales Ponce
*/

package pkg327;

import java.util.ArrayList;

/**
 * Stores list of song IDs.
 * @author Taylor Meyer
 */
public class Playlist {
    
    // Playlist name.
    private String name;
    // ArrayList of ID numbers;
    private ArrayList<Integer> idList;
    
    /**
     * Constructor.
     * Sets references to already created objects.
     * Used for GSON.
     * @param name
     * @param idList 
     */
    public Playlist(String name, ArrayList<Integer> idList){
        
         this.idList = idList;
         this.name = name;
    }
    
    /**
     * Constructor.
     * Sets the playlist name and creates a new ArrayList of
     * ID numbers;
     * @param name the name to be set
     */
    public Playlist(String name){
         this.name = name;
         idList = new ArrayList();
    }
    
    /**
     * Returns the ArrayList of ID numbers.
     * @return 
     */
    public ArrayList<Integer> getList(){
        return this.idList;
    }
    
    /**
     * Returns the name of the playlist.
     * @return this.name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Sets the name of the playlist.
     * May never need this.
     * @param name the name to be set to.
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Push a song's ID to the ArrayList.
     * @param i the ID number.
     */
    public void addSong(int i){
        this.idList.add(i);
    }
    
    /**
     * Removes a song from the playlist by removing
     * the ID number from the ArrayList.
     * @param i the ID number.
     */
    public void removeSong(int i){
        this.idList.remove(Integer.valueOf(i));
    }
}