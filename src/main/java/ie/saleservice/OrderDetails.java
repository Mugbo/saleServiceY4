package ie.saleservice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @NotBlank(message = "Product type must not be blank")
    private String productType;

    @Positive(message = "Quantity must be a positive integer")
    private int quantity;
}
