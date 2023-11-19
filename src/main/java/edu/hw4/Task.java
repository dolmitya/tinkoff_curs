package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    private static final int MAX_HEIGHT = 100;

    public Task() {
    }

    //1
    //Отсортировать животных по росту от самого маленького к
    // самому большому -> List<Animal>
    public List<Animal> task1(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    //2
    //Отсортировать животных по весу от самого тяжелого к самому
    // легкому, выбрать k первых -> List<Animal>
    public List<Animal> task2(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight)
                .reversed())
            .collect(Collectors.toList());
    }

    //3
    //Сколько животных каждого вида -> Map<Animal.Type, Integer>
    public Map<Animal.Type, Long> task3(List<Animal> animals) {
        return animals.stream().collect(
            Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    //4
    //У какого животного самое длинное имя -> Animal
    public Animal task4(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparing(animal -> animal.name().length()))
            .orElse(null);
    }

    //5
    //Каких животных больше: самцов или самок -> Sex
    public Animal.Sex task5(List<Animal> animals) {
        Map<Animal.Sex, Long> pol = animals.stream()
            .collect(Collectors.groupingBy(
                Animal::sex,
                Collectors.counting()
            ));
        return pol.get(Animal.Sex.M) > pol.get(Animal.Sex.F) ? Animal.Sex.M
            : pol.get(Animal.Sex.M) < pol.get(Animal.Sex.F) ? Animal.Sex.F : null;
    }

    //6
    //Самое тяжелое животное каждого вида -> Map<Animal.Type, Animal>
    public Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(
            Animal::type,
            Function.identity(),
            BinaryOperator.maxBy(Comparator.comparing(Animal::weight))
        ));
    }

    //7
    //K-е самое старое животное -> Animal
    public Animal task7(List<Animal> animals, int k) {
        return (k > 0) ? animals.stream()
            .sorted(Comparator.comparing(Animal::age))
            .skip(k - 1)
            .findFirst()
            .get() : null;
    }

    //8
    //Самое тяжелое животное среди животных ниже k см ->
    // Optional<Animal>
    public Animal task8(List<Animal> animals, int k) {
        return animals.stream().filter(animal -> animal.height() < k)
            .max(Comparator.comparing(Animal::weight))
            .get();
    }

    //9
    //Сколько в сумме лап у животных в списке -> Integer
    public Integer task9(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    //10
    //Список животных, возраст у которых не совпадает с количеством
    // лап -> List<Animal>
    public List<Animal> task10(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }

    //11
    //Список животных, которые могут укусить (bites == null или true) и
    // рост которых превышает 100 см -> List<Animal>
    public List<Animal> task11(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > MAX_HEIGHT)
            .toList();
    }

    //12
    //Сколько в списке животных, вес которых превышает рост ->
    // Integer
    public Integer task12(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .toList()
            .size();
    }

    //13
    //Список животных, имена которых состоят из более чем двух слов
    // -> List<Animal>
    public List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().trim().indexOf(' ') > -1)
            .toList();
    }

    //14
    //Есть ли в списке собака ростом более k см -> Boolean
    public boolean task14(List<Animal> animals, int k) {
        return !animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG
                && animal.height() > k)
            .toList()
            .isEmpty();
    }

    //15
    //Найти суммарный вес животных каждого вида, которым от k до l
    // лет -> Map<Animal.Type, Integer>
    public Map<Animal.Type, Integer> task15(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() > k && animal.age() < l)
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.summingInt(Animal::weight)
            ));
    }

    //16
    //Список животных, отсортированный по виду,
    // затем по полу, затем по имени -> List<Animal>
    public List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    //17
    //Правда ли, что пауки кусаются чаще, чем собаки -> Boolean (если
    // данных для ответа недостаточно, вернуть false)
    public boolean task17(List<Animal> animals) {
        int sbites = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .toList().size();
        int dbites = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .toList().size();
        if (sbites == 0 || dbites == 0) {
            return false;
        }
        return sbites > dbites;
    }

    //18
    //Найти самую тяжелую рыбку в 2-х или более списках -> Animal
    public Animal task18(List<Animal>... animals) {
        return Stream.of(animals)
            .flatMap(Collection::stream)
            .toList()
            .stream()
            .filter(animal -> animal.type().equals(Animal.Type.FISH))
            .max(Comparator.comparing(Animal::weight))
            .orElse(null);
    }

    //19
    //Животные, в записях о которых есть ошибки: вернуть имя и
    // список ошибок -> Map<String, Set<ValidationError>>.
    //
    //Класс ValidationError и набор потенциальных проверок нужно
    // придумать самостоятельно.
    public Map<String, Set<ValidationError>> task19(List<Animal> animals) {
        Map<String, Set<ValidationError>> mapOfErrorForEachAnimal = new HashMap<>();
        animals.stream()
            .forEach((animal) -> {
                if (!(new ValidationError().check(animal).isEmpty())) {
                    mapOfErrorForEachAnimal.put(animal.name(), new ValidationError().check(animal));
                }
            });
        return mapOfErrorForEachAnimal;
    }

    //20
    //Сделать результат предыдущего задания более читабельным:
    // вернуть имя и названия полей с ошибками, объединенные в
    // строку -> Map<String, String>
    public Map<String, String> task20(List<Animal> animals) {
        Map<String, String> mapOfErrorForEachAnimal = new HashMap<>();
        animals.stream()
            .forEach((animal) -> {
                if (!(new ValidationError().checkUpdate(animal).isEmpty())) {
                    mapOfErrorForEachAnimal.put(animal.name(), new ValidationError().checkUpdate(animal));
                }
            });
        return mapOfErrorForEachAnimal;
    }
}
