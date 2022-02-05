package com.example.ecommerce.servico;

import com.example.ecommerce.dominio.Supplier;
import com.example.ecommerce.infra.Exception.CnpjAlreadyRegistered;
import com.example.ecommerce.infra.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private SupplierRepository repository;
    public SupplierService(SupplierRepository repository){
        this.repository = repository;
    }
    public void save(Supplier newSupplier){
        validateDuplicated(newSupplier);
        repository.save(newSupplier);
    }
    public void validateDuplicated(Supplier supplier){
        int qtd = repository.validateCnpj(supplier.getCnpj());
        if(qtd != 0 ){
            throw new CnpjAlreadyRegistered("Cnpj already registered");
        }
    }
    public List<Supplier> findAll(){
        return repository.findAll();
    }
}
