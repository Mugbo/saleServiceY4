package ie.saleservice;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {
    private final SaleService saleService;
    private final CustomerServiceClient customerServiceClient;
    private final OrderServiceClient orderServiceClient;

    public SaleController(SaleService saleService, CustomerServiceClient customerServiceClient, OrderServiceClient orderServiceClient) {
        this.saleService = saleService;
        this.customerServiceClient = customerServiceClient;
        this.orderServiceClient = orderServiceClient;
    }




}
