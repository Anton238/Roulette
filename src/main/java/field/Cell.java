package field;


public class Cell {
    Color color;
    int number;

    public Cell(int number, Color color) {
        this.color = color;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "color=" + color +
                ", number=" + number +
                '}';
    }
}
