
package pkg327;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nicka
 */
public class MusicServices {
    
    // Token for GSON to load in a list from JSON
    private TypeToken<List<MusicMeta>> token = new TypeToken<List<MusicMeta>>() {};
    // Unsorted list
    ArrayList<MusicMeta> meta_data_unsorted;
    // Sorted list
    ArrayList<MusicMeta> meta_data_sorted;

    /**
     * Default constructor. Loads in the meta data for all the songs
     * from the JSON file using GSON.
     */
    public MusicServices() {
        // De-serialize the data
        deserializeData();
        // Sort the one list that needs to be sorted
        Collections.sort(this.meta_data_sorted);
    }
    
    /**
     * This function deserializes the data from music.json
     * <p>
     * To deserialize, we use Gson to convert the .json file to lists of objects
     * that we are then able to use to process commands from the client.
     * <\p>
     */
    private void deserializeData() {
        
        try {
            // Reader for first list.
            Reader read = new FileReader("music.json");
            // Reader for second list.
            Reader read2 = new FileReader("music.json");
            // Use GSON
            meta_data_unsorted = new Gson().fromJson(read, token.getType());
            meta_data_sorted = new Gson().fromJson(read2, token.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Get the list of MetaData
    public List<MusicMeta> getMetaData(){
        return this.meta_data_unsorted;
    }
    
    /**
     * Uses Random to pick out a random song from the list of music
     * @return MusicMeta random song
     */
    public MusicMeta getRandomSong(){
        return this.meta_data_unsorted.get(
                new Random().nextInt(this.meta_data_unsorted.size()));
    }
    
        /**
     * User function that will return a MusicMeta object by search 
     * (using either song or artist as search conditions)
     * @param s name of the song
     * @param isSong flag for if the user is searching for a song
     * @return MusicMeta result of the search
     */
    public MusicMeta getSong(String s, boolean isSong){
        
        if(isSong){ // Song Search
            
            for (MusicMeta M : meta_data_unsorted){
                if(M.getRelease().getName().toLowerCase().equals(s.toLowerCase()))
                    return M;
            }
        }
        else{ // Artist Search
            
            for (MusicMeta M : meta_data_unsorted){
                if(M.getArtist().name.toLowerCase().equals(s.toLowerCase()))
                    return M;
            }
        }
        return null;
    }
        /**
     * A search function for a programmer to search specific songs by id value
     * @param id
     * @return 
     */
    public MusicMeta getSong(int id){

        for (MusicMeta M : meta_data_unsorted){
            if(M.getRelease().getId() == id){
                System.out.println("Found id: " + id);
                return M;
            }
        }
        return null;
    }
    
    public String getNormalPage(int index) {
        
        ArrayList<MusicMeta> page = new ArrayList();
        
        int i = index * 15;
        int stop = i + 15;
        
        // tried to do this in a for loop but it wasnt really working out
        while(i != (stop-1)) {
            page.add(this.meta_data_unsorted.get(i));
            i++;
        }
        
        
        Gson gson = new Gson();
        return gson.toJson(page);
    }
    
    public String getAlphaPage(int index) {
        
        ArrayList<MusicMeta> page = new ArrayList();
        
        int i = index * 15;
        int stop = i + 15;
        
        // tried to do this in a for loop but it wasnt really working out
        while(i != (stop-1)) {
            page.add(this.meta_data_sorted.get(i));
            i++;
        }
        
        
        Gson gson = new Gson();
        return gson.toJson(page);
    }
}