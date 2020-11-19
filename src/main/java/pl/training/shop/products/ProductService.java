package pl.training.shop.products;

import lombok.RequiredArgsConstructor;
import pl.training.shop.common.PagedResult;
import pl.training.shop.common.retry.Retry;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Retry
    public Product add(Product product) {
        throw new RuntimeException();
        //return productRepository.save(product);
    }

    public PagedResult<Product> getAll(int pageNumber, int pageSize) {
        return productRepository.findAll(pageNumber, pageSize);
    }

}
