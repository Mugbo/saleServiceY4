package ie.saleservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderServiceClient {
    @FeignClient(name = "product-service", url = "http://localhost:8082") // Adjust the URL accordingly
    public interface ProductServiceClient {

        @PostMapping("/calculatePrice")
        double calculatePrice(@RequestBody OrderDetails orderDetails);
    }
}
