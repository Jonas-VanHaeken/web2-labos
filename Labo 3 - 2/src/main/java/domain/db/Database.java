package domain.db;

import domain.model.Student;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Database {
    Student greetje = new Student("Jongen", "Greetje", "Toegepaste Informatica", 23);
    Student kristien = new Student("Melaerts", "Kristien", "Chemie", 21);
    Student elke = new Student("Steegmans", "Elke", "Vroedkunde", 16);
    Student jan = new Student("Van Hee", "Jan", "Verpleegkunde", 18);
    ArrayList<Student> students;

    public Database(){
        students = new ArrayList<Student>();
        this.add(greetje);
        this.add(kristien);
        this.add(elke);
        this.add(jan);
    }

    public void add(Student student){
        students.add(student);
    }

    public String zoeken(String voornaam, String achteraam){
       for (Student student:students) {
            if (student.getNaam() == achteraam && student.getVoornaam() == voornaam){
                return "Je vroeg naar volgende gegevens: " + achteraam + " " + voornaam + " (" + student.getLeeftijd() + " jaar): " + student.getStudierichting();
            }
        }
        return "Helaas, de student waarnaar je vraagt is niet gevonden.";
    }

    public static void main(String[] args) {
        Database db = new Database();
        System.out.println(db.zoeken("Jan","Van Hee"));
    }
}
