package com.example.smake;

import javafx.util.Pair;

import java.util.ArrayList;

public class GameBoard {

    static int height = 10;
    static int width = 10;
    static int tilesize = 40;

    static ArrayList<Pair<Integer,Integer>>positionCoordinates;
    static ArrayList<Integer>SnakeLadderPos;

    public int getXValue(int piecePosition)
    {
        return positionCoordinates.get(piecePosition).getKey();
    }

    public int getYValue(int piecePosition)
    {
        return positionCoordinates.get(piecePosition).getValue();
    }

    public int playerPosAtSnakeOrLadder(int piecePosition)
    {
           if(piecePosition != SnakeLadderPos.get(piecePosition))
           {
               return SnakeLadderPos.get(piecePosition);
           }

           return -1;
    }
    public GameBoard()
    {
        populatePositionCoordinates();
        setPositionCoordinates();
    }
    private static void populatePositionCoordinates()
    {
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<Integer,Integer>(20,380));

        int  xPos, yPos ;

        for (int i = height-1; i >= 0; i--) {
            for (int j = width-1; j >= 0; j--) {

                if(i%2 != 0)
                {
                    xPos = tilesize*width -(tilesize/2+tilesize*j);
                }
                else{
                    xPos = (tilesize/2+tilesize*j);
                }
                yPos = (tilesize/2+tilesize*i);

                positionCoordinates.add(new Pair<Integer,Integer>(xPos,yPos));
            }


        }

        for (int i = 0; i < positionCoordinates.size(); i++) {
            System.out.println(i + " x: " + positionCoordinates.get(i).getKey()+ "y: " + positionCoordinates.get(i).getValue());
        }

    }



    private void setPositionCoordinates()
    {

        SnakeLadderPos = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            SnakeLadderPos.add(i);
        }

        SnakeLadderPos.set(2,38);
        SnakeLadderPos.set(7,14);
        SnakeLadderPos.set(8,31);
        SnakeLadderPos.set(15,26);
        SnakeLadderPos.set(16,6);
        SnakeLadderPos.set(21,42);
        SnakeLadderPos.set(28,84);
        SnakeLadderPos.set(36,44);
        SnakeLadderPos.set(46,25);
        SnakeLadderPos.set(49,11);
        SnakeLadderPos.set(51,67);
        SnakeLadderPos.set(62,19);
        SnakeLadderPos.set(64,60);
        SnakeLadderPos.set(71,91);
        SnakeLadderPos.set(74,53);
        SnakeLadderPos.set(78,98);
        SnakeLadderPos.set(87,94);
        SnakeLadderPos.set(89,68);
        SnakeLadderPos.set(92,88);
        SnakeLadderPos.set(95,75);
        SnakeLadderPos.set(99,80);

    }

    public static void main(String[] args)
    {
        populatePositionCoordinates();
    }
}
