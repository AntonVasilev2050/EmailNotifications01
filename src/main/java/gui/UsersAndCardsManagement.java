package gui;

import db.Card;
import db.Customer;
import db.DBFunctionsImp;
import gui.listeners.*;

import java.time.LocalDate;

public class UsersAndCardsManagement {
    static DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();
    static String name;
    static String lastName;
    static int year;
    static int month;
    static int day;
    static LocalDate birthDate;
    static String email;

    public static String getName() {
        return name;
    }

    public static String getLastName() {
        return lastName;
    }

    public static LocalDate getBirthDate() {
        return birthDate;
    }

    public static String getEmail() {
        return email;
    }

    public static void execute() {
        new ShowManagementWindow();
        showCustomers();
        ShowManagementWindow.buttonCreateCard.addMouseListener(new CreateCardListener());
        ShowManagementWindow.buttonCreateCustomer.addMouseListener(new CreateCustomerListener());
        ShowManagementWindow.buttonFindCustomer.addMouseListener(new FindCustomerListener());
        ShowManagementWindow.buttonCloseCard.addMouseListener(new CloseCardListener());
        ShowManagementWindow.buttonCustomersList.addMouseListener(new CustomersListListener());
    }

    public static void readForm() {
        name = ShowManagementWindow.customerName.getText().trim().toUpperCase();
        lastName = ShowManagementWindow.customerLastName.getText().trim().toUpperCase();
        year = Integer.parseInt(ShowManagementWindow.customerBirthDateY.getText().trim());
        month = Integer.parseInt(ShowManagementWindow.customerBirthDateM.getText().trim());
        day = Integer.parseInt(ShowManagementWindow.customerBirthDateD.getText().trim());
        birthDate = LocalDate.of(year, month, day);
        email = ShowManagementWindow.customerEmail.getText().trim().toLowerCase();
    }

    public static void showCardsOfCustomer(Customer customer) {
        StringBuilder cards = new StringBuilder();
        dbFunctionsImp.read();
        for (Card card : dbFunctionsImp.dataCards.values()) {
            if (card.getCustomer().equals(customer)) {
                if (!card.isActive()) {
                    cards.append(card.getCardNumber()).append(" - closed\n");
                } else {
                    cards.append(card.getCardNumber()).append("\n");
                }
            }
        }
        ShowManagementWindow.customerCards.setText(String.valueOf(cards));
    }

    public static void showCustomers() {
        ShowManagementWindow.customersList.setText("");
        ShowManagementWindow.customersList.append("      Список клиентов \n ");
        dbFunctionsImp.read();
        for (Customer customer : dbFunctionsImp.dataCustomers.values()) {
            ShowManagementWindow.customersList.append(customer + " \n ");
        }
        ShowManagementWindow.customersList.repaint();
    }
}
