import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Adjacency {
    private Node node;
    private NodeList list;
    private Boolean[] arrayTF;

    final String[][] matRicevuta = {
            {"G", "A", "U", "T"},
            {"P", "R", "M", "R"},
            {"D", "O", "L", "A"},
            {"E", "S", "I", "C"},
    };
    private String [][] adjacency = new String[16][8];

    Adjacency() {
        createList(adjacency);
    }

    void createList(String[][] adjacency) {
        //if pos 0 ---> arraylength = 3
        int nItems;
        int count = 0;
        boolean completed = false;
        for (int i = 0; i < 4; i++) {
            int countL = 0;
            for (int j = 0; j < 4; j++) {
                if(i!=0) {
                    adjacency[count][countL++] = matRicevuta[i-1][j];
                    if(j!=0) adjacency[count][countL++] = matRicevuta[i-1][j-1];
                    if(j!=3) adjacency[count][countL++] = matRicevuta[i-1][j+1];
                }
                if(j!=0) {
                    adjacency[count][countL++] = matRicevuta[i][j-1];
                }
                if(j!=3) {
                    adjacency[count][countL++] = matRicevuta[i][j+1];
                }
                if(i!=3) {
                    adjacency[count][countL++] = matRicevuta[i+1][j];
                    if(j!=0) adjacency[count][countL++] = matRicevuta[i+1][j-1];
                    if(j!=3) adjacency[count][countL++] = matRicevuta[i+1][j+1];
                }
            }
            count++;
        }
    }

    //classe doppia lettera-posizione
    public static void main(String[] args) {
        Adjacency adjacency = new Adjacency();

        //{["a", "1"],["B", "2"],["C", "3"]};
        //matr[1] = new String[]{"A","B", "C", "D", "E"};
        //matr[2] = new String[]{"A","B", "C", "D", "E"};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(adjacency.matRicevuta[i][j]);
            }

        }
    }
}
