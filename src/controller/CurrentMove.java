package controller;

import exception.InvalidPointException;
import model.Field;
import model.Figure;
import model.Point;

public class CurrentMove {

   public Figure currentMove (final Field field) {
       int countFigure = 0;
       for (int i = 0; i < field.getFieldSize(); i += 1) {
           countFigure += countFiguresInTheRow(field, i);
       }

       if (countFigure == field.getFieldSize() * field.getFieldSize()) return null;

       if (countFigure % 2 == 0) return Figure.X;

       return Figure.O;
   }

   private int countFiguresInTheRow (final Field field, final int row) {
       int countFigure = 0;
       for (int i = 0; i < field.getFieldSize(); i += 1) {
           try {
               if (field.getFigure(new Point(i, row)) != null) {
                   countFigure++;
               }
           } catch (InvalidPointException e) {
               e.printStackTrace();
           }
       }
       return countFigure;
   }

}
