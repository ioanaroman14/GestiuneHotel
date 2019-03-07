package Domain;

public class RoomAverageRating {
    private int room;
    private double averageRating;

    @Override
    public String toString() {
        return "RoomAverageRating{" +
                "room=" + room +
                ", averageRating=" + averageRating +
                '}';
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public RoomAverageRating(int room, double averageRating) {
        this.room = room;
        this.averageRating = averageRating;
    }
}
