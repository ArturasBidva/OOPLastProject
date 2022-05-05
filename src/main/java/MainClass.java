import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainClass main = new MainClass();
        main.getUsersFromJson();
        main.addUser(users, scanner);

    }

    List<User> addUser(List<User> user, Scanner scanner) {
        System.out.println("Iveskite varda:");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde:");
        String surname = scanner.nextLine();
        System.out.println("Iveskite asmens koda:");
        int personnumber = scanner.nextInt();
        User people = new User(name, surname, personnumber);
        users.add(people);
        addUserToJson();
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
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(
                    new File("users.json"),
                    new TypeReference<>() {
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
