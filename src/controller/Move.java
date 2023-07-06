package controller;

import exception.AlreadyOccupiedException;
import exception.InvalidPointException;
import model.Field;
import model.Figure;
import model.Point;

public class Move {

    public void applyFigure(final Field field, final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
