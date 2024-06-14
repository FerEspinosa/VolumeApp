package com.curso.android.app.practica.volumecalculator;

public class Shape {
    String shapeName;
    int shapeImg;

    public Shape(String shapeName, int shapeImg) {
        this.shapeName = shapeName;
        this.shapeImg = shapeImg;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public int getShapeImg() {
        return shapeImg;
    }

    public void setShapeImg(int shapeImg) {
        this.shapeImg = shapeImg;
    }
}
