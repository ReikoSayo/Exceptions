package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    ShopRepository shopRepository = new ShopRepository();
    Product Product1 = new Product(1, "Хлеб", 65);
    Product Product2 = new Product(5, "Молоко", 80);
    Product Product3 = new Product(23, "Яйца", 250);

    @BeforeEach
    public void addThreeProduct() {
        shopRepository.add(Product1);
        shopRepository.add(Product2);
        shopRepository.add(Product3);
    }

    @Test
    public void removeTest() {
        shopRepository.remove(5);

        Product[] expected = {Product1, Product3};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundExceptionTest() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(7);
        });
    }

    @Test
    public void addDoubleTest() {
        Product Product4 = new Product(23, "Сосиски", 450);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(Product4);
        });
    }

    @Test
    public void addWithFindIdTest() {
        Product Product4 = new Product(29, "Сосиски", 450);
        shopRepository.add(Product4);
        Product[] expected = {Product1, Product2, Product3, Product4};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}