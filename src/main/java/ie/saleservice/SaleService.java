package ie.saleservice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    private final OrderServiceClient orderServiceClient;
    private final CustomerServiceClient customerServiceClient;

    @Autowired
    public SaleService(OrderServiceClient orderServiceClient, CustomerServiceClient customerServiceClient) {
        this.orderServiceClient = orderServiceClient;
        this.customerServiceClient = customerServiceClient;
    }

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
}
