package ie.saleservice;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class CustomerTests {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void testValidCustomer(){
        Customer customer = new Customer();
        customer.setRegion("US");

        assertTrue(validator.validate(customer).isEmpty());
    }

    @Test
    public void testInvalidCustomer(){
        Customer customer = new Customer();
        customer.setRegion("Invalid region not available");

        assertEquals(1,validator.validate(customer).size());
    }


}
