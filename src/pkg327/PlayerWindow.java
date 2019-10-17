
package pkg327;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author taylo
 */
public class PlayerWindow extends BorderPane{
    
    public PlayerWindow(String username, String account_id) {
        
        this.setStyle("-fx-background-color:#000000;"
            + "-fx-border-color: #1CFF00;"
            + "-fx-border-width: 1px;");
        
        TitleBar top = new TitleBar(username);
        ButtonPanel left = new ButtonPanel(account_id);
        Page center = new Page();
        
        this.setTop(top);
        this.setLeft(left);
        this.setCenter(center);
        
        Stage stage = new Stage();
        stage.setTitle("Media Player");
        stage.setScene(new Scene(this, 1240, 800));
        stage.show();
    }
}
