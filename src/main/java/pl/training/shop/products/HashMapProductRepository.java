package pl.training.shop.products;

import pl.training.shop.common.PagedResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapProductRepository implements ProductRepository {

    private Map<Long, Product> products = new HashMap<>();
    private long index = 0;


    @Override
    public Product save(Product product) {
        product.setId(++index);
        products.put(index, product);
        return product;
    }

    @Override
    public PagedResult<Product> findAll(int pageNumber, int pageSize) {
        var totalPages = (int) Math.ceil((double) products.size() / pageSize);
        var data = new ArrayList<>(products.values());
        return new PagedResult<>(data, pageNumber, totalPages);
    }
}
