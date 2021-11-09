package gui.listeners;

import db.Customer;
import db.DBFunctionsImp;
import gui.ShowMessage;
import gui.UsersAndCardsManagement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import static gui.UsersAndCardsManagement.readForm;
import static gui.UsersAndCardsManagement.showCardsOfCustomer;

public class CreateCardListener implements MouseListener {
    DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            readForm();
            Customer customerToAddCard = new Customer(0,
                    UsersAndCardsManagement.getName(),
                    UsersAndCardsManagement.getLastName(),
                    UsersAndCardsManagement.getBirthDate(),
                    UsersAndCardsManagement.getEmail());
            dbFunctionsImp.read();
            for (Customer customer : dbFunctionsImp.dataCustomers.values()) {
                if (customerToAddCard.equals(customer)) {
//                            long newCardNumber = dbFunctionsImp.addCard(
//                                    customer,
//                                    LocalDate.now(),
//                                    LocalDate.now().plusYears(3),
//                                    true);
                    long newCardNumber = dbFunctionsImp.addCard(
                            customer,
                            LocalDate.now().minusYears(3),
                            LocalDate.now().minusDays(2),
                            true);
                    showCardsOfCustomer(customer);
                    ShowMessage.newCardAdded(
                            newCardNumber,
                            UsersAndCardsManagement.getName(),
                            UsersAndCardsManagement.getLastName(),
                            customer.getId());
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
}
