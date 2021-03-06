package com.yuzlink.app.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Utils {
    private static final char[] ALPHABET_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String decimalToBase(long number, int base) {
        Stack<Integer> stack = new Stack<>();
        int remainder;
        long quotient;
        do {
            quotient = number / base;
            remainder = (int) (number % base);
            stack.push(remainder);
            number = quotient;
        } while (quotient != 0);
        char[] result = new char[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            result[i++] = ALPHABET_62[stack.pop()];
        }
        return new String(result);
    }

    public static String keyToBase62(long decimal) {
        String key = decimalToBase(decimal, 62);
        int leftToFill = 6 - key.length();
        if (leftToFill == 0) {
            return key;
        }
        char[] zeros = new char[leftToFill];
        Arrays.fill(zeros, '0');
        return new String(zeros) + key;
    }

    public static String writeListToJsonArray(List list) throws IOException {

            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(out, list);

            final byte[] data = out.toByteArray();
            return new String(data);
    }
}


