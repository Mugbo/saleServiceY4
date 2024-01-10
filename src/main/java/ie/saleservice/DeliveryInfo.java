package ie.saleservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryInfo {
    private int deliveryTime;
    private double deliveryPrice;
}
