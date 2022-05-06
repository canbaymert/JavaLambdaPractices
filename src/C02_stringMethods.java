import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class C02_stringMethods {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("apple", "orange", "pineapple", "carrot", "strawberry",
                "raspberry", "lemon", "cherry", "pear", "apricot", "apricot", "apricot"));
        UppercaseNonRepetitive(menu);
        System.out.println();
        sortComparingLength(menu);
        System.out.println();
        reverseSortComparingLastLetter(menu);
        System.out.println();
        listLengthControl(menu);
        System.out.println();
        printThreeLargeElements(menu);
        System.out.println();
        printTheLargestElement(menu);
        System.out.println();
    }


    public static void UppercaseNonRepetitive(List<String> menu) {
        menu.
                stream().
                map(String::toUpperCase).
                sorted(). // put in an order
                distinct(). // ignore the repetition
                forEach(t -> System.out.print(t + " "));

    }

    public static void sortComparingLength(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t -> System.out.print(t + " "));
    }

    public static void reverseSortComparingLastLetter(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).
                        reversed()).
                forEach(t -> System.out.print(t + " "));

    }

    public static void listLengthControl(List<String> menu) {
        System.out.println(menu.
                stream().
                allMatch(t -> t.length() <= 7) ? "All list elements have a smaller length than 7" :
                "Some list elements have a larger length than 7");
        //anyMatch() --> returns true if at least one element matches with the given term
        //allMatch() --> returns true if at least all element matches with the given term
        //noneMatch()--> returns true if none of the elements matches with the given term
    }

    public static void printThreeLargeElements(List<String> menu) {
        Stream<String> lastThree = menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                limit(3);  //limits the output with 3 elements (in stream form)
        System.out.println(Arrays.toString(lastThree.toArray())); //stream to array then array to string.
    }

    public static void printTheLargestElement(List<String> menu) {
        // max() and get() methods
        System.out.println(menu.
                stream().
                max(Comparator.comparing(String::length)).
                get());


        // Limit method
        System.out.println(Arrays.toString(menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                limit(1).toArray()));

        // Find first() method (Uses Optional class)
        System.out.println(menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst());
    }
}

