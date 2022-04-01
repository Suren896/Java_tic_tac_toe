package com.Java_tic_tac_toe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    private static final char[][] MAP = new char[SIZE][SIZE];

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (isWin(DOT_X)) {
                System.out.println("Человек победил!");
                break;
            }
            if (isDraw()) {
                break;
            }

            computerTurn();
            printMap();

            if (isWin(DOT_O)) {
                System.out.println("Компьютер победил!");
                break;
            }
            if (isDraw()) {
                break;
            }
        }
    }

    private static boolean isDraw() {
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    public static void humanTurn() {
        Scanner console = new Scanner(System.in);
        int x;
        int y;

        do {
            System.out.println("Введите координаты в формате X Y");
            x = console.nextInt() - 1;
            y = console.nextInt() - 1;
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                System.out.println("Данные введены некорректно");
            } else if (MAP[x][y] != DOT_EMPTY) {
                System.out.println("Клетка уже занята");
            } else {
                break;
            }
        } while (true);
        MAP[x][y] = DOT_X;
    }

    private static boolean isWin(char symbol) {

        int stro = 0;
        int stlb = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == symbol) {
                    stro++;
                } else {
                    stro = 0;
                }
                if (MAP[j][i] == symbol) {
                    stlb++;
                } else {
                    stlb = 0;
                }
            }
            if (stro == SIZE) {
                return true;
            } else if (stlb == SIZE) {
                return true;
            }
        }

        int tuda = 0;
        int suda = 0;

        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][i] == symbol) {
                tuda++;
            } else {
                tuda = 0;
            }
            if (tuda == SIZE) {
                return true;
            }
        }
        int m = 1;
        for (int i = 0; i < SIZE; i++) {
            if(MAP[i][SIZE - m] == symbol) {
                suda++;
                m++;
            } else {
                suda = 0;
                m = 1;
            }
            if (suda == SIZE) {
                return true;
            }
        }

        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DOT_EMPTY) {
                    return false; // когда найдена пустая ячейка, значит можно ещё ходить.
                }
            }
        }
        return true;
    }

    private static void computerTurn() {
        int x;
        int y;

//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (i != 2 && j != 2 && MAP[i][j] == DOT_X) { // проверяем Х по строчкам
//                    MAP[i][j + 1] = DOT_O;
//                } else if (i != 0 && j != 0 && MAP[i][j] == DOT_X) { // проверяем Х по строчкам
//                    MAP[i][j - 1] = DOT_O;
//                } else if (i != 2 && j != 2 && MAP[j][i] == DOT_X) { // проверяем Х по столбикам
//                    MAP[j + 1][i] = DOT_O;
//                } else if (i != 0 && j != 0 && MAP[j][i] == DOT_X) { // проверяем Х по столбикам
//                    MAP[j - 1][i] = DOT_O;
//                } else if ((i == 0 && j == 2 && MAP[j][i] == DOT_X) || (i == 2 && j == 0 && MAP[j][i] == DOT_X)) {
//                    MAP[i][j] = DOT_O;
//                }
//
//            }
//        }


        Random random = new Random();

        do {
            x = random.nextInt(SIZE); // SIZE не включительно
            y = random.nextInt(SIZE);
            System.out.println("Компьютер подобрал координаты " + x + " " + y);
        } while (MAP[x][y] != DOT_EMPTY);

        MAP[x][y] = DOT_O;
    }


    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeader();
        printBody();
    }

    private static void printHeader() {
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print(" " + i);
            }
        }
        System.out.println();
    }

    private static void printBody() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}