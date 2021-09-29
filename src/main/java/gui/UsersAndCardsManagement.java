package gui;

import db.Card;
import db.Customer;
import db.DBFunctionsImp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.List;

public class UsersAndCardsManagement {
    static DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();
    static String name;
    static String lastName;
    static int year;
    static int month;
    static int day;
    static LocalDate birthDate;
    static String email;

    public static void execute() {
        new ShowManagementWindow();
        ShowManagementWindow.buttonCreateCard.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    readForm();
                    Customer customerToAddCard = new Customer(0, name, lastName, birthDate, email);
                    dbFunctionsImp.read();
                    for (Customer customer : dbFunctionsImp.dataCustomers.values()) {
                        if (customerToAddCard.equals(customer)) {
                            long newCardNumber = dbFunctionsImp.addCard(customer, LocalDate.now(), LocalDate.now().plusYears(3), true);
                            showCardsOfCustomer(customer);
                            Message.newCardAdded(newCardNumber, name, lastName, customer.getId());
                        }
                    }
                } catch (NumberFormatException ex) {
                    Message.checkBirthdateFields(ex.getLocalizedMessage());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ShowManagementWindow.buttonCreateCustomer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    readForm();
                    if (birthDate.isAfter(LocalDate.now())) {
                        Message.wrongBirthdate();
                    } else {
                        List<Object> result = dbFunctionsImp.addCustomer(name, lastName, birthDate, email);
                        //check if new customer was created
                        boolean isCreated = (boolean) result.get(0);
                        int id = (int) result.get(1);
                        if (isCreated) {
                            Message.newCustomerData(id, name, lastName, birthDate, email);
                        } else {
                            Message.customerAlreadyExists(id, name, lastName, birthDate, email);
                        }
                        Customer customer = dbFunctionsImp.dataCustomers.get(id);
                        showCardsOfCustomer(customer);
                    }
                } catch (Exception ex) {
                    Message.checkBirthdateFields(ex.getLocalizedMessage());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ShowManagementWindow.buttonFindCustomer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    readForm();
                    Customer customerToFind = new Customer(0, name, lastName, birthDate, email);
                    dbFunctionsImp.read();
                    for (Customer customer : dbFunctionsImp.dataCustomers.values()) {
                        if (customer.equals(customerToFind)) {
                            customerToFind = customer;
                            showCardsOfCustomer(customer);
                            Message.customerFound(customer.getId(), customer.getName(), customer.getLastName(), customer.getBirthDate(), customer.getEmail());
                        }
                    }
                    if (customerToFind.getId() == 0) {
                        Message.customerNotFound(name, lastName, birthDate, email);
                    }
                } catch (Exception ex) {
                    Message.checkBirthdateFields(ex.getLocalizedMessage());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private static void readForm() {
        name = ShowManagementWindow.clientName.getText().trim().toUpperCase();
        lastName = ShowManagementWindow.clientLastName.getText().trim().toUpperCase();
        year = Integer.parseInt(ShowManagementWindow.clientBirthDateY.getText().trim());
        month = Integer.parseInt(ShowManagementWindow.clientBirthDateM.getText().trim());
        day = Integer.parseInt(ShowManagementWindow.clientBirthDateD.getText().trim());
        birthDate = LocalDate.of(year, month, day);
        email = ShowManagementWindow.clientEmail.getText().trim().toLowerCase();
    }

    private static void showCardsOfCustomer(Customer customer) {
        StringBuilder cards = new StringBuilder();
        dbFunctionsImp.read();
        for (Card card : dbFunctionsImp.dataCards.values()) {
            if (card.getCustomer().equals(customer)) {
                cards.append(card.getCardNumber()).append("\n");
            }
        }
        ShowManagementWindow.clientCards.setText(String.valueOf(cards));
    }
}
