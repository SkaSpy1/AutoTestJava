package lesson4HW;
public class AreaTriangle{


    private static ArithmeticException arithmeticException = new ArithmeticException("Указана некорректная длина стороны треугольника");

        public static double calcTheAreaOfTriangle (double sideA, double sideB, double sideC)throws ArithmeticException, NullPointerException
     {
        if (sideA < 0 || sideB < 0 || sideC < 0) throw new ArithmeticException();
        double p = (sideA + sideB + sideC) / 2;
        double square = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        System.out.println("Площадь треугольника равна:" + square);
        return square;
    }
    }



