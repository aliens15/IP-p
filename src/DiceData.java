public class DiceData {
    private String letter;
    private int Xcord;
    private int Ycord;

    public DiceData(String letter, int Xcord, int Ycord) {
        this.letter = letter;
        this.Xcord = Xcord;
        this.Ycord = Ycord;
    }

    public String getLetter() {
        return letter;
    }

    public int[] getPosition() {
        return new int[] {this.Xcord, this.Ycord};
    }

    public int getXcord(){return this.Xcord;}
    public int getYcord(){return this.Ycord;}
}
