package ie.saleservice;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryInfoTests {
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void testValidDeliveryInfo(){
        DeliveryInfo deliveryInfo = new DeliveryInfo();
        deliveryInfo.setDeliveryPrice(30);
        deliveryInfo.setDeliveryTime(12);

        assertTrue(validator.validate(deliveryInfo).isEmpty());
    }

    @Test
    public void testInvalidDeliveryInfo(){
        DeliveryInfo deliveryInfo = new DeliveryInfo();
        deliveryInfo.setDeliveryPrice(-10);
        deliveryInfo.setDeliveryTime(-13);

        assertEquals(2,validator.validate(deliveryInfo).size());
    }
}
