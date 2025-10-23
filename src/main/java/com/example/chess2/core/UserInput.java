package com.example.chess2.core;

import java.util.Scanner;

public class UserInput {
    public static int[] getPlayerMove() {
        Scanner sc = new Scanner(System.in);

        // --- Starting position ---
        System.out.print("Enter file (a-h) of piece to move: ");
        char startFileChar = sc.next().charAt(0);

        // Convert file (a-h) → 0–7
        int startFile = startFileChar - 'a';
        while(startFile < 0 || startFile > 7){
            System.out.print("Invalid input. Please enter file (a-h) of piece to move: ");
            startFileChar = sc.next().charAt(0);
            startFile = startFileChar - 'a';
        }

        System.out.print("Enter rank (1-8) of piece to move: ");
        int startRank = sc.nextInt();
        while(startRank < 1 || startRank > 8){
            System.out.print("Invalid input. Please enter rank (1-8) of piece to move: ");
            startRank = sc.nextInt();
        }

        // --- Destination position ---
        System.out.print("Enter file (a-h) of move: ");
        char endFileChar = sc.next().charAt(0);
        // Convert file (a-h) → 0–7
        int endFile = endFileChar - 'a';
        while(endFile < 0 || endFile > 7){
            System.out.print("Invalid input. Please enter file (a-h) of piece to move: ");
            endFileChar = sc.next().charAt(0);
            endFile = endFileChar - 'a';
        }

        System.out.print("Enter rank (1-8) of move: ");
        int endRank = sc.nextInt();
        while(endRank < 1 || endRank > 8){
            System.out.print("Invalid input. Please enter rank (1-8) of move: ");
            endRank = sc.nextInt();
        }

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
