package edu.hw4;

import edu.hw1.Task2;
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
        Animal anim1=new Animal("1", Animal.Type.CAT,  Animal.Sex.M, 10, 35, 40, true);
        Animal anim2=new Animal("2", Animal.Type.CAT,  Animal.Sex.M, 10, 30, 40, true);
        Animal anim3=new Animal("3", Animal.Type.CAT,  Animal.Sex.M, 10, 40, 40, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3);
        String actual = task.task1(list).toString();
        String expected = "[Animal[name=2, type=CAT, sex=M, age=10, height=30, weight=40, bites=true], Animal[name=1, type=CAT, sex=M, age=10, height=35, weight=40, bites=true], Animal[name=3, type=CAT, sex=M, age=10, height=40, weight=40, bites=true]]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("2 задание")
    void task2() {
        Task task = new Task();
        Animal anim1=new Animal("1", Animal.Type.CAT,  Animal.Sex.M, 10, 35, 40, true);
        Animal anim2=new Animal("2", Animal.Type.CAT,  Animal.Sex.M, 10, 30, 45, true);
        Animal anim3=new Animal("3", Animal.Type.CAT,  Animal.Sex.M, 10, 40, 50, true);
        List<Animal> list = Arrays.asList(anim1, anim2, anim3);
        String actual = task.task1(list).toString();
        String expected = "[Animal[name=2, type=CAT, sex=M, age=10, height=30, weight=45, bites=true], Animal[name=1, type=CAT, sex=M, age=10, height=35, weight=40, bites=true], Animal[name=3, type=CAT, sex=M, age=10, height=40, weight=50, bites=true]";
        assertEquals(expected, actual);
    }
}
