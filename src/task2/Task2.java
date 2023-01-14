package task2;

import java.io.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String[] circle = readFile(args[0]);
        String[] points = readFile(args[1]);

        float o1 = Float.parseFloat(circle[0]);
        float o2 = Float.parseFloat(circle[1]);
        float r = Float.parseFloat(circle[2]);

        for (int i = 0; i < points.length; i=i+2) {
            System.out.println(doCulc(o1,o2,Float.parseFloat(points[i]), Float.parseFloat(points[i+1]), r));
        }
    }

    public static String doCulc(float o1, float o2, float x1, float y2, float r){
        double distance = Math.sqrt(Math.pow((x1-o1), 2) + Math.pow((y2-o2),2));
        if(Math.abs(distance - r) < 0.0001){
            return "0";
        }else if (distance < r){
            return "1";
        }
        return "2";
    }

    public static String[] readFile(String arg) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(arg));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNext())
            stringBuilder.append(scanner.next() + " ");

        String[] lines = stringBuilder.toString().split(" ");
        return lines;
    }
}
