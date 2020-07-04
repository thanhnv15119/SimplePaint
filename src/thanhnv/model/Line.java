package thanhnv.model;

public class Line {
    private Coordinate from;
    private Coordinate to;
    private char character;

    public Line(Coordinate from, Coordinate to) {
        this.from = from;
        this.to = to;
    }

    public Coordinate getFrom() {
        return from;
    }

    public void setFrom(Coordinate from) {
        this.from = from;
    }

    public Line(Coordinate from, Coordinate to, char character) {
        this.from = from;
        this.to = to;
        this.character = character;
    }

    public Coordinate getTo() {
        return to;
    }

    public void setTo(Coordinate to) {
        this.to = to;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}
