package gui.listeners;

import db.DBFunctionsImp;
import gui.ShowMessage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CloseCardListener implements MouseListener {
    DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();

    @Override
    public void mouseClicked(MouseEvent e) {
        long cardToClose;
        String s;
        try {
            s = ShowMessage.closeCard().trim();
            cardToClose = Long.parseLong(s);
            boolean cardIsClosed = dbFunctionsImp.setCardClosed(cardToClose);
            if(!cardIsClosed){
                ShowMessage.cardNotFound(s);
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
