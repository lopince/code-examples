package com.example.serialize;

import java.io.Serializable;

public class SerializableObject implements Serializable  {



    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SerializableObject{" +
                "value='" + value + '\'' +
                '}';
    }
}
