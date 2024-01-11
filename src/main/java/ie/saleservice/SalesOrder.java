package ie.saleservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SalesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product type must not be blank")
    private String productType;

    @Positive(message = "Quantity must be a positive integer")
    private int quantity;

    @PositiveOrZero(message = "Product price must be a positive number or zero")
    private double productPrice;

    @Min(value = 0, message = "Delivery time must be greater than or equal to 0")
    private int deliveryTime;

    @PositiveOrZero(message = "Delivery price must be a positive number or zero")
    private double deliveryPrice;

    @PositiveOrZero(message = "Total price must be a positive number or zero")
    private double totalPrice;
}
