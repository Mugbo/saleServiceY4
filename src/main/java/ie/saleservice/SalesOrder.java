package ie.saleservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrder {
    private String productType;
    private int quantity;
    private double productPrice;
    private int deliveryTime;
    private double deliveryPrice;
    private double totalPrice;
}
