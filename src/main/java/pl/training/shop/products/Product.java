package pl.training.shop.products;

import lombok.Builder;
import lombok.Data;
import org.javamoney.moneta.FastMoney;

@Builder
@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private FastMoney price;
    private ProductType type;

}
