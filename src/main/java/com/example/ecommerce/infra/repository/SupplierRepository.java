package com.example.ecommerce.infra.repository;

import com.example.ecommerce.dominio.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT count(s) FROM Supplier s WHERE s.cnpj = :cnpj")
    public int validateCnpj(@Param("cnpj")String cnpj);
}
