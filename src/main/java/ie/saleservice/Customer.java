package ie.saleservice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @NotBlank(message = "Region must not be blank")
    @Size(min = 2, max = 10, message = "Region must be between 2 and 10 characters")
    private String region;

}
