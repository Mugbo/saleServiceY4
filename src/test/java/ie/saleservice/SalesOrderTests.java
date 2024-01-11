package ie.saleservice;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalesOrderTests {
    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void testValidSalesOrder(){
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setProductType("Shoes");
        salesOrder.setDeliveryPrice(20);
        salesOrder.setQuantity(12);
        salesOrder.setTotalPrice(120);
        salesOrder.setProductPrice(22);
        salesOrder.setDeliveryTime(10);
        salesOrder.setRegion("US");

        assertTrue(validator.validate(salesOrder).isEmpty());
    }
    @Test
    public void testInvalidSalesOrder(){
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setDeliveryPrice(-1);
        salesOrder.setQuantity(-1);
        salesOrder.setTotalPrice(-1);
        salesOrder.setProductPrice(-1);
        salesOrder.setDeliveryTime(-1);

        assertEquals(7,validator.validate(salesOrder).size());
    }
}
