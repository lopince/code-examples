package com.example.concurrency.publish;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class UnsafePublishObject {

    @Getter
    private String[] states = {"a", "b", "c"};

    public static void main(String[] args) {
        UnsafePublishObject object = new UnsafePublishObject();
        log.info("{}", Arrays.toString(object.getStates()));

        object.getStates()[0] = "d";
        log.info("{}", Arrays.toString(object.getStates()));
    }
}
