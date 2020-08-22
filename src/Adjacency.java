import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Adjacency {
    private Node node;
    private NodeList list;
    private Boolean[] arrayTF;
    private Tile[][] adjacencyList;

    final String[][] matRicevuta = {
            {"G", "A", "U", "T"},
            {"P", "R", "M", "R"},
            {"D", "O", "L", "A"},
            {"E", "S", "I", "C"},
    };
    private String [][] adjacency = new String[16][8];

    public Adjacency(String[][] matRicevuta) {
    //        this.adjacencyList[0] = new Tile[] {new Tile(matRicevuta[0][1],1), new Tile(matRicevuta[1][1], 5)};

        this.adjacencyList = new Tile[16][];

        int count = 0;
        for(int i = 0; i < matRicevuta.length; i++) {
            for(int j = 0; j < matRicevuta[i].length; j++) {

                LinkedList<Tile> tempList = new LinkedList<>();

                for (int X = i - 1; X <= i + 1; X++) {
                    for (int Y = 0; Y <= j + 1; Y++) {
                        if (!((X == i) && (Y == j))) {
                            if (checkBoundry(X, Y)) {
                                tempList.add(new Tile(matRicevuta[X][Y], X, Y));
                            }
                        }
                    }
                }

                adjacencyList[count] = tempList.toArray(new Tile[tempList.size()]);
            }
        }
    }

    private boolean checkBoundry(int X, int Y) {
        int Xsize = matRicevuta.length;
        int Ysize = matRicevuta[0].length;
        if((X >= 0) & (X < Xsize) & (Y >= 0) & (Y < Ysize)) {
            return true;
        }
        return false;
    }

    void createList(String[][] adjacency) {
        //if pos 0 ---> arraylength = 3
        int count = 1;
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
        //Adjacency adjacency = new Adjacency();

        //{["a", "1"],["B", "2"],["C", "3"]};
        //matr[1] = new String[]{"A","B", "C", "D", "E"};
        //matr[2] = new String[]{"A","B", "C", "D", "E"};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //System.out.println(adjacency.matRicevuta[i][j]);
            }

        }
    }
}
