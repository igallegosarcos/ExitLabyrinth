/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.curso.exitlabyrinth;

/**
 *
 * @author igallego
 */
public class ExitLabyrinth {

    public static void main(String[] args) {
        //char[][] h = {{'q','q','t','q','E','q','q'},{'q','q','q','q','q','q','q'}};
        Labyrinth labyrinth = new Labyrinth();
        try{
            labyrinth.load("C:\\Users\\igallego\\Documents\\NetBeansProjects\\ExitLabyrinth\\Labyrinths\\laberinto1");
        }catch (Exception e){
            System.out.println("AAAAAAAAAAAAAHHHHHHHHHHHH!!!!!!"+e);
        }
        labyrinth.solve();
        System.out.println(labyrinth.toString());
    }
}
