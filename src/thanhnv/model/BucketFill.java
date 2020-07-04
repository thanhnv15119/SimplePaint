package thanhnv.model;

public class BucketFill {
    private Coordinate coordinate;
    private char character;

    public BucketFill(Coordinate coordinate, char character) {
        this.coordinate = coordinate;
        this.character = character;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}
