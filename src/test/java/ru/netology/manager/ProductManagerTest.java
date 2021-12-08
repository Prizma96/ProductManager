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
    private Book first = new Book(70, "Евгений Онегин", 520, "Александр Пушкин");
    private Book third = new Book(71, "Galaxy A10", 500, "Samsung Electronics");
    private Book fifth = new Book(72, "Капитанская дочка", 430, "Александр Пушкин");
    private Book sixth = new Book(73, "Samsung", 500, "Samsung Electronics");
    private Book eighth = new Book(74, "Война и мир", 800, "Лев Толстой");
    private Smartphone forth = new Smartphone(300, "Galaxy A10", 10000,"Samsung");
    private Smartphone second = new Smartphone(301, "Galaxy A10", 8000,"Samsung");
    private Smartphone seventh = new Smartphone(302, "3910", 1000,"Siemense");

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
        Product[] actual = manager.searchBy("Лев Толстой");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorIfSame() {
        Product[] expected = {first, fifth};
        Product[] actual = manager.searchBy("Александр Пушкин");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProductionIfOne() {
        Product[] expected = {seventh};
        Product[] actual = manager.searchBy("Siemense");

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
        Product[] actual = manager.searchBy("iPhone 11");

        assertArrayEquals(expected, actual);
    }

}