package com.example.smake;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {
    boolean gameStart = true, turnPlayerOne = true, turnPlayerTwo = false;
    public final int tilesize = 40;
    int height= 10;
    int width = 10;
    int diceValue;
    int yLine = 430;
    Label randResult;
    Group tileGroup = new Group();

    Player PlayerOne,Playertwo;


    public Pane createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(width*tilesize,height*tilesize + 80);
        root.getChildren().addAll(tileGroup);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = new Tile(tilesize,tilesize);
                tile.setTranslateX(j*tilesize);
                tile.setTranslateY(i*tilesize);

                tileGroup.getChildren().addAll(tile);
            }
        }
        // Label add

        randResult = new Label("Start the Game");
        randResult.setTranslateX(150);
        randResult.setTranslateY(yLine-20);


        Button playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(yLine);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart == true)
                {
                    if(turnPlayerOne == true)
                    {
                        getDiceValue();
                        PlayerOne.movePlayer(diceValue);
                        PlayerOne.playerAtsnakeLadder();
                        turnPlayerOne = false;
                        turnPlayerTwo = true;
                    }
                }

            }
        });


        Button GameButton = new Button("Start Game");
        GameButton.setTranslateX(160);
        GameButton.setTranslateY(yLine);


        Button playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(300);
        playerTwoButton.setTranslateY(yLine);
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart == true)
                {
                    if(turnPlayerTwo == true)
                    {
                        getDiceValue();
                        Playertwo.movePlayer(diceValue);
                        Playertwo.playerAtsnakeLadder();
                        turnPlayerTwo = false;
                        turnPlayerOne = true;
                    }
                }
            }
        });
        PlayerOne = new Player(tilesize-5, Color.BLUE);
        Playertwo = new Player(tilesize-15, Color.WHITE);

        Image img = new Image("C:\\Users\\rajat\\Desktop\\smake\\Smake\\src\\snLad1.jpg");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitWidth(tilesize*width);
        boardImage.setFitHeight(tilesize*height);

        tileGroup.getChildren().addAll(boardImage, playerOneButton,randResult, GameButton, playerTwoButton
                , PlayerOne.getGamePiece()
                , Playertwo.getGamePiece()

        );
        return root;

    }
    private void getDiceValue(){
        diceValue = (int)(Math.random()*6+1);
        randResult.setText(Integer.toString(diceValue));
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake&Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}