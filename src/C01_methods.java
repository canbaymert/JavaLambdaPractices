import java.util.*;

public class C01_methods {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));
        printNums(numbers);
        System.out.println();
        printNumsFunctional(numbers);
        System.out.println();
        printEvens(numbers);
        System.out.println();
        printEvensandBiggerThan34(numbers);
        System.out.println();
        printSquareOfEvens(numbers);
        System.out.println();
        printSquareRootOfEvens(numbers);
        System.out.println();
        printMaxNum(numbers);
        System.out.println();
        printMaxofEvenSquares(numbers);
        System.out.println();
        multiplyEven(numbers);
        System.out.println();
        printMinNum(numbers);
        System.out.println();
        printSquareofOdds(numbers);
        System.out.println();

    }

    // Classic Method
    public static void printNums(List<Integer> num) {
        for (Integer each : num) {
            System.out.print(each + " ");
        }
    }

    // Functional Method
    public static void printNumsFunctional(List<Integer> num) {
        num.stream().forEach((t) -> System.out.print(t + " "));
        // num.stream().forEach(System.out::print); (Alternative print method)
    }

    public static void print(int a) {// verilen int degeri aynı satırda bosluk bırakarak yazdırma action yapan seed(tohum) method create edildi
        System.out.print(a + " ");
    }

    public static void printEvens(List<Integer> num) {
        num.
                stream().
                filter(t -> t % 2 == 0). //filters the required members of the list
                forEach(C01_methods::print);

    }

    public static boolean findEvens(int a) {
        return a % 2 == 0;
    }

    public static void printEvensandBiggerThan34(List<Integer> num) {
        num.stream().
                filter(C01_methods::findEvens).
                filter(t -> t > 34).
                forEach(C01_methods::print);
        // filter(t -> t % 2 == 0 && t > 34). could be used also
    }

    public static void printSquareOfEvens(List<Integer> num) {
        num.
                stream().
                filter(C01_methods::findEvens).
                map(t -> t * t). //changes value of a member of a stream.
                forEach(C01_methods::print);
    }
    public static void printSquareRootOfEvens(List<Integer> num) {
        num.
                stream().
                filter(C01_methods::findEvens).
                map(Math::sqrt).
                        forEach(t -> System.out.print(t + " "));
    }

    public static void printMaxNum(List<Integer> num) {
        Optional<Integer> maxNum = num.stream().reduce(Math::max); //reduces the members of the stream to one element after the action
        System.out.println(maxNum);
        // System.out.println(num.stream().reduce(Math::max));  (Alternative solution)

    }
    public static void printMaxofEvenSquares(List<Integer> num) {

        System.out.println(num.stream().filter(C01_methods::findEvens).map(t -> t * t).reduce(Math::max));
       // System.out.println(num.stream().filter(C01_methods::findEvens).map(t -> t * t).reduce(Integer::max)); (Alternative solution)
    }
    public static void multiplyEven(List<Integer> num) {
    System.out.println("Method Reference :" + num.stream().filter(C01_methods::findEvens).reduce(Math::multiplyExact));
    System.out.println("Lambda Expression : " + num.stream().filter(C01_methods::findEvens).reduce(1, (a, b) -> (a * b)));
    }
    public static void printMinNum (List<Integer> num) {
        // 1st solution - with Integer class
        Optional<Integer> minNumInt = num.stream().reduce(Integer::min);
        System.out.println(minNumInt);
        // 2nd solution - with Math class
        Optional<Integer> minNumMath = num.stream().reduce(Math::min);
        System.out.println(minNumMath);
        // 3rd solution - with Lambda Expression
        int minNumLambda = (num.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));
        System.out.println(minNumLambda);
        // 4th solution with Method Reference
        Optional<Integer> minNum = num.stream().reduce(C01_methods::findMin);
        System.out.println(minNum);
    }
    public static int findMin(int a, int b) {//bu method kendisine verilen iki int degerin en kücügunu return eder
        return a < b ? a : b;
    }

    public static void printSquareofOdds(List<Integer> num) {
        num.
                stream().
                filter(t->t%2!=0). // filtered the odd numbers
                map(t->t*t). // square of the filtered odd numbers are taken
                sorted(Comparator.reverseOrder()).// sorted() makes natural order we did the opposite of it.
                forEach(C01_methods::print); // result is printed.
    }
}
