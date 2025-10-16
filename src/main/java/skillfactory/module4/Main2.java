package skillfactory.module4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {

        String[] array = {"qwe", "qwrqwrqwr", "wewe"};
        // <-- Начало
        Arrays.sort(array, (s1, s2) -> s1.length() - s2.length());

        System.out.println(Arrays.toString(array));// <-- Конец


        JButton button = new JButton("Нажми меня");

// Добавляем слушателя - объект анонимного класса
        button.addActionListener((ActionEvent e) -> System.out.println("Кнопка нажата!"));

    }
}
