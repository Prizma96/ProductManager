package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager(new ProductRepository());
    private Book first = new Book(88, "Евгений Онегин", 320, "Евгения Некрасова");
    private Book third = new Book(89, "Galaxy A10", 500, "Peter Pan");
    private Book fifth = new Book(90, "Дом вверх дном", 430, "Евгения Некрасова");
    private Book sixth = new Book(91, "Samsung", 500, "Peter Pan");
    private Book eighth = new Book(92, "Дом", 800, "Иван Бунин");
    private Smartphone forth = new Smartphone(321, "Galaxy A10", 10000,"Samsung");
    private Smartphone second = new Smartphone(123, "Galaxy A10", 8000,"Samsung");
    private Smartphone seventh = new Smartphone(231, "3310", 1000,"Nokia");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
    }

    @Test
    public void shouldSearchByNameIfOne() {
        Product[] expected = {first};
        Product[] actual = manager.searchBy("Евгений Онегин");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameIfSame() {
        Product[] expected = {second, third, forth};
        Product[] actual = manager.searchBy("Galaxy A10");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorIfOne() {
        Product[] expected = {eighth};
        Product[] actual = manager.searchBy("Иван Бунин");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorIfSame() {
        Product[] expected = {first, fifth};
        Product[] actual = manager.searchBy("Евгения Некрасова");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProductionIfOne() {
        Product[] expected = {seventh};
        Product[] actual = manager.searchBy("Nokia");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProductionIfSame() {
        Product[] expected = {second, forth, sixth};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFictionName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("iPhone 12");

        assertArrayEquals(expected, actual);
    }

}