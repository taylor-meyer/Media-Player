
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;

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