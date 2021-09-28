package gui;

import com.sun.deploy.panel.JSmartTextArea;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Administrate {
    public static void showOperatingScreen(){
        JFrame startFrame = new JFrame("Operating Screen");
        startFrame.setBounds(20, 20, 220, 300);
        startFrame.setResizable(false);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBorder(new EmptyBorder(5, 10, 5, 10));
        JButton buttonAddUser = new JButton("Создать клиента");
        buttonAddUser.setPreferredSize(new Dimension(180,40));
        JButton buttonAddCard = new JButton("Создать карту");
        buttonAddCard.setPreferredSize(new Dimension(180,40));
        JButton buttonCancelCard = new JButton("Аннулировать карту");
        buttonCancelCard.setPreferredSize(new Dimension(180,40));
        JButton buttonUsersList = new JButton("Список клиентов");
        buttonUsersList.setPreferredSize(new Dimension(180,40));
        JButton buttonCardsList = new JButton("Список карт");
        buttonCardsList.setPreferredSize(new Dimension(180,40));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 10, 0);
        leftPanel.add(buttonAddUser, c);
        c.gridy = 1;
        leftPanel.add(buttonAddCard, c);
        c.gridy = 2;
        leftPanel.add(buttonCancelCard, c);
        c.gridy = 3;
        leftPanel.add(buttonUsersList, c);
        c.gridy = 4;
        leftPanel.add(buttonCardsList, c);

        buttonAddUser.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddUserScreen.completeUserForm();
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


        startFrame.add(leftPanel, BorderLayout.WEST);
        startFrame.setVisible(true);
    }
}
