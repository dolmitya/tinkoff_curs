package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task {
    public Task() {
    }

    //Отсортировать животных по росту от самого маленького к
    // самому большому -> List<Animal>
    public List<Animal> task1(List<Animal> animals) {
        List<Animal> result = animals.stream()
            .sorted((o1, o2) -> {
                if (o1.height() > o2.height()) {
                    return 1;
                } else if (o1.height() < o2.height()) {
                    return -1;
                }
                return 0;
            }).collect(Collectors.toList());
        return result;
    }

    //Отсортировать животных по весу от самого тяжелого к самому
    // легкому, выбрать k первых -> List<Animal>
    public List<Animal> task2(List<Animal> animals) {
        List<Animal> result = animals.stream()
            .sorted((o1, o2) -> {
                if (o1.weight() < o2.weight()) {
                    return 1;
                } else if (o1.weight() > o2.weight()) {
                    return -1;
                }
                return 0;
            }).collect(Collectors.toList());
        return result;
    }

    //Сколько животных каждого вида -> Map<Animal.Type, Integer>
    public Map<Animal.Type, Long> task3(List<Animal> animals) {
        Map<Animal.Type, Long> result = animals.stream().collect(
            Collectors.groupingBy(Animal::type, Collectors.counting()));
        return result;
    }

    //У какого животного самое длинное имя -> Animal
    public Animal task4(List<Animal> animals) {
        Animal result = animals.stream()
            .max(Comparator.comparing(animal -> animal.name().length()))
            .orElse(null);
        return result;
    }

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

    //Самое тяжелое животное каждого вида -> Map<Animal.Type, Animal>
    public Map<Animal.Type, Animal> task6(List<Animal> animals) {
        Map<Animal.Type, List<Animal>> map = animals.stream()
            .collect(Collectors.groupingBy(Animal::type));
        Map<Animal.Type, Animal> newMap = new HashMap<>();
        for (var it : map.entrySet()) {
            Animal animal = map.get(it.getKey())
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.weight() < o2.weight()) {
                        return 1;
                    } else if (o1.weight() > o2.weight()) {
                        return -1;
                    }
                    return 0;
                })
                .toList()
                .get(0);
            newMap.put(it.getKey(), animal);
        }
        return newMap;
    }

    //K-е самое старое животное -> Animal
    public Animal task7(List<Animal> animals, int k) {
        List<Animal> list = animals.stream()
            .sorted((o1, o2) -> {
                if (o1.age() < o2.age()) {
                    return 1;
                } else if (o1.age() > o2.age()) {
                    return -1;
                }
                return 0;
            }).collect(Collectors.toList());
        return (k > 0 && k < list.size()) ? list.get(k) : null;
    }

    //Самое тяжелое животное среди животных ниже k см ->
    // Optional<Animal>
    public Animal task8(List<Animal> animals, int k) {
        return animals.stream().filter(animal -> animal.height() < k)
            .max(Comparator.comparing(Animal::weight)).get();
    }

    //Сколько в сумме лап у животных в списке -> Integer
    public Integer task9(List<Animal> animals) {
        return animals.stream().collect(Collectors.summingInt(Animal::paws));
    }

    //Список животных, возраст у которых не совпадает с количеством
    // лап -> List<Animal>
    public List<Animal> task10(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.age() != animal.paws()).toList();
    }

    //Список животных, которые могут укусить (bites == null или true) и
    // рост которых превышает 100 см -> List<Animal>
    public List<Animal> task11(List<Animal> animals) {
        final int MAX_HEIGHT = 100;
        return animals.stream().filter(animal -> animal.bites() && animal.height() > MAX_HEIGHT).toList();
    }

    //Сколько в списке животных, вес которых превышает рост ->
    // Integer
    public Integer task12(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.weight() > animal.height()).toList().size();
    }

    //Список животных, имена которых состоят из более чем двух слов
    // -> List<Animal>
    public List<Animal> task13(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.name().indexOf(' ') > -1).toList();
    }

    //Есть ли в списке собака ростом более k см -> Boolean
    public boolean task14(List<Animal> animals, int k) {
        return !animals.stream().filter(animal -> animal.type() == Animal.Type.DOG
            && animal.height() > k).toList().isEmpty();
    }

    //Найти суммарный вес животных каждого вида, которым от k до l
    // лет -> Integer
    public Integer task15(List<Animal> animals, int k, int l) {
        return animals.stream().filter(animal -> animal.age() > k && animal.age() < l)
            .collect(Collectors.summingInt(Animal::weight));
    }

    //Список животных, отсортированный по виду,
    // затем по полу, затем по имени -> List<Animal>
    public List<Animal> task16(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

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

    //Найти самую тяжелую рыбку в 2-х или более списках -> Animal
    public Animal task18(List<List<Animal>> animals) {
        if (animals.isEmpty()) {
            return null;
        }
        Animal maxFish = null;
        Animal maxFish0 = animals.get(0).stream()
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparing(Animal::weight)).get();
        for (int i = 1; i < animals.size(); i++) {
            if (maxFish0 == animals.get(i).stream()
                .filter(animal -> animal.type() == Animal.Type.FISH)
                .max(Comparator.comparing(Animal::weight)).get()) {
                maxFish = maxFish0;
            }

            if (maxFish0.weight() < animals.get(i).stream()
                .filter(animal -> animal.type() == Animal.Type.FISH)
                .max(Comparator.comparing(Animal::weight)).get().weight()) {
                maxFish0 = animals.get(i).stream()
                    .filter(animal -> animal.type() == Animal.Type.FISH)
                    .max(Comparator.comparing(Animal::weight)).get();
            }
        }
        return maxFish;
    }

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
