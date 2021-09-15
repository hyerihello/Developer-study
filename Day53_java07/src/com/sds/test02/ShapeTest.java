package com.sds.test02;
// 전에 했던 워크샵 ArrayList로 변경하기!
import java.util.ArrayList;
import java.util.Vector;

public class ShapeTest {


	public static void main(String[] args) {
		ArrayList v = new ArrayList();
		
		v.add(new Triangle (7, 5, "Blue"));
		v.add(new Rectangle (4, 6, "Blue"));
		v.add(new Triangle (6, 7, "Red"));
		v.add(new Rectangle (8, 3, "Red"));
		v.add(new Triangle (9, 8, "White"));
		v.add(new Rectangle (5, 7, "White"));
		
		String shapeType = null;
		
		
	for(int i=0; i < v.size(); i++) {
		if(v.get(i) instanceof Triangle) {
			shapeType = "Triangle";
		}
		if(v.get(i) instanceof Rectangle) {
			shapeType = "Rectangle";
		}
		System.out.println(shapeType + "\t" + ((Shape)v.get(i)).getArea() + "\t" + ((Shape)v.get(i)).getColors());
		}
		
	}
		//System.out.println(v);
		//System.out.println(((Triangle)v.get(0)).getArea());
		
		//System.out.println("기본정보");
	}


	