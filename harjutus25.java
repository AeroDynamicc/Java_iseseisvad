import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class harjutus25 {
    public static void main(String[] args) {
        String fileName = "students.csv"; // Failinimi
        int totalStudents = countStudents(fileName);
        System.out.println("Kokku on nimekirjas " + totalStudents + " õpilast.");

        System.out.println("Esimesed 10 õpilast:");
        displayFirstNStudents(fileName, 10);
    }

    // Meetod õpilaste arvu lugemiseks CSV-failist
    public static int countStudents(String fileName) {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    // Meetod esimese N õpilase kuvamiseks CSV-failist
    public static void displayFirstNStudents(String fileName, int n) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;
            // Loe failiridasid, kuni jõutakse faili lõpuni või on kuvatud esimesed N õpilast
            while ((line = br.readLine()) != null && count < n) {
                System.out.println(line);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
