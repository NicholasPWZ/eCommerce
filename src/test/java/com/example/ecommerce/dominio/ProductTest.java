package com.example.ecommerce.dominio;

import com.example.ecommerce.infra.Exception.InvalidDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ProductTest {
    @Test
    public void ShouldCreateAProduct(){
        Long id= 1234L;
        String name = "product";
        String description = "description";
        Double value = 99.99;
        Product model = new Product(id,name,description,value   );
        Assertions.assertEquals(model.getId(),id);
        Assertions.assertEquals(model.getName(),name);
        Assertions.assertEquals(model.getDescription(),description);
        Assertions.assertEquals(model.getValorUnitario(),value
        );
    }
    @Test
    public void ShouldCreateAInvalidProduct(){
        Long id= 1234L;
        String name = "";
        String description = "";
        Double value = 1.0;
        try {
            Product model = new Product(id,name,description,value);
        }catch (InvalidDomain e){
            Assertions.assertFalse(e.getMessage().isEmpty());
        }

    }
}
