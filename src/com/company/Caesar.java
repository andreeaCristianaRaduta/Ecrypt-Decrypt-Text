package com.company;

public class Caesar {

    private String text;
    private int key;

    public Caesar(){}

    public Caesar(String text, int key) {
        this.text = text;
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    /////////////////////////////////////////////////////////*************CAESAR ENCRYPTION*************/////////////////////////////////////////////////////////

    public static StringBuilder Encryption(String text, int key){

        if(text == null)
            return null;

        if(key< 0)
            return null;

        text = text.replace(" ","");
        StringBuilder ciphertext = new StringBuilder();
        ciphertext.append(text);
        String punctuation = ",.()[]?!'<>-=+`{}/\\\"*&^%$#@_;:1234567890";

        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            //ma asigur ca voi cripta doar litere
            if(punctuation.indexOf(ciphertext.charAt(i)) == -1) {
                //criptez literele mici
                if(ch >= 'a' && ch <= 'z') {
                    //adaug cheia la valoarea literei
                    ch = (char)((int)ch + key%26);
                    //daca se depaseste alfabetul, se reintoarce in alfabet si introduce valoarea in textul cifrat
                    if (ch > 'z') {
                        ciphertext.insert(i, (char) ((int) ch - 'z' + 'a' - 1));
                        ciphertext.delete(i + 1, i + 2);
                    } else {
                        //inserez pe pozitia i caracterul cifrat
                        ciphertext.insert(i, ch);
                        //sterg de pe pozitia i+1 elementul care era pe pozitia i inainte sa inserez caracterul cifrat
                        ciphertext.delete(i + 1, i + 2);
                    }
                }
                //criptez literele mari
                if(ch >= 'A' && ch <= 'Z') {
                    //adaug cheia la valoarea literei
                    ch = (char)((int)ch + key%26);
                    //daca se depaseste alfabetul, se reintoarce in alfabet si introduce valoarea in textul cifrat
                    if (ch > 'Z') {
                        ciphertext.insert(i, (char) ((int) ch - 'Z' + 'A' - 1));
                        ciphertext.delete(i + 1, i + 2);
                    } else {
                        //inserez pe pozitia i caracterul cifrat
                        ciphertext.insert(i, ch);
                        //sterg de pe pozitia i+1 elementul care era pe pozitia i inainte sa inserez caracterul cifrat
                        ciphertext.delete(i + 1, i + 2);
                    }
                }
            }
        }
        return ciphertext;
    }

    /////////////////////////////////////////////////////////*************CAESAR DECRYPTION*************/////////////////////////////////////////////////////////

    public static StringBuilder Decryption(String text, int key){

        if(text == null)
            return null;

        if(key< 0)
            return null;

        text = text.replace(" ","");
        StringBuilder desciphertext = new StringBuilder();
        desciphertext.append(text);
        String punctuation = ",.()[]?!'<>-=+`{}/\\\"*&^%$#@_;:1234567890";

        for (int i = 0; i < desciphertext.length(); i++) {
            char ch = desciphertext.charAt(i);
            if(punctuation.indexOf(desciphertext.charAt(i)) == -1) {
                //verific daca caracterul este litera mica sau mare
                if(ch >= 'a' && ch <= 'z') {
                    //scad valoarea cheii din valoarea caracterului
                    ch = (char)((int)ch - key%26);
                    //daca se depaseste marginea inferioara a alfabetlui se reintoarce in alfabet si insereaza caracterul cifrat in text
                    if (ch < 'a') {
                        ch = (char)((int)ch + 'z' - 'a' + 1);
                        desciphertext.insert(i, ch);
                        desciphertext.delete(i + 1, i + 2);
                    } else {
                        //insereaza caracterul cifrat si il sterge pe cel vechi
                        desciphertext.insert(i, ch);
                        desciphertext.delete(i + 1, i + 2);
                    }
                }
                //acelasi lucru ca mai sus, dar pentru litere mari
                if(ch >= 'A' && ch <= 'Z') {
                    ch = (char)((int)ch - key%26);
                    if (ch < 'A') {
                        ch = (char) ((int) ch + 'Z' - 'A' + 1);
                        desciphertext.insert(i, ch);
                        desciphertext.delete(i + 1, i + 2);
                    } else {
                        desciphertext.insert(i, ch);
                        desciphertext.delete(i + 1, i + 2);
                    }
                }
            }
        }
        return desciphertext;
    }
}
