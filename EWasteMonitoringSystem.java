import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class CollectionRequest {
    String user;
    String description;
    String status;

    CollectionRequest(String user, String description) {
        this.user = user;
        this.description = description;
        this.status = "Pending";
    }
}

class RecyclingCenter {
    String name;
    String contact;

    RecyclingCenter(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
}

public class EWasteMonitoringSystem {
    private static Map<String, User> users = new HashMap<>();
    private static List<CollectionRequest> requests = new ArrayList<>();
    private static List<RecyclingCenter> recyclingCenters = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static JFrame frame = new JFrame();  // Invisible JFrame for dialogs

    public static void main(String[] args) {
        frame.setUndecorated(true);  // Hide the title bar and borders
        frame.setVisible(true);      // Make the frame visible
        frame.setLocationRelativeTo(null);  // Center the frame on the screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeRecyclingCenters();
        while (true) {
            System.out.println("E-waste Monitoring System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    frame.dispose();  // Close the JFrame when exiting
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeRecyclingCenters() {
        recyclingCenters.add(new RecyclingCenter("EcoRecycle India Pvt Ltd", "080-1234-5678"));
        recyclingCenters.add(new RecyclingCenter("Green Earth Recycling Solutions", "022-9876-5432"));
        recyclingCenters.add(new RecyclingCenter("SustainRecyclers", "040-8765-4321"));
        recyclingCenters.add(new RecyclingCenter("CleanTech Recycling Services", "011-7654-3210"));
        recyclingCenters.add(new RecyclingCenter("E-Waste Solutions India", "033-6543-2109"));
    }

    private static void register() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        String password = readPassword("Enter password: ");
        users.put(username, new User(username, password));
        System.out.println("Registration successful.");
    }

    private static void login() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        String password = readPassword("Enter password: ");

        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            System.out.println("Login successful.");
            userMenu(username);
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static void userMenu(String username) {
        while (true) {
            System.out.println("1. Request E-waste Collection");
            System.out.println("2. Track Requests");
            System.out.println("3. View Recycling Centers");
            System.out.println("4. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    requestCollection(username);
                    break;
                case 2:
                    trackRequests();
                    break;
                case 3:
                    viewRecyclingCenters();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void requestCollection(String username) {
        System.out.println("Enter e-waste description:");
        String description = scanner.nextLine();
        requests.add(new CollectionRequest(username, description));
        System.out.println("Collection request submitted.");
    }

    private static void trackRequests() {
        if (requests.isEmpty()) {
            System.out.println("No collection requests found.");
            return;
        }
        for (CollectionRequest request : requests) {
            System.out.println("User: " + request.user + ", Description: " + request.description + ", Status: " + request.status);
        }
    }

    private static void viewRecyclingCenters() {
        if (recyclingCenters.isEmpty()) {
            System.out.println("No recycling centers available.");
            return;
        }
        for (RecyclingCenter center : recyclingCenters) {
            System.out.println("Name: " + center.name + ", Contact: " + center.contact);
        }
    }

    private static String readPassword(String prompt) {
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(frame, pf, prompt, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            return new String(pf.getPassword());
        } else {
            return "";
        }
    }
}
