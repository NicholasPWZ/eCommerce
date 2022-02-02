package com.example.ecommerce.servico;

import com.example.ecommerce.dominio.Costumer;
import com.example.ecommerce.infra.Exception.CpfAlreadyRegistered;
import com.example.ecommerce.infra.repository.CostumerRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class CostumerService {
    private CostumerRepository repository;
    public CostumerService (CostumerRepository repository){
        this.repository = repository;
    }

    public void save(@Valid  Costumer newCostumer){
        validateDuplicatedCostumer(newCostumer);
         repository.save(newCostumer);
    }
    public void validateDuplicatedCostumer(Costumer costumer){
     int qtd = repository.validarPorCpf(costumer.getCpf());
     if(qtd != 0){
            throw new CpfAlreadyRegistered("This CPF is already registered");
     }
    }
    public List<Costumer> find(){
        return repository.findAll();
    }

}
