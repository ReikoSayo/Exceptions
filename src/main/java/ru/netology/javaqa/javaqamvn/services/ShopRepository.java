package ru.netology.javaqa.javaqamvn.services;

public class ShopRepository {
    private Product[] products = new Product[0];

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public void add(Product product) {
        Product prodfind = findById(product.getId());
        if (prodfind == null) {
            products = addToArray(products, product);
        } else {
            throw new AlreadyExistsException(
                    "Element with id: " + product.getId() + " found in Shop Repository");
        }
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void remove(int id) {
        Product productdelete = findById(id);
        if (productdelete == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}