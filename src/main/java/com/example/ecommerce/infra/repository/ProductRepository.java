package com.example.ecommerce.infra.repository;

import com.example.ecommerce.dominio.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT count(p) FROM Product p WHERE p.name = :name")
    public int validateDuplicated(@Param("name")String name);
}
