/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.exitlabyrinth;

/**
 *
 * @author igallego
 */
public class Position {
    int x;
    int y;
    char in;
    
    public Position(){
        this.x=0;
        this.y=0;
    }
    
    public Position(Position p){
        this.x = p.x;
        this.y = p.y;
        this.in = p.in;
    }
    
    public Position(int x, int y, char in){
        this.x=x;
        this.y=y;
        this.in=in;
    }
    
    @Override
    public String toString(){
        String string = "";
        string+=x+", "+y;
        return string;
    }
}
