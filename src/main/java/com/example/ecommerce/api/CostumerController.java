package com.example.ecommerce.api;

import com.example.ecommerce.dominio.Costumer;
import com.example.ecommerce.servico.CostumerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/costumer")
public class CostumerController {
    private CostumerService costumerService;

        public CostumerController(CostumerService costumerService){
            this.costumerService = costumerService;
        }
        @PostMapping
        public void save(@RequestBody @Valid Costumer newCostumer ){
            costumerService.save(newCostumer);
        }

        @GetMapping
        public List<Costumer> find(){
            return costumerService.find();
        }
}
