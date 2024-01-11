package ie.saleservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesOrderRepo extends JpaRepository<SalesOrder, Long> {
    List<SalesOrder> findByProductType(String productType);
    List<SalesOrder> findByRegion(String region);
    List<SalesOrder> findByQuantity(int quantity);
    List<SalesOrder> findByTotalPrice(double totalPrice);

}
