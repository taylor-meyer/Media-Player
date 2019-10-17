
package pkg327;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author taylo
 */
public class Driver extends Application {
    
    Proxy p;
    Dispatcher d;
    
    @Override
    public void start(Stage primaryStage) {
        
        d = new Dispatcher();
        p = new Proxy(d);
        
        LoginServices ls = new LoginServices();
        PlaylistServices ps = new PlaylistServices();
        
        Account myAccount = null;
        for (Account A : ls.getAccounts()) {
            if (A.getUsername().equals("TaylorM"))
                myAccount = A;
        }

        //System.out.println("Name:" + myAccount.getUsername());
        //System.out.println("Name:" + myAccount.getPassword());
        
        String s = "test";
        
        // Breakpoint
        int i = 0;
        
        //ps.createPlaylist(s, myAccount.getID());
        //ps.deletePlaylist(s, myAccount.getID());
        //ps.addSongToPlaylist(5565, "a", myAccount.getID());
        //ps.removeSongFromPlaylist(555, "a", myAccount.getID());
        
        
        //String[] params = {s, myAccount.getID()};
        //JsonObject result = p.synchExecution("createPlaylist", params);
        //String s2 = result.get("ret").getAsString();
        //System.out.println(s2);
        
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}