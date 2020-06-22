package com.company;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {

    /////////////////////////////////////////////////////////*************READ FROM FILE FUNCTION*************/////////////////////////////////////////////////////////

    public static String[] readFunction(String file){
       String [] data = new String[3];
        try{
            File inputFile = new File(file);
            Scanner sc = new Scanner(inputFile);
            int i = 0;
            while(sc.hasNextLine() && i< data.length) {

                    data[i] = sc.nextLine();
                    i++;
            }
            sc.close();
            return data;
        }
        catch(FileNotFoundException e){
            System.out.println("An error has occured!");
            e.printStackTrace();
        }
        return null;
    }

    /////////////////////////////////////////////////////////*************WRITE TO FILE FUNCTION*************/////////////////////////////////////////////////////////

    public static void writeFunction(String file, String fileContent) {
        try {
            FileWriter fWriter = new FileWriter(file);
            fWriter.write(fileContent.toString());
            fWriter.close();
        } catch (Exception e) {
            System.out.println("An error has occured!");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //se face fereastra vizibila
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               GUI guiForm = new GUI();
                guiForm.setVisible(true);
            }
        });


   }
}
