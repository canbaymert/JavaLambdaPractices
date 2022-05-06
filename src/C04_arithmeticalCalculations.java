import java.util.stream.IntStream;

public class C04_arithmeticalCalculations {
    public static void main(String[] args) {
        System.out.println("TASK 01 Sum (1-10) --> " + sum(10));
        System.out.println();

        System.out.println("TASK 02 Sum Evens (1-10) --> " + sumEvens(10));//2+4+6+8+10 =30
        System.out.println();

        System.out.println("TASK 03 Sum First X Evens (10) --> " + sumFirstXEvens(10));//2+4+6+...+18+20=110
        System.out.println();

        System.out.println("TASK 04 Sum First X Odds (10) --> " + sumFirstXOdds(10));//1+3+5+...+19=100
        System.out.println();

        System.out.print("TASK 05 First X Powers of Two (5) --> ");
        firstXPowsofTwo(7);
        System.out.println();
        System.out.println();

        System.out.print("TASK 06 First X Powers of Given Num (4,3) --> ");
        firstXPowsofNum(4, 3);
        System.out.println();
        System.out.println();

        System.out.println("TASK 07 Factorial of X (5) --> " + factorialofX(5));//1*2*3*...*5=120
        System.out.println();

        System.out.println("TASK 08 x Power of Given Num (4,3) --> " + xPowofNum(4, 3));//64
        System.out.println();

    }


    public static int sum(int x) {
        return IntStream.range(1, x + 1).// from 1 to x
                sum();
    }

    public static int sumEvens(int x) {
        return IntStream.rangeClosed(1, x).// from 1 to x
                filter(C01_methods::findEvens).sum();
    }


    public static int sumFirstXEvens(int x) {
        return IntStream.iterate(2, t -> t + 2).//streams from 2 to inf -->2,4,6,8,10...
                limit(x).//first x elements of stream
                sum();
    }


    public static int sumFirstXOdds(int x) {
        return IntStream.iterate(1, t -> t + 2).//streams from 1 to inf +2 -->1,3,5,7,9...
                limit(x).//first x elements of stream
                sum();

    }


    public static void firstXPowsofTwo(int x) {
        IntStream.iterate(2, t -> t * 2).//streams from 2 to inf +2 -->2,4,8,16,32...
                limit(x). //first x elements of stream
                forEach(C01_methods::print); // sums and prints


    }


    public static void firstXPowsofNum(int num, int x) {
        IntStream.iterate(num, t -> t * num).////streams from 2 to inf *2 -->2,4,8,16,32...
                limit(x).//first x elements of stream
                forEach(C01_methods::print); // sums and prints

    }


    public static int factorialofX(int x) {
        return IntStream.rangeClosed(1, x). //from 1 to x
                //reduce(Math::multiplyExact).   (Alternative)
                        reduce(1, (t, u) -> t * u); // sum of x factorial
    }

    public static int xPowofNum(int num, int x) {
        return IntStream.iterate(num, t -> t * num). // streams inf pow of num --> num*num*num*...
                // Math.pow(num,x); (Alternative)
                        limit(x).reduce(0, (t, u) -> u);

    }

}

