
package pkg327;

import com.google.gson.JsonObject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author taylo
 */
public class Driver extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        LoginServices ls = new LoginServices();
        
        Account myAccount = null;
        for (Account A : ls.getAccounts()) {
            if (A.getUsername().equals("TaylorM"))
                myAccount = A;
        }

        System.out.println("Name:" + myAccount.getUsername());
        System.out.println("Name:" + myAccount.getPassword());
        
        
        String playlist_name = "playlistnumber2";
        ////////////////////////////////////////////////////////////
        
        
        String[] params = {playlist_name, myAccount};
        
        JsonObject result = p.synchExecution("createPlaylist", params);
        String s = result.get("ret").getAsString();
        boolean answer = Boolean.parseBoolean(s);
        
        if(Boolean.parseBoolean(s))
        {
            System.out.println("Return from proxy: " + answer + ": Account found");
            this.validated_user = username;
            //this.close();
        }
        else
        {
            System.out.println("Return from proxy: " + answer + ": Account not found");
            showMessage(invalid_login);
        }
        
        
        
        ////////////////////////////////////////////////////////////////////
        
        
        
        // Break
        int i = 0;
        
        System.exit(0);
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
