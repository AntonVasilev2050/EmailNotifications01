package gui.listeners;

import db.Customer;
import db.DBFunctionsImp;
import gui.ShowMessage;
import gui.UsersAndCardsManagement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.List;

import static gui.UsersAndCardsManagement.*;

public class CreateCustomerListener implements MouseListener {
    DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            readForm();
            if (UsersAndCardsManagement.getBirthDate().isAfter(LocalDate.now())) {
                ShowMessage.wrongBirthdate();
            } else {
                List<Object> result = dbFunctionsImp.addCustomer(
                        UsersAndCardsManagement.getName(),
                        UsersAndCardsManagement.getLastName(),
                        UsersAndCardsManagement.getBirthDate(),
                        UsersAndCardsManagement.getEmail());
                //check if new customer was created
                boolean isCreated = (boolean) result.get(0);
                int id = (int) result.get(1);
                if (isCreated) {
                    Customer customer = dbFunctionsImp.dataCustomers.get(id);
                    showCardsOfCustomer(customer);
                    showCustomers();
                    ShowMessage.newCustomerData(
                            id,
                            UsersAndCardsManagement.getName(),
                            UsersAndCardsManagement.getLastName(),
                            UsersAndCardsManagement.getBirthDate(),
                            UsersAndCardsManagement.getEmail());
                } else {
                    ShowMessage.customerAlreadyExists(
                            id,
                            UsersAndCardsManagement.getName(),
                            UsersAndCardsManagement.getLastName(),
                            UsersAndCardsManagement.getBirthDate(),
                            UsersAndCardsManagement.getEmail());
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
}
