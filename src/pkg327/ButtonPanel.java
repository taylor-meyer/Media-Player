
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author taylo
 */
public class ButtonPanel extends VBox{
    
    public ButtonPanel() {
        
        this.setStyle("-fx-background-color:#000000;"
            + "-fx-border-color: #1CFF00;"
            + "-fx-border-width: 1px;");
        
        
        Button norm = this.createButton("Norm");
        Button alpha = this.createButton("Alpha");
        Button rand = this.createButton("Rand");
        Button create_playlist = this.createButton("New Playlist");
        Button delete_playlist = this.createButton("Del Playlist");
        
        
        TextField song_search_field = new TextField();
        song_search_field.setPromptText("enter song name..");
        song_search_field.setStyle("-fx-background-color:#323232;");
        Button song_search_button = this.createButton("Search by song");
        
        
        
        TextField artist_search_field = new TextField();
        artist_search_field.setPromptText("enter artist name..");
        artist_search_field.setStyle("-fx-background-color:#323232;");
        Button artist_search_button = this.createButton("Search by artist");
        
        
        Button exit = this.createButton("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        
        this.getChildren().addAll(
                norm,
                alpha,
                rand,
                song_search_field,
                song_search_button,
                artist_search_field,
                artist_search_button,
                create_playlist,
                delete_playlist,
                exit);
    }
    
    private Button createButton(String s) {
        
        Button b = new Button(s);
        this.setupColors(b);
        return b;
    }
    
    private void setupColors(Button b) {
        
        b.setStyle("-fx-background-color:#000000;"
            + "-fx-text-fill: #1CFF00;"
            + "-fx-border-color: #1CFF00;"
            + "-fx-border-width: 1px;");
        
        b.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                b.setStyle("-fx-background-color:#000000;"
                + "-fx-text-fill: #E300FF;"
                + "-fx-border-color: #E300FF;"
                + "-fx-border-width: 1px;");
              }
        });

        b.addEventHandler(MouseEvent.MOUSE_EXITED,
            new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                b.setStyle("-fx-background-color:#000000;"
                + "-fx-text-fill: #1CFF00;"
                + "-fx-border-color: #1CFF00;"
                + "-fx-border-width: 1px;");
            }
        });
    }
    
}
