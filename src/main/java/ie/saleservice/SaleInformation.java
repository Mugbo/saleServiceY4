package ie.saleservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleInformation {
    private String name;
    private String email;
    private int age;
    private String address;
    private String phoneNumber;

    private float cost;
}
