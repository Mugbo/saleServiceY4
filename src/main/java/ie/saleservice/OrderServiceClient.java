package ie.saleservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

    @FeignClient(name = "order-service", url = "${order-service.url}") // Adjust the URL accordingly
    public interface OrderServiceClient {

        @PostMapping("/calculatePrice")
        double calculatePrice(@RequestBody OrderDetails orderDetails);
    }

