package main;

import heroes.Round;
import java.io.FileNotFoundException;
import java.io.IOException;
import fileio.implementations.FileReader;
import fileio.implementations.FileWriter;
import heroes.Player;


public class Main {
    private Main() {

    }

    public static void main(final String[] args) throws IOException {
        final Round round = new Round();
        String fileIn = args[0];
        String fileOut = args[1];

        /*citire din fisier*/
        try {
            FileReader read = new FileReader(fileIn);
            int n = read.nextInt();
            int m = read.nextInt();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s.append(read.nextWord());
            }
            Map map = new Map(n, m, s.toString());
            int nrPlayers = read.nextInt();
            Player[] player = new Player[nrPlayers];
            for (int i = 0; i < nrPlayers; i++) {
                player[i] = PlayerGenerator.instance.generatePlayer(read.nextWord(),
                        read.nextInt(), read.nextInt(), map);
            }

            /*creere de runde*/
            int nrRounds = read.nextInt();
            while (nrRounds != 0) {
                String directions = read.nextWord();
                round.gameRounds(player, nrPlayers, directions);
                nrRounds--;
            }
            /*scrierea in fisier*/
            try {
                FileWriter write = new FileWriter(fileOut);
                for (int i = 0; i < nrPlayers; i++) {
                    if (player[i].isDead()) {
                        write.writeWord(player[i].getHeroType() + " " + "dead");
                        write.writeNewLine();
                    } else {
                        write.writeWord(player[i].getHeroType() + " " + player[i].getLv()
                                + " " + player[i].getXp() + " "
                                + player[i].getHp() + " " + player[i].getNPosition()
                                + " " + player[i].getMPosition());
                        write.writeNewLine();
                    }
                }
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

