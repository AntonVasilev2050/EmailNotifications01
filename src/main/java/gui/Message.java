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

    public static void newUserData(String name, String lastName, LocalDate birthDate, String email){
        String message = "Имя: " + name + " " + lastName + ", " + "\nДата рождения: " + birthDate + "\nemail: " + email;
        JOptionPane.showMessageDialog(null, message, "Добавлен новый клиент" , JOptionPane.INFORMATION_MESSAGE);
    }

}
