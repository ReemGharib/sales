package com.sales.sales.repository;

import com.sales.sales.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Reem Gharib
 */
@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
