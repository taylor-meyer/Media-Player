
package pkg327;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author taylo
 */
public class ButtonPanel extends VBox{
    
    public ButtonPanel() {
        
        this.setStyle("-fx-background-color:#000000;"
            + "-fx-border-color: #1CFF00;"
            + "-fx-border-width: 1px;");
        
        
        Button norm = this.setupColors(new Button("Norm"));
        Button alpha = this.setupColors(new Button("Alpha"));
        Button rand = this.setupColors(new Button("Rand"));
        Button create_playlist = this.setupColors(new Button("New Playlist"));
        Button delete_playlist = this.setupColors(new Button("Del Playlist"));
        
        
        TextField song_search_field = new TextField();
        song_search_field.setPromptText("enter song name..");
        song_search_field.setStyle("-fx-background-color:#323232;");
        Button song_search_button = this.setupColors(new Button("Search Song"));
        
        
        
        TextField artist_search_field = new TextField();
        artist_search_field.setPromptText("enter artist name..");
        artist_search_field.setStyle("-fx-background-color:#323232;");
        Button artist_search_button = this.setupColors(new Button("Search Artist"));
        
        
        Button exit = this.setupColors(new Button("Exit"));
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
    
    private Button setupColors(Button b) {
        
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
        return b;
    }
    
}
