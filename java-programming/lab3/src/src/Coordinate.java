package src;

public class Coordinate {
    public boolean compareCoordinate(Creature a, Location b) {
        return a.getCoordinate()[0] == b.getCoordinate()[0] & a.getCoordinate()[1] == b.getCoordinate()[1];
    }
}