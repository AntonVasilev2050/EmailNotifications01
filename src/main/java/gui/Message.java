package gui;

import javax.swing.*;
import java.time.LocalDate;

public class Message {
    public static void wrongBirthdate(){
        JOptionPane.showMessageDialog(null, "Дата рождения позже сегодняшнего дня", "Ошибка!", JOptionPane.WARNING_MESSAGE);
    }

    public static void checkBirthdateFields(String message){
        JOptionPane.showMessageDialog(null, message, "Ошибка!", JOptionPane.ERROR_MESSAGE);
    }

    public static void newCustomerData(int id, String name, String lastName, LocalDate birthDate, String email){
        String message = "Имя: " + name + " " + lastName + ", " + "\nДата рождения: " + birthDate + "\nemail: " + email;
        JOptionPane.showMessageDialog(null, message, "Добавлен новый клиент id-" + id , JOptionPane.INFORMATION_MESSAGE);
    }

    public static void customerAlreadyExists(int id, String name, String lastName, LocalDate birthDate, String email){
        String message = "Такой клиент уже есть в базе: \n" + "ID: " + id + "\nИмя: " + name + " " + lastName + ", " + "\nДата рождения: " + birthDate + "\nemail: " + email;
        JOptionPane.showMessageDialog(null, message, "Внимание!", JOptionPane.ERROR_MESSAGE);
    }

    public static void newDBCreated(String path){
        JOptionPane.showMessageDialog(null, "Будет создана новая база данных в " + path, "Не найденна база данных!", JOptionPane.WARNING_MESSAGE);
    }

    public static void newCardAdded(long newCardNumber, String name, String lastName, int id){
        String message = "Карта номер " + newCardNumber + " добавлена клиенту \nid " + id + "\nИмя: " + name +
                "\nФамилия: " + lastName;
        JOptionPane.showMessageDialog(null, message, "Новая карта добавлена!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void customerFound(int id, String name, String lastName, LocalDate birthDate, String email){
        String message = "Найден клиент: \n" + "Имя: " + name + " " + lastName + ", " + "\nДата рождения: " + birthDate + "\nemail: " + email;
        JOptionPane.showMessageDialog(null, message, "Клиент найден" + id , JOptionPane.INFORMATION_MESSAGE);
    }

    public static void customerNotFound(String name, String lastName, LocalDate birthDate, String email){
        String message = "Клиент: \n" + "Имя: " + name + " " + lastName + ", " + "\nДата рождения: " + birthDate + "\nemail: " + email + "\nНе найден!";
        JOptionPane.showMessageDialog(null, message, "Клиент не найден", JOptionPane.WARNING_MESSAGE);
    }
}
