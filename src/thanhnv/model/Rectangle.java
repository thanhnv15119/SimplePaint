package thanhnv.model;

public class Rectangle {
    private Coordinate from;
    private Coordinate to;
    private char character;

    public Rectangle(Coordinate from, Coordinate to, char character) {
        this.from = from;
        this.to = to;
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Coordinate getFrom() {
        return from;
    }

    public void setFrom(Coordinate from) {
        this.from = from;
    }

    public Coordinate getTo() {
        return to;
    }

    public void setTo(Coordinate to) {
        this.to = to;
    }
}
