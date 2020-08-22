import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordCheck {

    private final Loader loader=new Loader();
    private static final String file_dizionario= "dict-it.oxt";
    private final File dizionario=new File(file_dizionario);
    WordCheck(String[] player1, String[] player2, String[] player3, String[] player4, String[] player5, String[] player6) throws IOException {
//        LinkedList<String> word3P1 = new LinkedList<>(), word3P2 = new LinkedList<>(), word3P3 = new LinkedList<>(),
//                word3P4 = new LinkedList<>(), word3P5 = new LinkedList<>() word3P6 = new LinkedList<>();
//        LinkedList<String> word4P1 = new LinkedList<>();
//        LinkedList<String> word4P2 = new LinkedList<>();
//        LinkedList<String> word4P3 = new LinkedList<>();
//        LinkedList<String> word4P4 = new LinkedList<>();
//        LinkedList<String> word4P5 = new LinkedList<>();
//        LinkedList<String> word4P6 = new LinkedList<>();
//        LinkedList<String> word5P1 = new LinkedList<>();
//        LinkedList<String> word5P2 = new LinkedList<>();
//        LinkedList<String> word5P3 = new LinkedList<>();
//        LinkedList<String> word5P4 = new LinkedList<>();
//        LinkedList<String> word5P5 = new LinkedList<>();
//        LinkedList<String> word5P6 = new LinkedList<>();
//        LinkedList<String> word6P1 = new LinkedList<>();
//        LinkedList<String> word6P2 = new LinkedList<>();
//        LinkedList<String> word6P3 = new LinkedList<>();
//        LinkedList<String> word6P4 = new LinkedList<>();
//        LinkedList<String> word6P5 = new LinkedList<>();
//        LinkedList<String> word6P6 = new LinkedList<>();
//        LinkedList<String> word7P1 = new LinkedList<>();
//        LinkedList<String> word7P2 = new LinkedList<>();
//        LinkedList<String> word7P3 = new LinkedList<>();
//        LinkedList<String> word7P4 = new LinkedList<>();
//        LinkedList<String> word7P5 = new LinkedList<>();
//        LinkedList<String> word7P6 = new LinkedList<>();

        List<ArrayList<String>> playerOne = new ArrayList<>(), playerTwo = new ArrayList<>(),
                playerThree = new ArrayList<>(), playerFour = new ArrayList<>(), playerFive = new ArrayList<>(),
                playerSix = new ArrayList<>();
        devideWordByLength(player1, playerOne);
        devideWordByLength(player2, playerTwo);
        devideWordByLength(player3, playerThree);
        devideWordByLength(player4, playerFour);
        devideWordByLength(player5, playerFive);
        devideWordByLength(player6, playerSix);


        try {
            Dictionary d=loader.loadDictionaryFromFile(dizionario);
            System.out.println(d.getTerm("parola"));
        }catch (IOException e){
            e.printStackTrace();
        } catch (InvalidKey e) {
            e.printStackTrace();
        }
    }

    WordCheck(String [] player1, String[] player2, String[] player3, String[] player4, String[] player5) throws IOException {

    }
    WordCheck(String[] player1, String[] player2, String[] player3, String[] player4) throws IOException {

    }

    WordCheck(String[] player1, String[] player2, String[] player3) throws IOException {

    }
    WordCheck(String[] player1, String[] player2) throws IOException {

    }
    WordCheck(){
        try {
            Dictionary d=loader.loadDictionaryFromFile(dizionario);
            System.out.println(d.getTerm("parola"));
        }catch (IOException e){
            e.printStackTrace();
        } catch (InvalidKey e) {
            e.printStackTrace();
        }
    }
    void checkExistence(){}

    void checkDoubles(){
        //bucketSort or distribution count
        //posso ordinarle con il bucket e confrontare per ordine lessicale? -bucket ha bisogno parole di l uguale
        //oppure ordinarle tutte assieme con una matrice nx2 con seconda colonna per identificare il player che ha usato la parola

    }

    void devideWordByLength(String [] array, List<ArrayList<String>> list){
        for (int i = 0; i < 6; i++) {
            list.add(new ArrayList<>())  ;
        }
        for (String word : array) {
            int nWords = word.length();
            switch (nWords) {
                case 3:
                    list.get(1).add(word);
                case 4:
                    list.get(2).add(word);
                case 5:
                    list.get(3).add(word);
                case 6:
                    list.get(4).add(word);
                case 7:
                    list.get(5).add(word);
                case 8:
                    list.get(6).add(word);
            }
        }
    }

    public static void main (String []args){
        new WordCheck();
    }

}
