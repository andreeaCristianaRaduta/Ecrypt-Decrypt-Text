package com.company;

public class OTP {

    private String text;
    private String key;

    public OTP(){}

    public OTP(String text, String key) {
        this.text = text;
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /////////////////////////////////////////////////////////*************OTP ENCRYPTION*************/////////////////////////////////////////////////////////

    public static StringBuilder Encryption(String text, String key){

        if(text == null)
            return null;

        if(key == null)
            return null;

        text = text.replace(" ","");
        if(text.length() > key.length())
            return null;

        StringBuilder ciphertext = new StringBuilder();
        ciphertext.append(text);
        key.toUpperCase();
        String punctuation = ",.()[]?!'<>-=+`{}/\\\"*&^%$#@_;:1234567890";

        for(int i = 0; i<ciphertext.length();i++){
            char ch = ciphertext.charAt(i), k = key.charAt(i);
            if(punctuation.indexOf(ch) == -1){
                if(ch >= 'a' && ch <= 'z'){
                    //cifrez caracterul adaugand la valoarea lui valoarea cheii de pe aceeasi pozitie
                    ch = (char)((ch - 'a' + k));
                    //am grija sa nu depasesc alfabetul
                    if (ch > 'z') {
                        ch = (char) ((int) ch - 'z' + 'a' - 1) ;
                        ciphertext.insert(i, ch);
                        ciphertext.delete(i + 1, i + 2);
                    } else {
                        ciphertext.insert(i, ch);
                        ciphertext.delete(i + 1, i + 2);
                    }
                }
                if(ch >= 'A' && ch <= 'Z'){
                    ch = (char)((ch - 'A' + k));
                    if (ch > 'z') {
                        ch = (char) ((int) ch - 'Z' + 'A' - 1) ;
                        ciphertext.insert(i, ch);
                        ciphertext.delete(i + 1, i + 2);
                    } else {
                        ciphertext.insert(i, ch);
                        ciphertext.delete(i + 1, i + 2);
                    }
                }
            }
        }
        return ciphertext;
    }

    /////////////////////////////////////////////////////////*************OTP DECRYPTION*************/////////////////////////////////////////////////////////

    public static StringBuilder Decryption(String text, String key){

        if(text == null)
            return null;

        if(key == null)
            return null;

        text = text.replace(" ","");
        if(text.length() > key.length())
            return null;

        StringBuilder deciphertext = new StringBuilder();
        deciphertext.append(text);
        key.toUpperCase();
        String punctuation = ",.()[]?!'<>-=+`{}/\\\"*&^%$#@_;:1234567890";

        for(int i = 0; i<deciphertext.length();i++){
            char ch = deciphertext.charAt(i), k = key.charAt(i);
            if(punctuation.indexOf(ch) == -1){
                if(ch >= 'a' && ch <= 'z'){
                    //scad din valoarea caracterului din text valoarea caracterului din cheie
                    ch = (char)(ch + 'a' - k);
                    //ma asigur ca cifrez corect, chiar daca prin scadere valoarea caracterului este mai mica decat 'a'
                    if (ch < 'a') {
                        ch = (char) ((int) ch + 'z' - 'a' + 1) ;
                        deciphertext.insert(i, ch);
                        deciphertext.delete(i + 1, i + 2);
                    } else {
                        deciphertext.insert(i, ch);
                        deciphertext.delete(i + 1, i + 2);
                    }
                }
                if(ch >= 'A' && ch <= 'Z'){
                    ch = (char)((ch + 'A' - k));
                    if (ch < 'A') {
                        ch = (char) ((int) ch + 'Z' - 'A' + 1) ;
                        deciphertext.insert(i, ch);
                        deciphertext.delete(i + 1, i + 2);
                    } else {
                        deciphertext.insert(i, ch);
                        deciphertext.delete(i + 1, i + 2);
                    }
                }
            }
        }
        return deciphertext;
    }
}
