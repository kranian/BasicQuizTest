package com.kranian;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        printf( new Pattern().sum(1,10000000,55) );
    }

    public static void printf(Object... p){
        Arrays.stream(p).map(d ->d).forEach(System.out::println);
    }
}
