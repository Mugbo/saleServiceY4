package ie.saleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    private OrderServiceClient orderServiceClient;
    private CustomerServiceClient customerServiceClient;

    public SalesOrder createSalesOrder(OrderDetails orderDetails, Customer customer) {
        double productPrice = orderDetails.calculateProductPrice(orderDetails);
        DeliveryInfo deliveryInfo = deliveryServiceClient.calculateDeliveryInfo(customerLocation);

        // Assuming a simple sales order creation logic
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setProductType(productVariable.getProductType());
        salesOrder.setQuantity(productVariable.getQuantity());
        salesOrder.setProductPrice(productPrice);
        salesOrder.setDeliveryTime(deliveryInfo.getDeliveryTime());
        salesOrder.setDeliveryPrice(deliveryInfo.getDeliveryPrice());
        salesOrder.calculateTotalPrice(); // Assuming a method to calculate total price

        return salesOrder;
    }
}
