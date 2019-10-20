
package pkg327;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author taylo
 */
public class PlayerWindow extends BorderPane{
    
    private TitleBar top;
    private ButtonPanel left;
    private Page center;
    
    public PlayerWindow(String username, String account_id) {
        
        this.setStyle("-fx-background-color:#000000;"
            + "-fx-border-color: #1CFF00;"
            + "-fx-border-width: 1px;");
        
        this.top = new TitleBar(username);
        this.left = new ButtonPanel(account_id, this);
        
        this.center = new Page();
        //this.center.makeAlphaPages(0);
        
        this.setTop(top);
        this.setLeft(left);
        this.setCenter(center);
        
        Stage stage = new Stage();
        stage.setTitle("Media Player");
        stage.setScene(new Scene(this, 1240, 800));
        stage.show();
    }
    
    public Page getPage() {
        return this.center;
    }
}
