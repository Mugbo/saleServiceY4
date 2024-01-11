package ie.saleservice;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderDetailsTest {
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void testValidOrderDetails(){
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setQuantity(3);
        orderDetails.setProductType("Socks");

        assertTrue(validator.validate(orderDetails).isEmpty());
    }

    @Test
    public void testInvalidOrderDetails(){
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setQuantity(-1);
        orderDetails.setProductType("this is not a product type you know");

        assertEquals(2,validator.validate(orderDetails).size());
    }
}
