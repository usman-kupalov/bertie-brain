package model;

public class Player {

    private String firstName;

    private final Figure figure;

    public Player (String firstName, final Figure figure) {
        this.firstName = firstName;
        this.figure = figure;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
}
