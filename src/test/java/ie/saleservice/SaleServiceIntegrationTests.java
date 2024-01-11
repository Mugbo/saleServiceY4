//package ie.saleservice;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class SaleServiceIntegrationTests {
//    private final MockMvc mockMvc;
//    private final ObjectMapper objectMapper;
//
//    @Autowired
//    public SaleServiceIntegrationTests(MockMvc mockMvc, ObjectMapper objectMapper)
//    {
//        this.mockMvc = mockMvc;
//        this.objectMapper = objectMapper;
//
//    }
//    @Test
//    public void testValidSaleController() throws Exception {
//        SalesOrder salesOrder = new SalesOrder();
//        salesOrder.setDeliveryPrice(60);
//        salesOrder.setQuantity(5);
//        salesOrder.setDeliveryTime(12);
//        salesOrder.setTotalPrice(200);
//        salesOrder.setProductPrice(140);
//        salesOrder.setProductType("Shoes");
//
//        String requestBody = objectMapper.writeValueAsString(salesOrder);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/createOrder")
//                        .content(requestBody)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.productType").value("Shoes"));
//    }
//
//    @Test
//    public void testInvalidSaleController() throws Exception {
//        SalesOrder salesOrder = new SalesOrder();
//        salesOrder.setDeliveryPrice(-1);
//        salesOrder.setQuantity(-5);
//        salesOrder.setDeliveryTime(-45);
//        salesOrder.setTotalPrice(-1);
//        salesOrder.setProductPrice(-20);
//        salesOrder.setProductType("cats");
//
//        String requestBody = objectMapper.writeValueAsString(salesOrder);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/createOrder")
//                        .content(requestBody)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest());
//    }
//
//}
