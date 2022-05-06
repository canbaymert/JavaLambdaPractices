public class University {

    private String universityName;
    private String department;
    private int population;
    private int gradePointAverage;

    public University() {
    }

    public University(String universityName, String department, int population, int gradePointAverage) {
        this.universityName = universityName;
        this.department = department;
        this.population = population;
        this.gradePointAverage = gradePointAverage;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(int gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                ", department='" + department + '\'' +
                ", population=" + population +
                ", gradePointAverage=" + gradePointAverage +
                '}';
    }
}

