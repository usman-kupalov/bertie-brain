package model;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Game implements Iterable<Player> {

    private final Player[] players;

    private final Field field;

    private String name;

    public Game(final Player[] players, final Field field, String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return Game.this.players.length > index;
        }

        @Override
        public Player next() {
            try {
                return Game.this.players[index++];
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException();
            }
        }
    }
}
