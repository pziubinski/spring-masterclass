package pl.training.shop.products;

import pl.training.shop.common.PagedResult;

public interface ProductRepository {

    Product save(Product product);

    PagedResult<Product> findAll(int pageNumber, int pageSize);

}
