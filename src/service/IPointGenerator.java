package service;

import model.Point;

public interface IPointGenerator {
    Point next(final Point point);
}
