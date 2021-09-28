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

    public static void newUserData(int id, String name, String lastName, LocalDate birthDate, String email){
        String message = "Имя: " + name + " " + lastName + ", " + "\nДата рождения: " + birthDate + "\nemail: " + email;
        JOptionPane.showMessageDialog(null, message, "Добавлен новый клиент id-" + id , JOptionPane.INFORMATION_MESSAGE);
    }
    public static void userExists(int id, String name, String lastName, LocalDate birthDate, String email){
        String message = "Имя: " + name + " " + lastName + ", " + "\nДата рождения: " + birthDate + "\nemail: " + email;
        JOptionPane.showMessageDialog(null, "Такой клиент уже есть в базе: \n" + message, "Внимание!", JOptionPane.ERROR_MESSAGE);
    }

    public static void newDBCreated(String path){
        JOptionPane.showMessageDialog(null, "Будет создана новая база данных в " + path, "Не найденна база данных!", JOptionPane.WARNING_MESSAGE);
    }

}
