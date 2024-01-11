package ie.saleservice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class SaleController {


    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/createOrder")
    public SalesOrder createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        Customer customer = orderRequest.getCustomer();
        OrderDetails orderDetails = orderRequest.getOrderDetails();

        return saleService.createOrder(customer, orderDetails);
    }


}
