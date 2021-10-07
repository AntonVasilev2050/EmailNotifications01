package gui.listeners;

import db.Customer;
import db.DBFunctionsImp;
import gui.ShowMessage;
import gui.UsersAndCardsManagement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static gui.UsersAndCardsManagement.readForm;
import static gui.UsersAndCardsManagement.showCardsOfCustomer;

public class FindCustomerListener implements MouseListener {
    DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            readForm();
            Customer customerToFind = new Customer(
                    0,
                    UsersAndCardsManagement.getName(),
                    UsersAndCardsManagement.getLastName(),
                    UsersAndCardsManagement.getBirthDate(),
                    UsersAndCardsManagement.getEmail());
            dbFunctionsImp.read();
            for (Customer customer : dbFunctionsImp.dataCustomers.values()) {
                if (customer.equals(customerToFind)) {
                    customerToFind = customer;
                    showCardsOfCustomer(customer);
                    ShowMessage.customerFound(customer.getId(), customer.getName(), customer.getLastName(), customer.getBirthDate(), customer.getEmail());
                }
            }
            if (customerToFind.getId() == 0) {
                ShowMessage.customerNotFound(
                        UsersAndCardsManagement.getName(),
                        UsersAndCardsManagement.getLastName(),
                        UsersAndCardsManagement.getBirthDate(),
                        UsersAndCardsManagement.getEmail());
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
}
