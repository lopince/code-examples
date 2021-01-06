package com.example.redis;

import redis.clients.jedis.Jedis;

public class JedisTest {

    public static void main(String[] args) {

        String host = "118.178.139.226";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);
        System.out.println(String.format("Connected redis[%s: %s]...", host, port));

        // string
        String sKey = "str1";
        String sValue = "string";
        System.out.println();
        System.out.println("[String]");
        System.out.println("jedis.set(key, value): " + jedis.set(sKey, sValue));
        System.out.println("jedis.get(key): " + jedis.get(sKey));
        System.out.println("jedis.exists(key): " + jedis.exists(sKey));
        System.out.println("jedis.strlen(key): " + jedis.strlen(sKey));
        System.out.println("jedis.del(key): " + jedis.del(sKey));
        System.out.println("jedis.get(key): " + jedis.get(sKey));

        String nKey = "number";
        String nValue = "1";
        System.out.println();
        System.out.println("[Counter]");
        System.out.println("jedis.set(nKey, nValue: " + jedis.set(nKey, nValue));
        System.out.println("jedis.incr(nKey): " + jedis.incr(nKey));
        System.out.println("jedis.get(nKey): " + jedis.get(nKey));
        System.out.println("jedis.decr(nKey): " + jedis.decr(nKey));
        System.out.println("jedis.get(nKey): " + jedis.get(nKey));

    }
}
