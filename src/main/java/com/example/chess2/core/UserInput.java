package com.example.chess2.core;

import java.util.Scanner;

public class UserInput {
    public static int[] getPlayerMove() {
        Scanner sc = new Scanner(System.in);

        // --- Starting position ---
        System.out.print("Enter file (a-h) of piece to move: ");
        char startFileChar = sc.next().charAt(0);
        System.out.print("Enter rank (1-8) of piece to move: ");
        int startRank = sc.nextInt();

        // --- Destination position ---
        System.out.print("Enter file (a-h) of move: ");
        char endFileChar = sc.next().charAt(0);
        System.out.print("Enter rank (1-8) of move: ");
        int endRank = sc.nextInt();

        // Convert files (a-h) → 0–7, ranks (1-8) → 0–7
        int startFile = startFileChar - 'a';
        int endFile = endFileChar - 'a';

        // Return as [startFile, startRank, endFile, endRank]
        return new int[]{startFile, rankConverter(startRank), endFile, rankConverter(endRank)};
    }

    public static int rankConverter(int rank){
        if(rank == 1){
            return 7;
        }
        if(rank == 2){
            return 6;
        }
        if(rank == 3){
            return 5;
        }
        if(rank == 4){
            return 4;
        }
        if(rank == 5){
            return 3;
        }
        if(rank == 6){
            return 2;
        }
        if(rank == 7){
            return 1;
        }
        if(rank == 8){
            return 0;
        }
        return -1;
    }
}
