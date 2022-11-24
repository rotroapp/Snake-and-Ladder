package com.example.smake;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle gamePiece;
    int xPos;
    int yPos;

    int currentPiecePos;

    static GameBoard gameBoard = new GameBoard();

    Player(int tileSize, Color pieceColor){


        this.currentPiecePos =1;
        this.xPos = gameBoard.getXValue(currentPiecePos);
        this.yPos = gameBoard.getYValue(currentPiecePos);

        gamePiece = new Circle(tileSize/2);
        gamePiece.setFill(pieceColor);
        gamePiece.setTranslateX(this.xPos);
        gamePiece.setTranslateY(this.yPos);

    }

    public void movePlayer(int diceValue){
        if(currentPiecePos + diceValue <= 100)
        {
            currentPiecePos += diceValue;
            translatePlayer();
        }
    }

    private void translatePlayer()
    {
        this.xPos = gameBoard.getXValue(this.currentPiecePos);
        this.yPos = gameBoard.getYValue(this.currentPiecePos);

        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),this.gamePiece);
        animate.setToX(this.xPos);
        animate.setToY(this.yPos);
        animate.setAutoReverse(false);
        animate.play();

//        gamePiece.setTranslateX(this.xPos);
//        gamePiece.setTranslateY(this.yPos);
    }
public void playerAtsnakeLadder()
{
    int newPosition = gameBoard.playerPosAtSnakeOrLadder(this.currentPiecePos);
    if (newPosition != -1)
    {
        this.currentPiecePos = newPosition;
        translatePlayer();
    }
}
public Circle getGamePiece()
{
    return this.gamePiece;
}

}
