import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.LinkedList;

public class Adjacency {
    private DiceData[][][] adjacencyList;

    public Adjacency(String[][] matRicevuta, int rows, int columns) {
        this.adjacencyList = new DiceData[rows][columns][];
        createList(matRicevuta);
        for (int i = 0; i < adjacencyList[2][2].length; i++) {
            System.out.println(adjacencyList[2][2][i].getLetter());
            System.out.println(Arrays.toString(adjacencyList[2][2][i].getPosition()));

        }
    }

    private boolean checkBoundry(String[][] matRicevuta, int X, int Y) {
        int Xsize = matRicevuta.length;
        int Ysize = matRicevuta[0].length;
        if((X >= 0) & (X < Xsize) & (Y >= 0) & (Y < Ysize)) {
            return true;
        }
        return false;
    }

    void createList(String[][] matRicevuta){
        for(int i = 0; i < matRicevuta.length; i++) {
            for(int j = 0; j < matRicevuta[i].length; j++) {
                LinkedList<DiceData> tempList = new LinkedList<>();

                for (int X = i - 1; X <= i + 1; X++) {
                    for (int Y = j - 1; Y <= j + 1; Y++) {
                        if (!((X == i) && (Y == j))) {
                            if (checkBoundry(matRicevuta, X, Y)) {
                                tempList.add(new DiceData(matRicevuta[X][Y], X, Y));
                            }
                        }
                    }
                }
                adjacencyList[i][j] = tempList.toArray(new DiceData[tempList.size()]);
            }
        }
    }

    public DiceData[][][] getAdjacencyList() {
        return adjacencyList;
    }

    //classe doppia lettera-posizione
    public static void main(String[] args) {
//        final String[][] matRicevuta = {
//                {"G", "A", "U", "T"},
//                {"P", "R", "M", "R"},
//                {"D", "O", "L", "A"},
//                {"E", "S", "I", "C"},
//        };
//        Adjacency adjacency = new Adjacency(matRicevuta, 4,4);

        //{["a", "1"],["B", "2"],["C", "3"]};
        //matr[1] = new String[]{"A","B", "C", "D", "E"};
        //matr[2] = new String[]{"A","B", "C", "D", "E"};

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                //System.out.println(adjacency.matRicevuta[i][j]);
//            }
//
//        }
//        String startL = "p";
//        String startL2 = "qu";
//        String subWord = "prova";
//        String subWord2 = "questa";
//        if(startL.equals(subWord.substring(0,startL.length()))){
//            System.out.println(subWord.substring(startL.length()));
//        }
//        if(startL2.equals(subWord2.substring(0,startL2.length()))){
//            System.out.println(subWord2.substring(startL2.length()));
//        }
    }
}
