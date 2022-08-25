package Netology.Multithread_Functional.Functional.Task2;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Set<RealEstate>> createRealEstateSet = limit -> {
            Random random = new Random();
            return Stream.iterate(0, i -> i++).
                    limit(limit).
                    map(address ->
                            String.format("г.Омск,ул.Ленина д.%2d, кв.%3d.",
                                    random.nextInt(1, 50),
                                    random.nextInt(1, 150))).
                    map(address ->
                            new RealEstate(address,
                                    random.nextDouble(5, 30),
                                    random.nextDouble(5, 30),
                                    random.nextDouble(1_000_000, 30_000_000))).
                    collect(Collectors.toSet());
        };
        System.out.println("Введите цену за квадратный метр ");
        double fairCostPerMeter = new Scanner(System.in).nextDouble();
        createRealEstateSet.apply(20)
                .forEach(realEstate -> System.out.printf("%s - %s\n", realEstate,
                        realEstate.getCostPerMeter() > fairCostPerMeter ? "нечестная цена" : "честная цена"));
    }
}
