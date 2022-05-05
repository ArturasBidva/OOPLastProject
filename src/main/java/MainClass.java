import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainClass main = new MainClass();
        main.getUsersFromJson();
        main.call(scanner);

    }
    void callMethod(Scanner scanner) {
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> addUser(users, scanner);
                case "2" -> printUsers();
                case "3" -> System.out.println("Programa baige darba");
                default -> System.out.println("Blogas pasirinkimas");
            }
        }
        void call(Scanner scanner){
            String input;
            do{
                System.out.println("""
                        1.Prideti useri.
                        2.Atspauzdinti userius.
                        3.Baigti darba""");
                callMethod(scanner);
                addUserToJson();
                input = scanner.nextLine();
            }while (!input.equals("3"));
        }
        void printUsers(){
            System.out.println(users);
        }

    List<User> addUser(List<User> user, Scanner scanner) {
        try {
            System.out.println("Iveskite varda:");
            String name = scanner.nextLine();
            System.out.println("Iveskite pavarde:");
            String surname = scanner.nextLine();
            System.out.println("Iveskite asmens koda:");
            int personnumber = scanner.nextInt();
            User people = new User(name, surname, personnumber);
            users.add(people);
        }catch (InputMismatchException e){
            System.out.println("Blogas ivedimas");
        }
        return users;
    }

    public void addUserToJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(Paths.get("users.json").toFile(), users);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<User> getUsersFromJson() {
        Scanner scanner = new Scanner(System.in);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(
                    new File("users.json"),
                    new TypeReference<>() {
                    }
            );
        } catch (RuntimeException | IOException e) {
            call(scanner);
        }
        return users;
    }
}
