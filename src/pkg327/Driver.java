
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
        
        // Breakpoint
        int i = 0;
        
        GridPane gp = new GridPane();
        
        TitleBar tb = new TitleBar(myAccount.getUsername());
        
        gp.add(tb, 0, 0);
        Scene scene = new Scene(gp,300,300);
        
        Stage stage = new Stage();
        stage.setScene(scene);
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