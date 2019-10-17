
package pkg327;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author taylo
 */
public class Page extends VBox{
    
    public Page() {
        
        this.setStyle("-fx-background-color:#000000;"
            + "-fx-border-color: #1CFF00;"
            + "-fx-border-width: 1px;");
        
        for (int i = 0; i < 15; i++) {
            Button b = new PlayButton();
            this.getChildren().add(b);
            
            if (i == 14)
                this.setMargin(b, new Insets(0, 0, 70, 0));
            else
                this.setMargin(b, new Insets(0, 0, 10, 0));
        }
        
        this.getChildren().add(new PageBar());
    }
}