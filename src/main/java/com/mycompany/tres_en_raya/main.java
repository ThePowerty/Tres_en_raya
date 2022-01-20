package com.mycompany.tres_en_raya;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] instrucciones = new String[3][3];
        int opción;
        String inst = "";
        boolean salida = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                instrucciones[i][j] = Integer.toString(i) + Integer.toString(j) + " ";
            }
        }
        while (!salida) {

            opción = Integer.parseInt(JOptionPane.showInputDialog("..::TRES EN RAYA::.." + "\n1.Instrucciones" + "\n2.Partida nueva" + "\n3.Salir" + "\nSeleccione una opción: "));
            switch (opción) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            inst += instrucciones[i][j];
                        }
                        inst += "\n";
                    }
                    JOptionPane.showMessageDialog(null, "..::Instrucciones::.." + "\nEste es un ejemplo de tablero con sus posiciones a escoger: \n" + inst + "\nEn cada turno cada jugador escogerá una posición y se irá actualizando el tablero." + "\nGanará el jugador que consiga un tres en raya.");
                    break;
                case 2:
                    jugar();
                    break;
                case 3:
                    salida = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
            }

        }
    }

    static void jugar() {
        String[][] tablero = new String[3][3];
        String pos, tab = "";
        int pos1, pos2;
        boolean salida = false, correcto = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = "-- ";
            }
        }
        do {
            do {
                pos = JOptionPane.showInputDialog(tab + "\nTurno Jugador 1: ");
                pos1 = pos.charAt(0) - 48;
                pos2 = pos.charAt(1) - 48;
                if (pos1 >= 0 && pos1 <= 2 && pos2 >= 0 && pos2 <= 2) {
                    
                    if (tablero[pos1][pos2] == "-- ") {
                        tablero[pos1][pos2] = " X ";
                        tab = "";
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                tab += tablero[i][j];
                            }
                            tab += "\n";
                        }
                        JOptionPane.showMessageDialog(null, tab);
                        correcto = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Jugada no válida");
                        correcto = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jugada no válida");
                    correcto = false;
                }
            } while (!correcto);
            if (ganador(tablero) == 1) {
                JOptionPane.showMessageDialog(null, "¡Gana Jugador 1!");
                salida = true;
            } else if (ganador(tablero) == 3) {
                JOptionPane.showMessageDialog(null, "¡Empate!");
                salida = true;
            } else {
                do {
                    pos = JOptionPane.showInputDialog(tab + "\nTurno Jugador 2: ");
                    pos1 = pos.charAt(0) - 48;
                    pos2 = pos.charAt(1) - 48;
                    if (pos1 >= 0 && pos1 <= 2 && pos2 >= 0 && pos2 <= 2) {
                        
                        if (tablero[pos1][pos2] == "-- ") {
                            tablero[pos1][pos2] = " O ";
                            tab = "";
                            for (int i = 0; i < 3; i++) {
                                for (int j = 0; j < 3; j++) {
                                    tab += tablero[i][j];
                                }
                                tab += "\n";
                            }
                            JOptionPane.showMessageDialog(null, tab);
                            correcto = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Jugada no válida");
                            correcto = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Jugada no válida");
                        correcto = false;
                    }
                } while (!correcto);
                if (ganador(tablero) == 2) {
                    JOptionPane.showMessageDialog(null, "¡Gana Jugador 2!");
                    salida = true;
                }
            }
        } while (!salida);
        JOptionPane.showMessageDialog(null, "¡Gracias por jugar!");
        JOptionPane.showMessageDialog(null, "¡Adios!");
    }

    static int ganador(String[][] tablero) {
        int gana = 0;
        if (tablero[0][0] == tablero[0][1] && tablero[0][0] == tablero[0][2]) {
            if (tablero[0][0] == " X ") {
                gana = 1;
            } else if (tablero[0][0] == " O ") {
                gana = 2;
            }
        } else if (tablero[0][0] == tablero[1][0] && tablero[0][0] == tablero[2][0]) {
            if (tablero[0][0] == " X ") {
                gana = 1;
            } else if (tablero[0][0] == " O ") {
                gana = 2;
            }
        } else if (tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            if (tablero[0][0] == " X ") {
                gana = 1;
            } else if (tablero[0][0] == " O ") {
                gana = 2;
            }
        } else if (tablero[1][0] == tablero[1][1] && tablero[1][0] == tablero[1][2]) {
            if (tablero[1][0] == " X ") {
                gana = 1;
            } else if (tablero[1][0] == " O ") {
                gana = 2;
            }
        } else if (tablero[2][0] == tablero[2][1] && tablero[2][0] == tablero[2][2]) {
            if (tablero[2][0] == " X ") {
                gana = 1;
            } else if (tablero[2][0] == " O ") {
                gana = 2;
            }
        } else if (tablero[0][1] == tablero[1][1] && tablero[0][1] == tablero[2][1]) {
            if (tablero[0][1] == " X ") {
                gana = 1;
            } else if (tablero[0][1] == " O ") {
                gana = 2;
            }
        } else if (tablero[0][2] == tablero[1][2] && tablero[0][2] == tablero[2][2]) {
            if (tablero[0][2] == " X ") {
                gana = 1;
            } else if (tablero[0][2] == " O ") {
                gana = 2;
            }
        } else if (tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
            if (tablero[0][2] == " X ") {
                gana = 1;
            } else if (tablero[0][2] == " O ") {
                gana = 2;
            }
        } else if (empate(tablero)) {
            gana = 3;
        }
        return gana;
    }

    static boolean empate(String[][] tablero) {
        boolean empate;
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] != "-- ") {
                    cont++;
                }
            }
        }
        empate = cont == 9;
        return empate;
    }
}
