public class Student {
    private final String name, surname;
    private int grade;
    private boolean isAttended;

    public Student(String name, String surname, int grade, boolean attended) {
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.isAttended = attended;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setAttended(boolean attended) {
        isAttended = attended;
    }

    public String getAttended() {
        if (isAttended) {
            return " отсутствует";
        }
        return " присутствует";
    }

    @Override
    public String toString() {
        return "Студент - " + name + " " + surname + ". Оценка: " + grade + ". На занятии: " + getAttended() + ".";
    }
}
