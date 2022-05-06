import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C04_universityMain {
    public static void main(String[] args) {
        University unv1 = new University("Cambridge", "Computer Engineering", 256, 52);
        University unv2 = new University("Harvard", "Maths", 322, 77);
        University unv3 = new University("Stanford", "Physics", 109, 83);
        University unv4 = new University("Oxford", "Electrical Engineering", 287, 74);
        University unv5 = new University("Ege", "Mechanical Engineering", 99, 88);
        List<University> uniList = new ArrayList<University>(Arrays.asList(unv1, unv2, unv3, unv4, unv5));

        gradePointAverageControl(uniList);
        System.out.println("=======");
        populationControl(uniList);
        System.out.println("=======");
        DepartmentControl(uniList);
        System.out.println("=======");
        sortPopulation(uniList);
        System.out.println("=======");
        sortGradePointAverage(uniList);
        System.out.println("=======");
        theSecondLeastPopulation(uniList);
        System.out.println("=======");
        totalPopulationOfUniversitiesWith63GPA(uniList);
        System.out.println("=======");
        AverageofGPAsofUniversitiesWith130Population(uniList);
        System.out.println("=======");
        numberofMathsDepartments(uniList);
        System.out.println("=======");
        theBiggestGPAof130Population(uniList);
        System.out.println("=======");
        minimumGPAof150Population(uniList);
    }

    private static void print(University u) {

        System.out.printf("%-20s %-25s %-20d %-20d\n", u.getUniversityName(), u.getDepartment(), u.getPopulation(), u.getGradePointAverage());
    }


    public static void gradePointAverageControl(List<University> uniList) {
        System.out.println("Task 1 : Universities that have higher grade point average than 74 : ");
        System.out.printf("%-20s %-25s %-20s %-20s\n", "University", "Department", "Population", "Grade Point Average");
        uniList.
                stream().
                filter(t -> t.getGradePointAverage() > 74).
                forEach(C04_universityMain::print);
    }


    public static void populationControl(List<University> uniList) {
        System.out.println("Task 2 : Universities that have higher population than 110 : ");
        System.out.printf("%-20s %-25s %-20s %-20s\n", "University", "Department", "Population", "Grade Point Average");
        uniList.
                stream().
                filter(t -> t.getPopulation() > 110).
                forEach(C04_universityMain::print);
    }


    public static void DepartmentControl(List<University> uniList) {
        System.out.println("Task 3 : Universities that has Maths Department : ");
        System.out.printf("%-20s %-25s %-20s %-20s\n", "University", "Department", "Population", "Grade Point Average");
        uniList.
                stream().
                filter(t -> t.getDepartment().equalsIgnoreCase("Maths")).
                forEach(C04_universityMain::print);
    }


    public static void sortPopulation(List<University> uniList) {
        System.out.println("Task 4 : Universities that are sorted by population : ");
        System.out.printf("%-20s %-25s %-20s %-20s\n", "University", "Department", "Population", "Grade Point Average");
        uniList.
                stream().
                sorted(Comparator.comparingInt(University::getPopulation).reversed()).
                forEach(C04_universityMain::print);

    }


    public static void sortGradePointAverage(List<University> uniList) {
        System.out.println("Task 5 : Top three universities that are sorted by grade point average :");
        System.out.printf("%-20s %-25s %-20s %-20s\n", "University", "Department", "Population", "Grade Point Average");
        uniList.
                stream().
                sorted(Comparator.comparingInt(University::getGradePointAverage)).
                skip(2).sorted(Comparator.comparingInt(University::getGradePointAverage).reversed()).
                forEach(C04_universityMain::print);

    }


    public static void theSecondLeastPopulation(List<University> uniList) {
        System.out.println("Task 6 : University with the second-least population : ");
        System.out.println(uniList.
                stream().
                sorted(Comparator.comparingInt(University::getPopulation)).skip(1).findFirst().get());

    }


    public static void totalPopulationOfUniversitiesWith63GPA(List<University> uniList) {
        System.out.println("Task 7 : Total population of universities with 63GPA : ");
        System.out.println(
                uniList.
                        stream().
                        filter(t -> t.getGradePointAverage() > 63).
                        map(University::getPopulation).reduce(Integer::sum).get());

    }

    public static void AverageofGPAsofUniversitiesWith130Population(List<University> uniList) {
        System.out.println("Task 8 : Average of GPAs of universities with 130 or more population : ");
        System.out.println(
                uniList.
                        stream().
                        filter(t -> t.getPopulation() > 130).
                        mapToInt(University::getGradePointAverage).average().getAsDouble());

    }

    public static void numberofMathsDepartments(List<University> uniList) {
        System.out.println("Task 9 : Number of Universities with Maths department : ");
        System.out.println(
                uniList.
                        stream().
                        filter(t -> t.getDepartment().equalsIgnoreCase("Maths")).
                        count());

    }


    public static void theBiggestGPAof130Population(List<University> uniList) {
        System.out.println("Task 10 : Find the university with greatest GPA between the universities with a population of 130 or higher : ");
        System.out.println(
                uniList.
                        stream().
                        filter(t -> t.getPopulation() >= 130).
                        max(Comparator.comparingInt(University::getGradePointAverage)).get());

    }


    public static void minimumGPAof150Population(List<University> uniList) {
        System.out.println("Find the university with greatest GPA between the universities with a population of 150 or lower : ");
        System.out.println(
                uniList.
                        stream().
                        filter(t -> t.getPopulation() <= 150).
                        min(Comparator.comparingInt(University::getGradePointAverage)).get());
    }
}

