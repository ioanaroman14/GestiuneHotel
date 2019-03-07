package Domain;

public class Person {
    private int id, person, room, days;
    private String feedback;
    private double rating;
    private boolean checkOut;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", person=" + person +
                ", room=" + room +
                ", days=" + days +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                ", checkOut=" + checkOut +
                '}';
    }

    public Person(int id, int room, int person, int days) {
        this.id = id;
        this.room = room;
        this.person = person;
        this.days = days;
    }

    public Person(int id, int room, int person, int days, String feedback, double rating, boolean checkOut) {
        this.id = id;
        this.room = room;
        this.person = person;
        this.days = days;
        this.feedback = feedback;
        this.rating = rating;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getRoom() {
        return room;
    }
    public void setRoom(int room) {
        this.room = room;
    }

    public int getPerson() {
        return person;
    }
    public void setPerson(int person) {
        this.person = person;
    }

    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }



    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

}

