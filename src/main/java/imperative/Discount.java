package imperative;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Discount {
    public static void main(String[] args) {
        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("25"),
                new BigDecimal("18"), new BigDecimal("35"),
                new BigDecimal("20"), new BigDecimal("55"),
                new BigDecimal("8"), new BigDecimal("105")
        );

        BigDecimal TotalDiscountedPrice = BigDecimal.ZERO;

        // 10% discount on prices grater than 20.

        //Imperative approach
        System.out.println("Imperative approach");
        for (BigDecimal price : prices){
            if(price.compareTo(BigDecimal.valueOf(20)) > 0){
                TotalDiscountedPrice = TotalDiscountedPrice.
                        add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println("Total of discounted prices = " + TotalDiscountedPrice);

        // Declarative approach
        final BigDecimal TotalDiscountedPrice2 = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of discounted prices = " + TotalDiscountedPrice2);
    }
}
