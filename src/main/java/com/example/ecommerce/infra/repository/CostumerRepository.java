package com.example.ecommerce.infra.repository;

import com.example.ecommerce.dominio.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostumerRepository  extends JpaRepository<Costumer,Long> {

    @Query("SELECT count(c) FROM Costumer c where c.cpf = :cpf")
    public int validarPorCpf(@Param("cpf")String cpf);


}
