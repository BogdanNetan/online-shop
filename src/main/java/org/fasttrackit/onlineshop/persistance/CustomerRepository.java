package org.fasttrackit.onlineshop.persistance;

import org.fasttrackit.onlineshop.domain.Customer;
import org.fasttrackit.onlineshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}



