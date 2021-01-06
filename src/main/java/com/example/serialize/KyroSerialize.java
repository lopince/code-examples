package com.example.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class KyroSerialize {

    public static void main(String[] args) {

        SerializableObject sObject = new SerializableObject();
        sObject.setValue("KyroSerialize");
        System.out.println(sObject);

        try{
            Kryo kryo = new Kryo();
            Output output = new Output(new FileOutputStream("SerializableObject.bin"));
            kryo.writeObject(output, sObject);
            output.close();

            Input input = new Input(new FileInputStream("SerializableObject.bin"));
            sObject = kryo.readObject(input, SerializableObject.class);
            input.close();
            System.out.println(sObject);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
