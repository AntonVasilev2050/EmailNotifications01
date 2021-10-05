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
        showCustomers();
        ShowManagementWindow.buttonCreateCard.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    readForm();
                    Customer customerToAddCard = new Customer(0, name, lastName, birthDate, email);
                    dbFunctionsImp.read();
                    for (Customer customer : dbFunctionsImp.dataCustomers.values()) {
                        if (customerToAddCard.equals(customer)) {
//                            long newCardNumber = dbFunctionsImp.addCard(customer, LocalDate.now(), LocalDate.now().plusYears(3), true);
                            long newCardNumber = dbFunctionsImp.addCard(customer, LocalDate.now().minusYears(3), LocalDate.now().minusDays(2), true);
                            showCardsOfCustomer(customer);
                            ShowMessage.newCardAdded(newCardNumber, name, lastName, customer.getId());
                        }
                    }
                } catch (NumberFormatException ex) {
                    ShowMessage.checkFields(ex.getLocalizedMessage());
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
                        ShowMessage.wrongBirthdate();
                    } else {
                        List<Object> result = dbFunctionsImp.addCustomer(name, lastName, birthDate, email);
                        //check if new customer was created
                        boolean isCreated = (boolean) result.get(0);
                        int id = (int) result.get(1);
                        if (isCreated) {
                            Customer customer = dbFunctionsImp.dataCustomers.get(id);
                            showCardsOfCustomer(customer);
                            showCustomers();
                            ShowMessage.newCustomerData(id, name, lastName, birthDate, email);
                        } else {
                            ShowMessage.customerAlreadyExists(id, name, lastName, birthDate, email);
                        }

                    }
                } catch (Exception ex) {
                    ShowMessage.checkFields(ex.getLocalizedMessage());
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
                            ShowMessage.customerFound(customer.getId(), customer.getName(), customer.getLastName(), customer.getBirthDate(), customer.getEmail());
                        }
                    }
                    if (customerToFind.getId() == 0) {
                        ShowMessage.customerNotFound(name, lastName, birthDate, email);
                    }
                } catch (Exception ex) {
                    ShowMessage.checkFields(ex.getLocalizedMessage());
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

        ShowManagementWindow.buttonCloseCard.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Long cardToClose = null;
                String s = "";
                try {
                    s = ShowMessage.closeCard().trim();
                    cardToClose = Long.parseLong(s);
                    dbFunctionsImp.dataCards.get(cardToClose).setActive(false);
                    dbFunctionsImp.write(dbFunctionsImp.dataCustomers, dbFunctionsImp.dataCards);
//                    showCardsOfCustomer();
                } catch (NumberFormatException ex) {
                    ShowMessage.checkFields(ex.getLocalizedMessage());
                } catch (NullPointerException npe) {
                    ShowMessage.cardNotFound(s);
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

        ShowManagementWindow.buttonCustomersList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showCustomers();
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
        name = ShowManagementWindow.customerName.getText().trim().toUpperCase();
        lastName = ShowManagementWindow.customerLastName.getText().trim().toUpperCase();
        year = Integer.parseInt(ShowManagementWindow.customerBirthDateY.getText().trim());
        month = Integer.parseInt(ShowManagementWindow.customerBirthDateM.getText().trim());
        day = Integer.parseInt(ShowManagementWindow.customerBirthDateD.getText().trim());
        birthDate = LocalDate.of(year, month, day);
        email = ShowManagementWindow.customerEmail.getText().trim().toLowerCase();
    }

    private static void showCardsOfCustomer(Customer customer) {
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

    private static void showCustomers() {
        ShowManagementWindow.customersList.setText("");
        ShowManagementWindow.customersList.append("      Список клиентов \n ");
        dbFunctionsImp.read();
        for (Customer customer : dbFunctionsImp.dataCustomers.values()) {
            ShowManagementWindow.customersList.append(customer + " \n ");
        }
        ShowManagementWindow.customersList.repaint();
    }
}
