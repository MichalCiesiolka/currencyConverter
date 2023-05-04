package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import static org.example.getValue.getCurrValue;

public class initWindow extends JFrame implements ActionListener {
    JTextField fromField = new JTextField();
    JTextField toField = new JTextField();
    JTextField valueField = new JTextField();
    JTextField resultField = new JTextField();
    JButton calculate = new JButton("=");
    JLabel fromLabel = new JLabel("From");
    JLabel toLabel = new JLabel("To");
    JLabel valueLabel = new JLabel("Amount");
    DecimalFormat df = new DecimalFormat("0.00");
    initWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fromField.setBounds(5, 30, 160, 40);
        fromLabel.setBounds(5, 10, 40, 10);
        toField.setBounds(235, 30, 160, 40);
        toLabel.setBounds(235, 10, 40, 10);
        valueField.setBounds(125, 100, 160, 40);
        valueLabel.setBounds(125, 80, 40, 10);
        resultField.setBounds(125, 210, 160, 40);
        calculate.setBounds(125, 165, 160, 20);
        resultField.setEditable(false);

        calculate.addActionListener(this);

        this.add(fromField);
        this.add(fromLabel);
        this.add(toField);
        this.add(toLabel);
        this.add(valueField);
        this.add(valueLabel);
        this.add(resultField);
        this.add(calculate);

        this.setSize(400, 400);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fromCurr=fromField.getText();
        String toCurr=toField.getText();
        String s3=valueField.getText();
        double calcValue = Double.parseDouble(s3);
        double c=0;
        if(e.getSource()==calculate) {
            try {
                c = getCurrValue(fromCurr, toCurr) * calcValue;
                c = Double.parseDouble(df.format(c));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        String result=String.valueOf(c);
        resultField.setText(result);
    }
}
