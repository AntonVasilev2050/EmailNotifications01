package gui.listeners;

import db.DBFunctionsImp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static gui.UsersAndCardsManagement.showCustomers;

public class CustomersListListener implements MouseListener {
    DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();

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
}
