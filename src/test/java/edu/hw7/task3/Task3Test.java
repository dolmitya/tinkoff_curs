package edu.hw7.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    private static final PersonDatabaseImpl PERSON_DATABASE = new PersonDatabaseImpl();

    private final Thread thread1 = new Thread(() -> {
        PERSON_DATABASE.add(new Person(0, "Alexandr", "Kostyliev", "12345"));
        PERSON_DATABASE.add(new Person(1, "Denis", "Sharipov", "54321"));
        PERSON_DATABASE.add(new Person(2, null, "D", "5"));
    });

    private final Thread thread2 = new Thread(() -> {
        PERSON_DATABASE.add(new Person(3, "Egor", "Vasilyev", "67890"));
        PERSON_DATABASE.add(new Person(4, "Kirill", "Mikhailov", "09876"));
        PERSON_DATABASE.add(new Person(5, "V", null, "0"));
    });

    @BeforeEach
    void setUp(){
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Все записи добавляются")
    void test1(){
        assertEquals(6, PERSON_DATABASE.size());
    }

    @Test
    @DisplayName("Запись найдется если у неё есть все атрибуты")
    void test2(){
        assertNotNull(PERSON_DATABASE.findByName("Alexandr"));
    }

    @Test
    @DisplayName("Запись не найдется если у неё есть не все атрибуты")
    void test3(){
        assertNull(PERSON_DATABASE.findByName("V"));
    }

    @Test
    @DisplayName("При удалении запись действительно удаляется")
    void test4(){
        PERSON_DATABASE.delete(0);
        assertEquals(5, PERSON_DATABASE.size());
    }

    @Test
    @DisplayName("При удалении несуществующей записи ничего не происходит")
    void test5(){
        PERSON_DATABASE.delete(6);
        assertEquals(6, PERSON_DATABASE.size());
    }

    @Test
    @DisplayName("При многопоточном удалении все удаляемые записи удаляются")
    void test6(){
        Thread thread1 = new Thread(() -> {
            PERSON_DATABASE.delete(0);
            PERSON_DATABASE.delete(1);
            PERSON_DATABASE.delete(2);
        });
        Thread thread2 = new Thread(() -> {
            PERSON_DATABASE.delete(3);
            PERSON_DATABASE.delete(4);
            PERSON_DATABASE.delete(5);
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(0, PERSON_DATABASE.size());
    }
}
