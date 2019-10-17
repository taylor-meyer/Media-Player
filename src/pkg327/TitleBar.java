
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
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author taylo
 */
public class TitleBar extends HBox{
    
    public TitleBar(String s) {
        
        
        Text title = new Text("Not-ify");
        title.setFont(Font.font ("Verdana", 20));
        title.setFill(Color.RED);
        
        Text username = new Text("Current User: " + s);
        username.setFont(Font.font ("Verdana", 20));
        username.setFill(Color.RED);
        
        this.setStyle("-fx-background-color:#000000;"
            + "-fx-text-fill: #1CFF00;"
            + "-fx-border-color: #1CFF00;"
            + "-fx-border-width: 1px;");
        
        this.getChildren().addAll(title, username);
        this.setMargin(username, new Insets(0, 0, 0, 99));
    }
}
