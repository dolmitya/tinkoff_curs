package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    @DisplayName("1 задание")
    void task1() {
        Task task = new Task();
        Animal anim1 = new Animal("1", Animal.Type.CAT, Animal.Sex.M, 10, 35, 40, true);
        Animal anim2 = new Animal("2", Animal.Type.CAT, Animal.Sex.M, 10, 30, 40, true);
        Animal anim3 = new Animal("3", Animal.Type.CAT, Animal.Sex.M, 10, 40, 40, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3);
        String actual = task.task1(list).toString();
        String expected = "[Animal[name=2, type=CAT, sex=M, age=10, height=30, weight=40, bites=true], " +
            "Animal[name=1, type=CAT, sex=M, age=10, height=35, weight=40, bites=true], " +
            "Animal[name=3, type=CAT, sex=M, age=10, height=40, weight=40, bites=true]]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("2 задание")
    void task2() {
        Task task = new Task();
        Animal anim1 = new Animal("1", Animal.Type.CAT, Animal.Sex.M, 10, 35, 40, true);
        Animal anim2 = new Animal("2", Animal.Type.CAT, Animal.Sex.M, 10, 30, 45, true);
        Animal anim3 = new Animal("3", Animal.Type.CAT, Animal.Sex.M, 10, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3);
        String actual = task.task2(list).toString();
        String expected = "[Animal[name=3, type=CAT, sex=M, age=10, height=40, weight=50, bites=true], " +
            "Animal[name=2, type=CAT, sex=M, age=10, height=30, weight=45, bites=true], " +
            "Animal[name=1, type=CAT, sex=M, age=10, height=35, weight=40, bites=true]]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("3 задание")
    void task3() {
        Task task = new Task();
        Animal anim1 = new Animal("1", Animal.Type.CAT, Animal.Sex.M, 10, 35, 40, true);
        Animal anim2 = new Animal("2", Animal.Type.CAT, Animal.Sex.M, 10, 30, 45, true);
        Animal anim3 = new Animal("3", Animal.Type.CAT, Animal.Sex.M, 10, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3);
        String actual = task.task3(list).toString();
        String expected = "{CAT=3}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("4 задание")
    void task4() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 10, 35, 40, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.M, 10, 30, 45, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.CAT, Animal.Sex.M, 10, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3);
        String actual = task.task4(list).toString();
        String expected = "Animal[name=Pushoki, type=CAT, sex=M, age=10, height=40, weight=50, bites=true]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("5 задание")
    void task5() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 10, 35, 40, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 30, 45, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.CAT, Animal.Sex.M, 10, 40, 50, true);
        Animal anim4 = new Animal("Pushoki", Animal.Type.CAT, Animal.Sex.F, 10, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        Animal.Sex actual = task.task5(list);
        Animal.Sex expected = null;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("6 задание")
    void task6() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 10, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 30, 45, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 10, 40, 50, true);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 10, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        String actual = task.task6(list).toString();
        String expected =
            "{CAT=Optional[Animal[name=Barsik, type=CAT, sex=M, age=10, height=35, weight=50, bites=true]], " +
                "DOG=Optional[Animal[name=Pushoki, type=DOG, sex=M, age=10, height=40, weight=50, bites=true]], " +
                "FISH=Optional[Animal[name=Pushoki, type=FISH, sex=F, age=10, height=40, weight=50, bites=true]]}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("7 задание")
    void task7() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 12, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 30, 45, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 11, 40, 50, true);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        String actual = task.task7(list, 2).toString();
        String expected = "Animal[name=Pushoki, type=DOG, sex=M, age=11, height=40, weight=50, bites=true]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("8 задание")
    void task8() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 12, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 30, 55, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 11, 39, 50, true);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        String actual = task.task8(list, 40).toString();
        String expected = "Animal[name=Sasha, type=CAT, sex=F, age=10, height=30, weight=55, bites=true]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("9 задание")
    void task9() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 12, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 30, 55, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 11, 39, 50, true);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        Integer actual = task.task9(list);
        Integer expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("10 задание")
    void task10() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 4, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 30, 55, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 4, 39, 50, true);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        String actual = task.task10(list).toString();
        String expected = "[Animal[name=Sasha, type=CAT, sex=F, age=10, height=30, weight=55, bites=true], " +
            "Animal[name=Pushoki, type=FISH, sex=F, age=15, height=40, weight=50, bites=true]]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("11 задание")
    void task11() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 4, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 101, 55, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 4, 460, 50, false);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        String actual = task.task11(list).toString();
        String expected = "[Animal[name=Sasha, type=CAT, sex=F, age=10, height=101, weight=55, bites=true], " +
            "Animal[name=Pushoki, type=FISH, sex=F, age=15, height=120, weight=50, bites=true]]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("12 задание")
    void task12() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 4, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 101, 55, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 4, 460, 50, false);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        Integer actual = task.task12(list);
        Integer expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("13 задание")
    void task13() {
        Task task = new Task();
        Animal anim1 = new Animal("Bar sik", Animal.Type.CAT, Animal.Sex.M, 4, 35, 50, true);
        Animal anim2 = new Animal("Sa sh a", Animal.Type.CAT, Animal.Sex.F, 10, 101, 55, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 4, 460, 50, false);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        String actual = task.task13(list).toString();
        String expected = "[Animal[name=Bar sik, type=CAT, sex=M, age=4, height=35, weight=50, bites=true], " +
            "Animal[name=Sa sh a, type=CAT, sex=F, age=10, height=101, weight=55, bites=true]]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("14 задание")
    void task14() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 4, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 101, 55, true);
        Animal anim3 = new Animal("Pushok", Animal.Type.DOG, Animal.Sex.M, 4, 460, 50, false);
        Animal anim4 = new Animal("Sashok", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        boolean actual = task.task14(list, 450);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("15 задание")
    void task15() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 4, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 101, 55, true);
        Animal anim3 = new Animal("Pushok", Animal.Type.DOG, Animal.Sex.M, 4, 460, 50, false);
        Animal anim4 = new Animal("Sashok", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        Integer actual = task.task15(list, 9, 16);
        Integer expected = 105;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("16 задание")
    void task16() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 4, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.CAT, Animal.Sex.F, 10, 101, 55, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 4, 460, 50, false);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        String actual = task.task16(list).toString();
        String expected = "[Animal[name=Barsik, type=CAT, sex=M, age=4, height=35, weight=50, bites=true], " +
            "Animal[name=Pushoki, type=DOG, sex=M, age=4, height=460, weight=50, bites=false], " +
            "Animal[name=Pushoki, type=FISH, sex=F, age=15, height=120, weight=50, bites=true], " +
            "Animal[name=Sasha, type=CAT, sex=F, age=10, height=101, weight=55, bites=true]]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("17 задание")
    void task17() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.SPIDER, Animal.Sex.M, 4, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.SPIDER, Animal.Sex.F, 10, 101, 55, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.M, 4, 460, 50, false);
        Animal anim4 = new Animal("Pushoki", Animal.Type.DOG, Animal.Sex.F, 15, 120, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3, anim4);
        boolean actual = task.task17(list);
        assertTrue(actual);
    }

    @Test
    @DisplayName("18 задание")
    void task18() {
        Task task = new Task();
        Animal anim1 = new Animal("Barsik", Animal.Type.FISH, Animal.Sex.M, 4, 35, 50, true);
        Animal anim2 = new Animal("Sasha", Animal.Type.FISH, Animal.Sex.F, 10, 101, 55, true);
        Animal anim3 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.M, 4, 460, 50, false);
        Animal anim4 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        Animal anim5 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        Animal anim6 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        Animal anim7 = new Animal("Pushoki", Animal.Type.FISH, Animal.Sex.F, 15, 120, 50, true);
        List<Animal> list1 = Arrays.asList(anim1, anim2, anim3, anim4);
        List<Animal> list2 = Arrays.asList(anim2, anim3, anim4, anim5);
        List<Animal> list3 = Arrays.asList(anim4, anim5, anim6, anim7);
        List<List<Animal>> list = Arrays.asList(list1, list2, list3);
        Animal actual = task.task18(list);
        Animal expected = anim2;
        assertEquals(expected, actual);
    }
}
