/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.exitlabyrinth;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author igallego
 */
public class Labyrinth {

    private char[][] labyrinth = new char[13][50];
    private Stack<Position> path;
    private Position pos;
    //private char direction;
    private File file;
    private Scanner readLabyrinth;

    public Labyrinth() {
        //direction = 'd';
        path = new Stack<Position>();
        pos = new Position();
    }

    public void load(String s) throws Exception {
        file = new File(s);
        Scanner readLabyrinth = new Scanner(file);
        int i = 0;
        String line;
        while (readLabyrinth.hasNextLine()) {
            line = readLabyrinth.nextLine();
            line.getChars(0, line.length(), labyrinth[i], 0);
            i++;
        }
        pos = search('E');
    }

    public Position search(char s) {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                if (labyrinth[i][j] == s) {
                    return new Position(i, j, s);
                }
            }
        }
        return new Position(0, 0, 'W');
    }

    public void solve() {
        Position end = new Position();

        while (pos.in != 'S') {
            int x = pos.x, y = pos.y;

            if ((labyrinth[x + 1][y] == 'S' || labyrinth[x + 1][y] == ' ') && !( (x+1 == end.x) && (y == end.y) )) {
                labyrinth[x][y] = '·';
                pos.x++;
                pos.in = labyrinth[x + 1][y];
                path.push(new Position(pos.x, pos.y, pos.in));
            } else if ((labyrinth[x][y + 1] == 'S' || labyrinth[x][y + 1] == ' ') && !( (x == end.x) && (y+1 == end.y) )) {
                labyrinth[x][y] = '·';
                pos.y++;
                pos.in = labyrinth[x][y + 1];
                path.push(new Position(pos.x, pos.y, pos.in));
            } else if ((labyrinth[x][y - 1] == 'S' || labyrinth[x][y - 1] == ' ') && !( (x == end.x) && (y-1 == end.y) )) {
                labyrinth[x][y] = '·';
                pos.y--;
                pos.in = labyrinth[x][y - 1];
                path.push(new Position(pos.x, pos.y, pos.in));
            } else if ((labyrinth[x - 1][y] == 'S' || labyrinth[x - 1][y] == ' ') && !( (x-1 == end.x) && (y == end.y) )) {
                labyrinth[x][y] = '·';
                pos.x--;
                pos.in = labyrinth[x - 1][y];
                path.push(new Position(pos.x, pos.y, pos.in));
            } else { //End of path
                System.out.println("AMOH PATRAH!!!");
                labyrinth[x][y] = ' ';
                end = new Position(path.pop());
                System.out.println("end: " + end.x + ", " + end.y);
                pos = new Position(path.peek());
                System.out.println("position: " + pos.x + ", " + pos.y);
                //break;
            }

            //System.out.println(path.peek().toString());
            System.out.println(this.toString());
        }
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                out += labyrinth[i][j];
            }
            out += "\n";
        }
        return out;
    }

}
