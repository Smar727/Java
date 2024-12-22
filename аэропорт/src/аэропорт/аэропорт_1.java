package аэропорт;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class аэропорт_1{
    private static final String[] Страны = {"Россия", "США", "Франция"};
    private static final String[] Города = {"Москва", "Нью-Йорк", "Париж"};
    static int[][] price1 = {{100, 150, 200}, {250, 110, 300}, {350, 165, 90}};

    public static void main(String[] args) {
        JFrame frame = new JFrame("Аэропорт");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Имя:");
        nameLabel.setBounds(10, 10, 80, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(100, 10, 160, 25);
        frame.add(nameField);

        JLabel countryLabel = new JLabel("Страна:");
        countryLabel.setBounds(10, 40, 80, 25);
        frame.add(countryLabel);

        JComboBox<String> countryComboBox = new JComboBox<>(Страны);
        countryComboBox.setBounds(100, 40, 160, 25);
        frame.add(countryComboBox);

        JLabel cityLabel = new JLabel("Город:");
        cityLabel.setBounds(10, 70, 80, 25);
        frame.add(cityLabel);

        JComboBox<String> cityComboBox = new JComboBox<>(Города);
        cityComboBox.setBounds(100, 70, 160, 25);
        frame.add(cityComboBox);

        JLabel classLabel = new JLabel("Класс полета:");
        classLabel.setBounds(10, 100, 100, 25);
        frame.add(classLabel);

        JRadioButton economyButton = new JRadioButton("Эконом");
        economyButton.setBounds(120, 100, 100, 25);
        JRadioButton businessButton = new JRadioButton("Бизнес");
        businessButton.setBounds(220, 100, 100, 25);
        ButtonGroup classGroup = new ButtonGroup();
        classGroup.add(economyButton);
        classGroup.add(businessButton);
        frame.add(economyButton);
        frame.add(businessButton);

        JLabel dateLabel = new JLabel("Дата полета:");
        dateLabel.setBounds(10, 130, 100, 25);
        frame.add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(120, 130, 140, 25);
        frame.add(dateField);

        JButton resultButton = new JButton("Результат");
        resultButton.setBounds(10, 160, 150, 25);
        frame.add(resultButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 190, 350, 100);
        frame.add(resultArea);

        resultButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String country = (String) countryComboBox.getSelectedItem();
                int country_id=0;
                int CITIES_id=0;
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Ошибка: Имя не может быть пустым.", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                switch(country) {
                case "Россия": 
                	country_id=0;
                	break;
                case "США":
                	country_id=1;
                	break;
                case "франция":
                	country_id=2;
                	break;
                
                
                }
                
                String city = (String) cityComboBox.getSelectedItem();
                switch(city) {
                case "Москва":
                	CITIES_id=0;
                	break;
                case "Нью-Йорк":
                	CITIES_id=1;
                	break;
                case "Париж":
                	CITIES_id=2;
                	break;
                }
                double price = price1[country_id][CITIES_id];

                if (businessButton.isSelected()) {
                    price *= 1.5; 
                }

               

                String date = dateField.getText();
                if (date.matches("\\d{2}/\\d{2}/\\d{4}")) { 
                    String[] dateParts = date.split("/"); 
                    int month = Integer.parseInt(dateParts[1]); 
                    if (month >= 6 && month <= 8) { 
                        price *= 1.1; 
                    }
                }

                resultArea.setText("Стоимость полета для " + name + ":\n" +
                        "Страна: " + country + "\n" +
                        "Город: " + city + "\n" +
                        "Дата полета"+ date+"\n"+
                        "Цена: " + price + " Руб.");
            }
        });

        frame.setVisible(true);
    }
}
