
package pkg327;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author taylo
 */
public class Driver extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        LoginServices ls = new LoginServices();
        PlaylistServices ps = new PlaylistServices();
        
        Account myAccount = null;
        for (Account A : ls.getAccounts()) {
            if (A.getUsername().equals("TaylorM"))
                myAccount = A;
        }

        System.out.println("Name:" + myAccount.getUsername());
        System.out.println("Name:" + myAccount.getPassword());
        
        // Breakpoint
        int i = 0;
        
        PlayerWindow pw = new PlayerWindow(myAccount.getUsername());

        //System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

// Proxy method
/*
        Dispatcher d = new Dispatcher();
        Proxy p = new Proxy(d);

        String[] params = {Integer.toString(id), playlistname, myAccount.getID()};
        JsonObject result = p.synchExecution("removeSongFromPlaylist", params);
        
        String s = result.get("ret").getAsString();
        System.out.println(s);
*/