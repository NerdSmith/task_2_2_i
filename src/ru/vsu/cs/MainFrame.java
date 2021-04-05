package ru.vsu.cs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainFrame extends JFrame{
    private JTextField listTextField;
    private JButton loadFromFileBtn;
    private JButton sortBtn;
    private JPanel panelMain;

    public MainFrame() {
        super("Application");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 900, 400);
        this.setMinimumSize(new Dimension(500, 130));

        this.loadFromFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("./files"));
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String name = chooser.getSelectedFile().getPath();
                    Scanner scanner;
                    try {
                        scanner = new Scanner(new File(name));
                    } catch (FileNotFoundException fileNotFoundException) {
                        listTextField.setText("File not found");
                        return;
                    }
                    listTextField.setText(scanner.nextLine());
                }
            }
        });

        this.sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] splittedLine = listTextField.getText().split(" ");
                if (splittedLine[0].matches("-?\\d+(\\.\\d+)?")) {
                    LinkedList<Integer> linkedList = LinkedListUtils.getIntegerLinkedListFromString(splittedLine);
                    linkedList.insertionSort();
                    listTextField.setText(linkedList.toString());
                }
                else {
                    LinkedList<String> linkedList = LinkedListUtils.getStringLinkedListFromString(splittedLine);
                    linkedList.insertionSort();
                    listTextField.setText(linkedList.toString());
                }
            }
        });
    }
}
