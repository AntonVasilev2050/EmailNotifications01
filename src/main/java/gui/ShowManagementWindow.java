package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ShowManagementWindow {
    public static JButton buttonCreateCustomer;
    public static JButton buttonFindCustomer;
    public static JButton buttonCreateCard;
    public static JButton buttonCloseCard;
    public static JButton buttonCustomersList;
    public static JTextField customerName;
    public static JTextField customerLastName;
    public static JTextField customerBirthDateY;
    public static JTextField customerBirthDateM;
    public static JTextField customerBirthDateD;
    public static JTextField customerEmail;
    public static JLabel labelCustomerCards;
    public static JTextArea customerCards;
    public static JTextArea customersList;

    public ShowManagementWindow(){
        JFrame frameManagement = new JFrame("Management");
        frameManagement.setBounds(100, 20, 870, 400);
//        frameManagement.setResizable(false);
        frameManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameManagement.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setBorder(new EmptyBorder(20, 0, 0, 0));
        JLabel labelUser = new JLabel("Информация о клиенте");
        labelUser.setFont(new Font("Arial", Font.BOLD, 20));
        top.add(labelUser);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0, 10, 0, 0));
        panel.setLayout(new GridBagLayout());
        JLabel labelUserName = new JLabel("Имя клиента:");
        JLabel labelUserLastName = new JLabel("Фамилия:");
        JLabel labelUserBirthDate = new JLabel("Дата рождения:");
        JLabel labelUserEmail = new JLabel("email клиента:");
        labelCustomerCards = new JLabel("Карты клиента");
        customerName = new JTextField();
        Dimension textFieldDimension = new Dimension(150, 20);
        customerName.setPreferredSize(textFieldDimension);
        customerLastName = new JTextField();
        customerLastName.setPreferredSize(textFieldDimension);
        customerBirthDateY = new JTextField();
        customerBirthDateY.setPreferredSize(new Dimension(50, 20));
        JLabel labelY = new JLabel("Год");
        customerBirthDateM = new JTextField();
        customerBirthDateM.setPreferredSize(new Dimension(50, 20));
        JLabel labelM = new JLabel("Месяц");
        customerBirthDateD = new JTextField();
        customerBirthDateD.setPreferredSize(new Dimension(50, 20));
        JLabel labelD = new JLabel("День");
        customerEmail = new JTextField();
        customerEmail.setPreferredSize(textFieldDimension);
        customerCards = new JTextArea("XXXX XXXX XXXX XXXX");

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
        c.gridx = 0;
        c.gridy = 6;
        panel.add(labelCustomerCards, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(customerName, c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(customerLastName, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(customerBirthDateY, c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(customerBirthDateM, c);
        c.gridx = 1;
        c.gridy = 4;
        panel.add(customerBirthDateD, c);
        c.gridx = 1;
        c.gridy = 5;
        panel.add(customerEmail, c);
        c.gridx = 1;
        c.gridy = 6;
        panel.add(customerCards, c);

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
        customersList = new JTextArea(12, 45);
        JScrollPane scroll = new JScrollPane (customersList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        rightPanel.add(scroll);
//        rightPanel.add(customersList);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
        buttonCreateCustomer = new JButton("Новый клиент");
        buttonFindCustomer = new JButton("Найти клиента");
        buttonCreateCard = new JButton("Новая карта");
        buttonCloseCard = new JButton("Аннулировать карту");
        buttonCustomersList = new JButton("Список клиентов");
        bottomPanel.add(buttonCreateCustomer);
        bottomPanel.add(buttonFindCustomer);
        bottomPanel.add(buttonCreateCard);
        bottomPanel.add(buttonCloseCard);
        bottomPanel.add(buttonCustomersList);
        frameManagement.add(top, BorderLayout.NORTH);
        frameManagement.add(panel, BorderLayout.WEST);
        frameManagement.add(rightPanel, BorderLayout.EAST);
        frameManagement.add(bottomPanel, BorderLayout.SOUTH);
        frameManagement.setVisible(true);
    }
}
