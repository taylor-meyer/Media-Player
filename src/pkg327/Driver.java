
package pkg327;

import com.google.gson.JsonObject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
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
        
        GridPane gp = new GridPane();
        PageBar pb = new PageBar();
        gp.add(pb, 0, 0);
        
        Scene scene = new Scene(gp,300,300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        
        
        
        GridPane gp2 = new GridPane();
        ButtonPanel bp = new ButtonPanel();
        gp2.add(bp, 0, 0);
        
        Scene scene2 = new Scene(gp2,300,300);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.show();

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