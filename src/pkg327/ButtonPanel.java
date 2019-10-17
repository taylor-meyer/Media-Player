
package pkg327;

import com.google.gson.JsonObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author taylo
 */
public class ButtonPanel extends VBox{
    
    String playlist_name;
    
    public ButtonPanel(String account_id) {
        
        this.setStyle("-fx-background-color:#000000;"
            + "-fx-border-color: #1CFF00;"
            + "-fx-border-width: 1px;");
        
        
        Button norm = this.setupColors(new Button("Norm"));
        Button alpha = this.setupColors(new Button("Alpha"));
        Button rand = this.setupColors(new Button("Rand"));
        Button stop = this.setupColors(new Button("Stop"));
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
        
        
        
        
        
        
        create_playlist.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                playlist_name = null;
                
                Stage window = new Stage();
                window.setTitle("New Playlist");
                
                GridPane gp = new GridPane();
                gp.setStyle("-fx-background-color:#000000;"
                    + "-fx-border-color: #1CFF00;"
                    + "-fx-border-width: 1px;");
                
                TextField field = new TextField();
                field.setPromptText("enter name..");
                
                Button button = setupColors(new Button("Create Playlist"));
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        playlist_name = field.getText();
                    }
                });
                
                gp.add(field, 1, 0);
                gp.add(button, 1, 1);
                
                window.setScene(new Scene(gp,100,100));
                window.showAndWait();
                
                Dispatcher d = new Dispatcher();
                Proxy p = new Proxy(d);
                
                String[] params = {playlist_name, account_id};
                JsonObject result = p.synchExecution("createPlaylist", params);
                
                String s = result.get("ret").getAsString();
                System.out.println(s);
            }
        });
        
        
        
        
        
        
        
        
        this.getChildren().addAll(
                norm,
                alpha,
                rand,
                stop,
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
