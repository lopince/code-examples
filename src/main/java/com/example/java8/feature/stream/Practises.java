package com.example.java8.feature.stream;

import com.example.java8.bean.Trader;
import com.example.java8.bean.Transaction;

import java.util.Comparator;
import java.util.List;

public class Practises {

    public static void main(String[] args) {

        List<Transaction> transactions = Transaction.transactions;
        List<Trader> traders = Trader.traders;

        // (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        // (5) 有没有交易员是在米兰工作的？
        System.out.println(
                traders.stream()
                        .anyMatch(t -> ("Milan").equals(t.getCity())));

        // (7) 所有交易中，最高的交易额是多少
        transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue))
                .ifPresent(System.out::println);


    }
}
