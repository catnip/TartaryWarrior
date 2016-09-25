package utils;

import model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListUtils {
    public static <T> List<T> filter (List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static <T> void print (List<T> list, Consumer<T> printer) {
        for (T e : list) {
            printer.accept(e);
        }
    }

    public static void main(String[] args) {
        Apple a1 = Apple.builder().color("Red").weight(150).build();
        Apple a2 = Apple.builder().color("Green").weight(130).build();
        Apple a3 = Apple.builder().color("Red").weight(130).build();
        List<Apple> apples = Arrays.asList(a1, a2, a3);

        List<Apple> redApples = ListUtils.filter(apples, (Apple a) -> "Red".equals(a.getColor()));
        ListUtils.print(redApples, (Apple a) -> {
            System.out.println(a.toString());
        });

        System.out.println();

        List<Apple> heavyApples = ListUtils.filter(apples, (Apple a) -> a.getWeight() >= 150);
        ListUtils.print(heavyApples, (Apple a) -> {
            System.out.println(a.toString());
            System.out.println("Heavy!");
        });
    }
}
