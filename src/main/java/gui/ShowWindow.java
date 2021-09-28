package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class ShowWindow {
    public static JButton buttonCreateCustomer;
    public static JButton buttonFindCustomer;
    public static JButton buttonCreateCard;
    public static JButton buttonCloseCard;
    public static JTextField userName;
    public static JTextField userLastName;
    public static JTextField userBirthDateY;
    public static JTextField userBirthDateM;
    public static JTextField userBirthDateD;
    public static JTextField userEmail;

    public ShowWindow(){
        JFrame frameAddNewUser = new JFrame("Management");
        frameAddNewUser.setBounds(240, 20, 550, 400);
//        frameAddNewUser.setResizable(false);
        frameAddNewUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAddNewUser.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setBorder(new EmptyBorder(20, 0, 0, 0));
        JLabel labelUser = new JLabel("Информация о клиенте");
        labelUser.setFont(new Font("Arial", Font.BOLD, 20));
        top.add(labelUser);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JLabel labelUserName = new JLabel("Имя клиента:");
        JLabel labelUserLastName = new JLabel("Фамилия:");
        JLabel labelUserBirthDate = new JLabel("Дата рождения:");
        JLabel labelUserEmail = new JLabel("email клиента:");
        userName = new JTextField();
        Dimension textFieldDimension = new Dimension(100, 20);
        userName.setPreferredSize(textFieldDimension);
        userLastName = new JTextField();
        userLastName.setPreferredSize(textFieldDimension);

        userBirthDateY = new JTextField();
        userBirthDateY.setPreferredSize(new Dimension(50, 20));
        JLabel labelY = new JLabel("Год");
        userBirthDateM = new JTextField();
        userBirthDateM.setPreferredSize(new Dimension(50, 20));
        JLabel labelM = new JLabel("Месяц");
        userBirthDateD = new JTextField();
        userBirthDateD.setPreferredSize(new Dimension(50, 20));
        JLabel labelD = new JLabel("День");
        userEmail = new JTextField();
        userEmail.setPreferredSize(textFieldDimension);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(labelUserName, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(labelUserLastName, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(labelUserBirthDate, c);
        c.gridx = 2;
        c.gridy = 2;
        panel.add(labelY, c);
        c.gridx = 2;
        c.gridy = 3;
        panel.add(labelM, c);
        c.gridx = 2;
        c.gridy = 4;
        panel.add(labelD, c);
        c.gridx = 0;
        c.gridy = 5;
        panel.add(labelUserEmail, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(userName, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(userLastName, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(userBirthDateY, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(userBirthDateM, c);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(userBirthDateD, c);
        c.gridx = 1;
        c.gridy = 5;
        panel.add(userEmail, c);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        buttonCreateCustomer = new JButton("Новый клиент");
        buttonFindCustomer = new JButton("Найти клиента");
        buttonCreateCard = new JButton("Новая карта");
        buttonCloseCard = new JButton("Аннулировать карту");

//        buttonCreateCustomer.setPreferredSize(new Dimension(100, 30));

        bottomPanel.add(buttonCreateCustomer);
        bottomPanel.add(buttonFindCustomer);
        bottomPanel.add(buttonCreateCard);
        bottomPanel.add(buttonCloseCard);


        frameAddNewUser.add(top, BorderLayout.NORTH);
        frameAddNewUser.add(panel, BorderLayout.CENTER);
        frameAddNewUser.add(bottomPanel, BorderLayout.SOUTH);
        frameAddNewUser.setVisible(true);
    }
}
