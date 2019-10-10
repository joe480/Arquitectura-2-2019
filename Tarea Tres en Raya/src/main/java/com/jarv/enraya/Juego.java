/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarv.enraya;

import java.util.Scanner;


public class Juego {
    int [][] tablero =new int[3][3];

    public Juego() {
        for (int i = 0; i < tablero.length ; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                this.tablero[i][j]=0;
            }
        }
    }
    
private boolean marcar(int [] posicion,int jugador){
     boolean resultado = false;
     int x = posicion[0];
     int y = posicion[1];
     if(jugador==1){
        if(this.tablero[x][y]==0){
            this.tablero[x][y]=1;
            resultado =true;
        }
     }
          if(jugador==2){
        if(this.tablero[x][y]==0){
            this.tablero[x][y]=2;
            resultado =true;
        }
     }
     return resultado;
}

private boolean finPartida(int jugador){
    boolean resultado=false;
    int[][] tablero = this.tablero;
    int [][] estadoVictoria = {
        {tablero[0][0], tablero[0][1], tablero[0][2]},
        {tablero[1][0], tablero[1][1], tablero[1][2]},
        {tablero[2][0], tablero[2][1], tablero[2][2]},
        {tablero[0][0], tablero[1][0], tablero[2][0]},
        {tablero[0][1], tablero[1][1], tablero[2][1]},
        {tablero[0][2], tablero[1][2], tablero[2][2]},
        {tablero[0][0], tablero[1][1], tablero[2][2]},
        {tablero[2][0], tablero[1][1], tablero[0][2]},
    };
    int contador=0;
    for (int i = 0; i < estadoVictoria.length; i++) {
        for (int j = 0; j < estadoVictoria[0].length; j++) {
            if(estadoVictoria[i][j]==jugador)
                contador ++;
        }
        if(contador==3){
            resultado=true;
            break;
        }
        else
            contador=0;
    }
    return resultado;
}

private void imprimirTablero(){
    System.out.println("-----------");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            switch(this.tablero[i][j]){
                case 0:
                    System.out.print("| | ");
                    break;
                case 1:
                    System.out.print("|X| ");
                    break;
                case 2:
                    System.out.print("|O| ");
                    break;
            }  
        }
        System.out.println("");
        System.out.println("-----------");
    }
}

private int[] asignarPosicion(int posicion){
    int posicionV [] = new int[2];
    switch(posicion){
        case 1:
            posicionV[0]=0;
            posicionV[1]=0;
            break;
        case 2:
            posicionV[0]=0;
            posicionV[1]=1;
            break;
        case 3:
            posicionV[0]=0;
            posicionV[1]=2;
            break;
        case 4:
            posicionV[0]=1;
            posicionV[1]=0;
            break;
        case 5:
            posicionV[0]=1;
            posicionV[1]=1;
            break;
        case 6:
            posicionV[0]=1;
            posicionV[1]=2;
            break;
        case 7:
            posicionV[0]=2;
            posicionV[1]=0;
            break;
        case 8:
            posicionV[0]=2;
            posicionV[1]=1;
            break;
        case 9:
            posicionV[0]=2;
            posicionV[1]=2;
            break;   
    }
    return posicionV;
}

public void jugar(){
    Scanner sc=new Scanner(System.in);
    int jugador;
    int numjugada=1;
    int posicion;
    int [] jugada;
    boolean finPartida = false;
    do {
      if(numjugada%2==1){
          jugador=1;
          imprimirTablero();
          System.out.println("Jugador 1 es tu turno");
          System.out.println("Elija la posicion de su ficha[X](1-9):");
          posicion = sc.nextInt();
          if(posicion<1||posicion>9){
              limpiarConsola();
              System.out.println("Introducir una posion valida");
              System.out.println("Elija la posicion de su ficha[X](1-9):");
              posicion = sc.nextInt();
          }
          else{
          jugada =asignarPosicion(posicion);
          if(marcar(jugada, jugador)){
              if(finPartida(jugador)){
                  System.out.println("Jugador "+jugador+" gano la partida");
                  finPartida =true;
              }
              else{
                  limpiarConsola();
                  numjugada++;
              }
                  
          }
          else{
              System.out.println("Casilla Ocupada,perdio su turno!!!");
              numjugada++;
          } 
             
          
          }
          numjugada++;
      } 
      else{
          jugador=2;
          imprimirTablero();
          System.out.println("Jugador 2 es tu turno");
          System.out.println("Elija la posicion de su ficha[O](1-9):");
          posicion = sc.nextInt();
          if(posicion<1||posicion>9){
              limpiarConsola();
              System.out.println("Introducir una posion valida");
              System.out.println("Elija la posicion de su ficha[O](1-9):");
              posicion = sc.nextInt();
          }
          else{
          jugada =asignarPosicion(posicion);
          if(marcar(jugada, jugador)){
              if(finPartida(jugador)){
                  System.out.println("Jugador "+jugador+" gano la partida");
                  finPartida =true;
              }
              else{
                  limpiarConsola();
                  numjugada++;
              }
                  
          }
          else{
              System.out.println("Casilla Ocupada,perdio su turno!!!");
              numjugada++;
          } 
             
          
          }
          numjugada++;
      } 
    } while (numjugada<=9 && finPartida ==false);
    
}

    private void limpiarConsola(){
         for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }
    
    
    
}
