package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Not;

public class ShopRepositoryTest {
    Product product1 = new Product(1, "чай", 150);
    Product product2 = new Product(2, "кофе", 250);
    Product product3 = new Product(3, "сок", 170);

    @Test
    public void DeleteAnExistingItem() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void DeleteNotExistentElement() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4)
        );
    }
}
