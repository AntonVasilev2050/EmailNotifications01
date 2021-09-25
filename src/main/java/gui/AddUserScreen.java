package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddUserScreen {
    public static void completeUserForm() {
        JFrame frameAddNewUser = new JFrame("Add new User");
        frameAddNewUser.setBounds(100, 20, 400, 400);
        frameAddNewUser.setResizable(false);
//        frameAddNewUser.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameAddNewUser.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setBorder(new EmptyBorder(20, 0, 0, 0));
        JLabel labelUser = new JLabel("Новый пользователь");
        labelUser.setFont(new Font("Arial", Font.BOLD, 22));
        top.add(labelUser);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JLabel labelUserName = new JLabel("Имя пользователя:");
        JLabel labelUserLastName = new JLabel("Фамилия:");
        JLabel labelUserBirthDate = new JLabel("Дата рождения:");
        JLabel labelUserEmail = new JLabel("email пользователя:");
        JTextField userName = new JTextField();
        Dimension textFieldDimension = new Dimension(150, 20);
        userName.setPreferredSize(textFieldDimension);
        JTextField userLastName = new JTextField();
        userLastName.setPreferredSize(textFieldDimension);
        JTextField userBirthDate = new JTextField();
        userBirthDate.setPreferredSize(textFieldDimension);
        JTextField userEmail = new JTextField();
        userEmail.setPreferredSize(textFieldDimension);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 10, 5);
        panel.add(labelUserName, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(userName, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(labelUserLastName, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(userLastName, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(labelUserBirthDate, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(userBirthDate, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(labelUserEmail, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(userEmail, c);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        JButton buttonCreate = new JButton("Создать");
        JButton buttonCancel = new JButton("Отменить");
        buttonCreate.setPreferredSize(new Dimension(100, 30));
        buttonCancel.setPreferredSize(new Dimension(100, 30));
        bottomPanel.add(buttonCreate);
        bottomPanel.add(buttonCancel);

        frameAddNewUser.add(top, BorderLayout.NORTH);
        frameAddNewUser.add(panel, BorderLayout.CENTER);
        frameAddNewUser.add(bottomPanel, BorderLayout.SOUTH);
        frameAddNewUser.setVisible(true);
    }
}
