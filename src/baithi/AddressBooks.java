package baithi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBooks {
    private static ArrayList<Contactclass> contacts = new ArrayList<>();
    private static Connection connection;


    public static void main(String[] args) throws SQLException {
        connection = DBConnection.getConnection();
        loadContactsFromDatabase();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addNewContact(scanner);
                    break;
                case 2:
                    findContactByName(scanner);
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();

    }



    private static void loadContactsFromDatabase() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Contacts");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String company = resultSet.getString("company");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                contacts.add(new Contactclass(name, company, email, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addNewContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter company: ");
        String company = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        Contactclass contact = new Contactclass(name, company, email, phone);
        contacts.add(contact);

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Contacts (name, company, email, phone) VALUES (?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, company);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void findContactByName(Scanner scanner) {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Contactclass contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Phone: " + contact.getPhone());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }
    }

    private static void displayContacts() {
        for (Contactclass contact : contacts) {
            System.out.println(contact);
        }
    }
}
