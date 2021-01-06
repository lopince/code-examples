package com.example.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JDKSerialize {

    public static void main(String[] args) {

        SerializableObject sObject = new SerializableObject();
        sObject.setValue("aaa");
        System.out.println(sObject);

        try {
            // serialize
            FileOutputStream fos = new FileOutputStream("SerializableObject.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sObject);
            oos.flush();
            oos.close();

            // deserialization
            FileInputStream fis = new FileInputStream("SerializableObject.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            sObject = (SerializableObject) ois.readObject();
            ois.close();
            System.out.println(sObject);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
