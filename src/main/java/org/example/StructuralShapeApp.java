package org.example;

import java.util.ArrayList;
import java.util.List;

public class StructuralShapeApp {

    enum ShapeType {
        CIRCLE, TRIANGLE, RECTANGLE
    }

    static class Shape {
        Long id;
        ShapeType type;
        Double area;
        Double perimeter;

        Shape(Long id, ShapeType type, Double area, Double perimeter) {
            this.id = id;
            this.type = type;
            this.area = area;
            this.perimeter = perimeter;
        }

        @Override
        public String toString() {
            return String.format("Shape{id=%d, type=%s, area=%.2f, perimeter=%.2f}",
                    id, type, area, perimeter);
        }
    }

    static final List<Shape> SHAPES = new ArrayList<>();
    static Long NEXT_ID = 1L;

    static Long nextId() {
        return NEXT_ID++;
    }

    static Shape createShape(ShapeType type, Double area, Double perimeter) {
        if (!isValid(type, area, perimeter)) {
            throw new IllegalArgumentException("Invalid shape data");
        }
        Shape shape = new Shape(nextId(), type, area, perimeter);
        SHAPES.add(shape);
        return shape;
    }

    static Shape findFirstByMaxArea() {
        if (SHAPES.isEmpty()) {
            return null;
        }
        Shape max = SHAPES.get(0);
        for (Shape s : SHAPES) {
            if (s.area > max.area) {
                max = s;
            }
        }
        return max;
    }

    static boolean isValid(ShapeType type, Double area, Double perimeter) {
        return type != null
                && area != null && area >= 0
                && perimeter != null && perimeter >= 0;
    }

    public static void main(String[] args) {
        createShape(ShapeType.CIRCLE, 78.5, 31.4);
        createShape(ShapeType.TRIANGLE, 24.0, 18.0);
        createShape(ShapeType.RECTANGLE, 50.0, 30.0);

        System.out.println("Все фигуры:");
        for (Shape s : SHAPES) {
            System.out.println("  " + s);
        }
        Shape max = findFirstByMaxArea();

        System.out.println();
        if (max == null) {
            System.out.println("No shapes found");
        } else {
            System.out.println("Фигура с максимальной площадью:");
            System.out.println("  " + max);
        }
    }
}