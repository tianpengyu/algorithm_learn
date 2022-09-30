package org.baymax.interview.jdkSyntax;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2021/3/29 13:52
 */
public class FactoryByFunction {

  final static Map<String, Supplier<Shape>> map = new HashMap<>();

  static {
    map.put("CIRCLE", Circle::new);
    map.put("RECTANGLE", Rectangle::new);
  }

  public Shape getShape(String shapeType) {
    Supplier<Shape> shape = map.get(shapeType.toUpperCase());
    if (shape != null) {
      return shape.get();
    }
    throw new IllegalArgumentException("No such shape " + shapeType.toUpperCase());
  }

  public static void main(String[] args) {
    String circle = "CIRCLE";
    FactoryByFunction shapeFactory = new FactoryByFunction();

    Shape shape = shapeFactory.getShape(circle);
    System.out.println(shape);
  }


}




