package com.example.concurrency.sync;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CollectionsSyncTest {

    public static void main(String[] args) {

        List<Integer> list = Collections.synchronizedList(Lists.newArrayList());

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(null);
        hashSet.add(null);

        System.out.println(hashSet.size());
    }
}
