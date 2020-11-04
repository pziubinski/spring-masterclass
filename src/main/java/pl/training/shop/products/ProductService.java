package pl.training.shop.products;

import lombok.RequiredArgsConstructor;
import pl.training.shop.common.PagedResult;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public PagedResult<Product> getAll(int pageNumber, int pageSize) {
        return productRepository.findAll(pageNumber, pageSize);
    }

}
