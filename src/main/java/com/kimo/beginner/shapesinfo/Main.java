package com.kimo.beginner.shapesinfo;

import com.kimo.beginner.shapesinfo.threeDshapes.Cone;
import com.kimo.beginner.shapesinfo.threeDshapes.Cube;
import com.kimo.beginner.shapesinfo.threeDshapes.Cuboid;
import com.kimo.beginner.shapesinfo.threeDshapes.Cylinder;
import com.kimo.beginner.shapesinfo.threeDshapes.Sphere;
import com.kimo.beginner.shapesinfo.twoDshapes.Circle;
import com.kimo.beginner.shapesinfo.twoDshapes.Ellipse;
import com.kimo.beginner.shapesinfo.twoDshapes.Parallelogram;
import com.kimo.beginner.shapesinfo.twoDshapes.Rectangle;
import com.kimo.beginner.shapesinfo.twoDshapes.Square;
import com.kimo.beginner.shapesinfo.twoDshapes.Triangle;

public class Main {

	public static void main(String[] args) {
		Shape square = new Square(5);
		Shape triangle = new Triangle(10, 10);
		Shape parallelogram = new Parallelogram(10, 10);
		Shape rectangle = new Rectangle(10, 5);
		Shape circle = new Circle(5);
		Shape ellipse = new Ellipse(5, 8);

		Shape sphere = new Sphere(5);
		Shape cylinder = new Cylinder(5, 5);
		Shape cone = new Cone(5, 8);
		Shape cube = new Cube(5);
		Shape cuboid = new Cuboid(10, 10, 10);

		square.dump();
		triangle.dump();
		parallelogram.dump();
		rectangle.dump();
		circle.dump();
		ellipse.dump();

		sphere.dump();
		cylinder.dump();
		cone.dump();
		cube.dump();
		cuboid.dump();
	}

}
