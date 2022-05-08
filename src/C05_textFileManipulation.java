import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C05_textFileManipulation {

    public static void main(String[] args) throws IOException {

        System.out.println("\nTASK 01 --> Read the fileText.txt -->  ");

        Path fileText = Path.of("src/fileText");// path is defined
        Stream<String> stream = Files.lines(fileText);// data of file added to stream

        // 1st method
        stream.//can be operated once with the name of stream (stream) in one runtime, throws exception on second use
                forEach(System.out::println);
        //Files.lines(Paths.get("src/fileText"))..forEach(System.out::println); (Alternative)

        System.out.println("\nTASK 02 --> Convert the text to the uppercase -->  ");

        Files.lines(Paths.get("src/fileText")).
                map(String::toUpperCase).// Stream data converted to the uppercase
                forEach(System.out::println);

        System.out.println("\nTASK 03 --> Print the first line of fileText.txt with the lowercase -->  ");
        //1st method
        Files.lines(fileText).
                map(String::toLowerCase).
                limit(1).
                forEach(System.out::println);

        //2nd method (Optional class)
        System.out.println(Files.lines(fileText).
                map(String::toLowerCase).
                findFirst());


        System.out.println("\nTASK 04 --> Print the number of usages of the word 'end' in the fileText.txt  -->  ");
        System.out.println(Files.lines(fileText).
                map(String::toLowerCase).
                filter(t -> t.contains("end")).
                count());  //fails if a word includes the word in itself. (Example: tender)
        // 2nd method
        System.out.println(Files.lines(fileText).
                map(t -> t.toLowerCase().split(" ")). // all lines added to a 2D array
                flatMap(Arrays::stream). // 2D array converted to 1D array to stream all words one by one
                filter(t -> t.equals("end")).
                count());

        System.out.println("\nTASK 05 --> Print the unique words in the fileText.txt -->  ");

        //1st method
        System.out.println(Files.lines(fileText).
                map(t -> t.split(" ")). //words of fileText added to an Array
                        flatMap(Arrays::stream).//array converted to a stream
                        distinct().//repetition is ignored
                        collect(Collectors.toList()));//elements are added to a list

        //2nd method
        System.out.println(Files.lines(fileText).
                map(t -> t.split(" ")).//words of fileText added to an Array
                        flatMap(Arrays::stream).//array converted to a stream
                        collect(Collectors.toSet()));//stream converted to a set which ignores the repetition naturally.

        System.out.println("\nTASK 06 --> Print the unique words in fileText in natural order -->  ");
        Files.lines(fileText).
                map(t -> t.split(" ")).//words of fileText added to an Array
                flatMap(Arrays::stream).//array converted to a stream
                sorted().// sorted in natural order
                distinct().//repetition is ignored
                forEach(System.out::println);


        System.out.println("\nTASK 08 --> Print the number of the words including the letter 'a' in fileText.txt --> ");
        System.out.println(Files.lines(fileText).
                map(t -> t.split(" ")).//words of fileText added to an Array
                        flatMap(Arrays::stream).//array converted to a stream
                        filter(t -> t.contains("a")).//filters the words that include the letter 'a'
                        count());//counted

        System.out.println("\nTASK 09 --> Print the words including the letter 'a' in fileText.txt -->  ");
        System.out.println(Files.lines(fileText).
                map(t -> t.split(" ")).//words of fileText added to an Array
                        flatMap(Arrays::stream).//array converted to a stream
                        filter(t -> t.contains("a")).//filters the words that include the letter 'a'
                        collect(Collectors.toList())); //the words that include the letter 'a' added to a list


        System.out.println("\nTASK 10 --> Print the number of the different letters are used in the fileText.txt --> ");
        System.out.println(Files.lines(fileText).
                map(t -> t.replaceAll("\\W", "").//characters instead of a-z A-Z 0-9 are removed
                        replaceAll("\\d", ""). //numbers are removed
                        split("")).//all letters added to an array
                        flatMap(Arrays::stream). //array converted to a stream
                        distinct(). //the repetition is ignored
                        count()); //counted

        System.out.println("\nTASK 11 --> Print the number of the different words are used in the fileText.txt -->  ");
        System.out.println(Files.lines(fileText).
                map(t -> t.replaceAll("[.!,:)\\-]", ""). // special characters are removed
                        split(" ")).//all words added to an array
                        flatMap(Arrays::stream). //array converted to a stream
                        distinct(). //the repetition is ignored
                        count()); //counted

        System.out.println("\nTASK 12 --> Print the different words are used in the fileText.txt --> -->  ");
        Files.lines(fileText).
                map(t -> t.replaceAll("[.!,:)\\-]", ""). // special characters are removed
                        split(" ")). //all words added to an array
                flatMap(Arrays::stream). //array converted to a stream
                distinct(). //the repetition is ignored
                forEach(System.out::println);
    }
}