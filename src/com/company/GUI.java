package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton encryptButton;
    private JButton decryptButton;
    private JPanel rootPanel;

    public GUI(){
        //se face vizibila fereastra si se seteaza titlul si marimea
        add(rootPanel);
        setTitle("Encrypt/Decrypt with Caesar And OTP ciphers");
        setSize(300,200);
        //inchiderea programului odata cu inchiderea ferestrei
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //se apeleaza functiile de criptare cand se apasa butonul de criptare
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main ob = new Main();
                String [] data = ob.readFunction("input");
                System.out.println("Initial text: " + data[0] + " Key: " + data[1]);
                Integer key = Integer.parseInt(data[1]);

                Caesar caesar = new Caesar(data[0], key);
                ////////////************Criptez cu Caesar
                StringBuilder czr = caesar.Encryption(data[0], (int) key);
                String czr2 = "Encrypted text with Caesar: " + czr.toString();
                System.out.println(czr2);

                OTP otp = new OTP(czr.toString(), data[2]);
                ////////////************Criptez cu OTP
                StringBuilder ot = otp.Encryption(czr.toString(), data[2]);
                System.out.println("Encrypted text with OTP: " + ot);
                ob.writeFunction("output", ot.toString());

            }
        });

        //se apeleaza functiile de decriptare cand se apasa butonul de decriptare
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main ob = new Main();
                String [] data = ob.readFunction("input");
                System.out.println("Initial text: " + data[0] + " Key: " + data[1]);
                Integer key = Integer.parseInt(data[1]);

                OTP otp = new OTP(data[0], data[2]);
                ////////////************Decriptez cu OTP
                StringBuilder otpDesc = otp.Decryption(data[0], data[2]);
                System.out.println("Decrypted text with OTP: " + otpDesc);

                Caesar caesar = new Caesar(otpDesc.toString(), key);
                ////////////************Decriptez cu Caesar
                String descCzr = caesar.Decryption(otpDesc.toString(),key).toString();
                System.out.println("Decrypted text with Caesar: " + descCzr);

                ob.writeFunction("output", descCzr);
            }
        });
    }
}
