package com.survey;

import java.util.HashMap;
import java.util.Map;

public class OhMyMemory1 {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory();
        System.out.println("heapSize: " + String.valueOf(heapSize));
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    @Override
                    public void run() {
                        System.out.println("We have accumulated " + map.size() + " entries");
                    }
                }
        );
        for(int i = 0; ;i++) {
            map.put(Integer.toBinaryString(i), i);
        }
    }
}
