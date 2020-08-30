public class WordChecker extends Thread{
    private DiceData[][][] adjacencyList;
    private boolean [][] validityMap;
    private final int Xcoord, Ycoord;
    private final String word;
    private String subWord;

    public WordChecker(DiceData[][][] adjacencyList, int Xcoord, int Ycoord, String word){
        this.word = word;
        this.Xcoord = Xcoord;
        this.Ycoord = Ycoord;
        this.adjacencyList = adjacencyList;
        int rows = adjacencyList.length;
        int columns = adjacencyList[0].length;
        this.validityMap = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.validityMap[i][j] = true;
            }
        }
        this.validityMap[Xcoord][Ycoord] = false;
    }

    public WordChecker(DiceData[][][] adjacencyList, int Xcoord, int Ycoord, boolean[][] validityMap,
                       String word, String subWord){
        this.word = word;
        this.subWord = subWord;
        this.Xcoord = Xcoord;
        this.Ycoord = Ycoord;
        this.adjacencyList = adjacencyList;
        this.validityMap = validityMap;
        this.validityMap[Xcoord][Ycoord] = false;
    }

    public void run() {
        boolean found = false;
        for (int i = 0; i < adjacencyList[Xcoord][Ycoord].length; i++) {
            DiceData tmp = adjacencyList[Xcoord][Ycoord][i];
            if (tmp.getLetter().equals(
                    subWord.substring(0,tmp.getLetter().length())) &&
                    validityMap[tmp.getXcord()][tmp.getYcord()]){

                String newSubWord = subWord.substring(tmp.getLetter().length()); //test method
                found = true;
                if (newSubWord.length() > 0) {
                    WordChecker t1 = new WordChecker(adjacencyList, tmp.getXcord(), tmp.getYcord(),
                            validityMap, word, newSubWord);
                    t1.start();
                } else {
                    System.out.println("trovata parola " + word);
                }
            }
        } if(!found){
            System.out.println("Parola non valida "+ word);
        }
    }
    //ritorno risultato
    /*

     */
}
