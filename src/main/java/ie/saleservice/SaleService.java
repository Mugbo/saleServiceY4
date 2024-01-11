package ie.saleservice;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    private final OrderServiceClient orderServiceClient;
    private final CustomerServiceClient customerServiceClient;

    private final SalesOrderRepo salesOrderRepo;

    @Autowired
    public SaleService(OrderServiceClient orderServiceClient, CustomerServiceClient customerServiceClient, SalesOrderRepo salesOrderRepo) {
        this.orderServiceClient = orderServiceClient;
        this.customerServiceClient = customerServiceClient;
        this.salesOrderRepo = salesOrderRepo;
    }

    @Transactional
    public SalesOrder createOrder(@Valid Customer customer, @Valid OrderDetails orderDetails) {
        double productPrice = orderServiceClient.calculatePrice(orderDetails);

        DeliveryInfo deliveryInfo = customerServiceClient.calculateDelivery(customer);

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setProductType(orderDetails.getProductType());
        salesOrder.setQuantity(orderDetails.getQuantity());
        salesOrder.setProductPrice(productPrice);
        salesOrder.setDeliveryTime(deliveryInfo.getDeliveryTime());
        salesOrder.setDeliveryPrice(deliveryInfo.getDeliveryPrice());
        salesOrder.setTotalPrice(productPrice + deliveryInfo.getDeliveryPrice());

        return salesOrder;
    }

    @Transactional
    public void saveSalesOrder(SalesOrder salesOrder){
        salesOrderRepo.save(salesOrder);
    }
}
