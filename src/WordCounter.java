import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordCounter {

    private final Loader loader=new Loader();
    private static final String file_dizionario= "dict-it.oxt";
    private final File dizionario=new File(file_dizionario);
    private String[][] matRicevuta, player;

    WordCounter(String[][] matRicevuta){
        this.matRicevuta = matRicevuta;
    }

    ArrayList<String> prova = new ArrayList<>();


    WordCounter() throws IOException {
        prova.add("ramo");
        prova.add("mola");

        prova.add("dosi");
        prova.add("dose");

        prova.add("doloso");//uso 2 volte lettera
        prova.add("mare");

        checkPlayers(prova);
        Dictionary d = loader.loadDictionaryFromFile(dizionario);
        for (int i = 0; i < prova.size(); i++) {
            try {
                System.out.println(d.getTerm(prova.get(i)));
            } catch(InvalidKey e){
                e.printStackTrace();
            }
        }

        //conta doppioni, getter su metodo che fa confronti e elimina doppie da array

    }
    void checkPlayers(ArrayList<String> players){//passa arraylist delle parole trovate dal giocatore
         PlayerManag playerManag = new PlayerManag(players, matRicevuta);
         new Thread(playerManag).start();

         //get the changed list
    }

    void checkExistence(){}

    void checkDoubles(){
        //bucketSort or distribution count
        //posso ordinarle con il bucket e confrontare per ordine lessicale? -bucket ha bisogno parole di l uguale
        //oppure ordinarle tutte assieme con una matrice nx2 con seconda colonna per identificare il player che ha usato la parola

    }

    void devideWordByLength(String [] array, List<ArrayList<String>> list){ //List<ArrayList<String>> list[]
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

    public static void main (String []args) throws IOException {
        new WordCounter();

    }

}
