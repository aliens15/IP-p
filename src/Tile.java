public class Tile {
    private String letter;
    private int Xcord;
    private int Ycord;

    public Tile(String letter, int Xcord, int Ycord) {
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
}
