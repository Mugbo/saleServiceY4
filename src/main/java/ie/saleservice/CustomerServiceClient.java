package ie.saleservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


    @FeignClient(name = "customer-service", url = "http://localhost:8081") // Adjust the URL accordingly
    public interface CustomerServiceClient {

        @PostMapping("/calculateDelivery")
        DeliveryInfo calculateDelivery(@RequestBody Customer customer);
    }

