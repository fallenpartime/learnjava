package com.learn.eight.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdaDemo {

    public static void process(Runnable runnable) {
        runnable.run();
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    /**
     * 示范使用Function函数式接口
     *
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        process(() -> System.out.println("This is awesome!!"));
        System.out.println(processFile((BufferedReader br) -> br.readLine() + br.readLine()));

        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println(l);
    }
}
