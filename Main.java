import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, String> loginMap = new HashMap<>();
    public static void main(String[] args) throws Exception {

        // Read login and password information from a text file and store it in the loginMap
        Scanner scanner = new Scanner(new FileReader("src/login_info"));
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(":");
            String login = line[0];
            String password = line[1];
            loginMap.put(login, password);
        }
        scanner.close();

        // Get login from the user
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Login: ");
        String login = inputScanner.nextLine();

        // Authenticate the first 2 letter of login
        BufferedReader reader = new BufferedReader(new FileReader("src/login_info"));
        String read;
        while ((read = reader.readLine()) != null) {
            if (read.startsWith("sg") != login.startsWith("sg")) {
                System.out.println("Invalid country code.");
                return;
            }
        }
        reader.close();

        //Get password from user
        System.out.print("Password: ");
        String password = inputScanner.nextLine();
        inputScanner.close();

        // Check if the login and password are valid
        if (loginMap.containsKey(login) && loginMap.containsValue(password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid login or password.");
        }
    }
}
