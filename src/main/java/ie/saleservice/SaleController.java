package ie.saleservice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class SaleController {


    private final SaleService saleService;
    private final SalesOrderRepo salesOrderRepo;


    @Autowired
    public SaleController(SaleService saleService, SalesOrderRepo salesOrderRepo) {
        this.saleService = saleService;
        this.salesOrderRepo = salesOrderRepo;
    }

    @PostMapping("/createOrder")
    public SalesOrder createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        Customer customer = orderRequest.getCustomer();
        OrderDetails orderDetails = orderRequest.getOrderDetails();

        SalesOrder salesOrder = saleService.createOrder(customer, orderDetails);

        saleService.saveSalesOrder(salesOrder);

        return salesOrder;
    }

    @GetMapping("/byProductType/{productType}")
    public List<SalesOrder> getSalesOrdersByProductType(@PathVariable String productType) {
        return salesOrderRepo.findByProductType(productType);
    }
    @GetMapping("/byRegion/{region}")
    public List<SalesOrder> getSalesOrdersByRegion(@PathVariable String region) {
        return salesOrderRepo.findByRegion(region);
    }
    @GetMapping("/byQuantity/{quantity}")
    public List<SalesOrder> getSalesOrdersByQuantity(@PathVariable int quantity) {
        return salesOrderRepo.findByQuantity(quantity);
    }
    @GetMapping("/byTotalPrice/{totalPrice}")
    public List<SalesOrder> getSalesOrdersByTotalPrice(@PathVariable double totalPrice) {
        return salesOrderRepo.findByTotalPrice(totalPrice);
    }


}
