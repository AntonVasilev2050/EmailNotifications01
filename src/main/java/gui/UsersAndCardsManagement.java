package gui;

import db.DBFunctionsImp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UsersAndCardsManagement {
    static DBFunctionsImp dbFunctionsImp = new DBFunctionsImp();

    public static void execute() {
        new ShowWindow();
        ShowWindow.buttonCreateCustomer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = ShowWindow.userName.getText().trim().toUpperCase();
                String lastName = ShowWindow.userLastName.getText().trim().toUpperCase();
                int year;
                int month;
                int day;
                LocalDate birthDate;
                try {
                    year = Integer.parseInt(ShowWindow.userBirthDateY.getText().trim());
                    month = Integer.parseInt(ShowWindow.userBirthDateM.getText().trim());
                    day = Integer.parseInt(ShowWindow.userBirthDateD.getText().trim());
                    birthDate = LocalDate.of(year, month, day);
                    String email = ShowWindow.userEmail.getText().trim().toLowerCase();
                    if (birthDate.isAfter(LocalDate.now())) {
                        Message.wrongBirthdate();
                    } else {
                        List<Object> result = dbFunctionsImp.addCustomer(name, lastName, birthDate, email);
                        //check if new customer was created
                        boolean isCreated = (boolean) result.get(0);
                        int id = (int) result.get(1);
                        if (isCreated) {
                            Message.newUserData(id, name, lastName, birthDate, email);

                        } else {
                            Message.userExists(id, name, lastName, birthDate, email);
                        }
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
}
