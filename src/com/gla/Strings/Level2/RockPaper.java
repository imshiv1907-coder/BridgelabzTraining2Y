package com.gla.Strings.Level2;
import java.util.Scanner;

public class RockPaper {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Number of games: ");
            int n = sc.nextInt();
            sc.nextLine();

            int userWins = 0, compWins = 0, draws = 0;
            String[] choices = {"Rock", "Paper", "Scissors"};

            for (int i = 1; i <= n; i++) {
                System.out.print("Game " + i + " - Enter choice: ");
                String user = sc.nextLine();
                String comp = choices[(int)(Math.random()*3)];

                String winner;
                if (user.equalsIgnoreCase(comp)) winner = "Draw";
                else if ((user.equalsIgnoreCase("Rock") && comp.equals("Scissors")) ||
                        (user.equalsIgnoreCase("Paper") && comp.equals("Rock")) ||
                        (user.equalsIgnoreCase("Scissors") && comp.equals("Paper"))) {
                    winner = "User"; userWins++;
                } else { winner = "Computer"; compWins++; }

                if (winner.equals("Draw")) draws++;
                System.out.printf("User: %s | Comp: %s | Winner: %s\n", user, comp, winner);
            }

            System.out.println("\nStats:");
            System.out.printf("User Wins: %d (%.2f%%)\nComputer Wins: %d (%.2f%%)\nDraws: %d (%.2f%%)\n",
                    userWins, 100.0*userWins/n,
                    compWins, 100.0*compWins/n,
                    draws, 100.0*draws/n);

        }

}
