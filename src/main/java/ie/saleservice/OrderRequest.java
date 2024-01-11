package ie.saleservice;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @Valid
    private OrderDetails orderDetails;

    @Valid
    private Customer customer;
}
