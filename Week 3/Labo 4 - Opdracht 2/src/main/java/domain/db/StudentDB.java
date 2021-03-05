package domain.db;

import domain.model.Student;

import java.util.ArrayList;

public class StudentDB {
    Student greetje = new Student("Jongen", "Greetje", "Toegepaste Informatica", 23);
    Student kristien = new Student("Melaerts", "Kristien", "Chemie", 21);
    Student elke = new Student("Steegmans", "Elke", "Vroedkunde", 16);
    Student jan = new Student("Van Hee", "Jan", "Verpleegkunde", 18);

    private ArrayList<Student> students;

    public StudentDB(){
        students = new ArrayList<Student>();
        this.add(greetje);
        this.add(kristien);
        this.add(elke);
        this.add(jan);
    }

    public void add(Student student){
        students.add(student);
    }

    public ArrayList<Student> getList(){
        return students;
    }

    public String zoeken(String voornaam, String achternaam){
       for (Student student:students) {
            if (student.getNaam().equals(achternaam) && student.getVoornaam().equals(voornaam)){
                return "Je vroeg naar volgende gegevens: " + achternaam + " " + voornaam + " (" + student.getLeeftijd() + " jaar): " + student.getStudierichting();
            }
        }
        return null;
    }
}
