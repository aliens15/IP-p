import java.util.ArrayList;

public class PlayerManag extends Thread{
    private ArrayList<String> wordPlayer;
    private DiceData[][][] adjacencyList;
    private final int columns,rows;

    public PlayerManag(ArrayList<String> wordPlayer, String[][] matRicevuta){
        rows = matRicevuta.length;
        columns = matRicevuta[0].length;
        Adjacency adjacency = new Adjacency(matRicevuta, rows, columns);
        adjacencyList = adjacency.getAdjacencyList();
        this.wordPlayer = wordPlayer;

    }

    public void run() {

        for (String s : wordPlayer) {
            WordChecker t1; //inizializare

            System.out.println(s);
        }
    }

//    void wordValidation (String word, DiceData[][][]adjacencyList){
//
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (word.charAt(i+1)!= 'u'){
//
//            }
//            else {
//
//            }
//        }
//
//    }
    //controlla la prima lettera nel tabellone di gioco
    ArrayList<DiceData> firstWord(String[][] matRicevuta, String word){
        ArrayList<DiceData> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matRicevuta[i][j].equals(word))
                    list.add(new DiceData(matRicevuta[i][j], i, j));
            }
        } return list;
    } //mettere in wordChecker per ogni parola
        //un wordchecker per ogni lettera dentro la lista



}

