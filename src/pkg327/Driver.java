
package pkg327;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author taylo
 */
public class Driver extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //LoginServices ls = new LoginServices();
        //PlaylistServices ps = new PlaylistServices();
        
        /*
        Account myAccount = null;
        for (Account A : ls.getAccounts()) {
            if (A.getUsername().equals("TaylorM"))
                myAccount = A;
        }

        System.out.println("Name:" + myAccount.getUsername());
        System.out.println("Name:" + myAccount.getPassword());
        */        
        
        // Breakpoint
        int i = 0;
        
        
        //String acctid = "1234"; // temp to test, would get from login services
        //String username = "TaylorM"; // temp to test, would get from login services
        //PlayerWindow pw = new PlayerWindow(username, acctid);
        
        
        /*
        String playName = "a";
        String id = "1234";
        
        Dispatcher d = new Dispatcher();
        Proxy p = new Proxy(d);

        String[] params = {playName, id};
        JsonObject result = p.synchExecution("getPlaylist", params);
        // create playlist object with result, which is a json string
        */
        
        /* THESE ALL WORK */
        //JsonObject result = p.synchExecution("deletePlaylist", params);
        //JsonObject result = p.synchExecution("createPlaylist", params);
        //JsonObject result = p.synchExecution("addSongToPlaylist", params);
        //JsonObject result = p.synchExecution("removeSongFromPlaylist", params);
        
        /*
        String s = result.get("ret").getAsString();
        System.out.println(s);
        */
        
        GridPane gp = new GridPane();
        
        Button hw = new Button();
        hw.setText("hello world");
        
        hw.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("helloword");
                }
            });
        
        PlayButton B = new PlayButton();
        PlayButton B2 = new PlayButton();
        
        gp.add(B, 1, 1);
        gp.add(hw,1,2);
        gp.add(B2, 1, 3);
        
        
        Stage stage = new Stage();
        stage.setTitle("Button Test");
        stage.setScene(new Scene(gp,500,500));
        stage.show();
        
        //System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}