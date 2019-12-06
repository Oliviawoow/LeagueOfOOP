package main;

public class Map {
    private char[][] matrix;
    /*cream o matrice de dimensiune N x M care v-a contine tipurile de teren*/
    
    public Map(final int N, final int M, final String type) {
        int l = 0;
        matrix = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = type.charAt(l);
                l++;
            }
        }
    }

    public final char getType(final int i, final int j) {
        return matrix[i][j];
    }
}
