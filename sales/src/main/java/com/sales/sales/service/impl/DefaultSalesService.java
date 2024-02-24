package com.sales.sales.service.impl;

import com.sales.sales.dto.SaleTransactionDto;
import com.sales.sales.dto.SalesDto;
import com.sales.sales.model.*;
import com.sales.sales.repository.*;
import com.sales.sales.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Reem Gharib
 */
@RequiredArgsConstructor
@Service
public class DefaultSalesService implements SalesService {

    private final SalesRepository salesRepository;
    private final ClientRepository clientRepository;
    private final SellerRepository sellerRepository;
    private final ProductRepository productRepository;
    private final SalesTransactionRepository salesTransactionRepository;

    @Override
    public List<Sale> getAllSales() {

        return this.salesRepository.findAll();
    }

    @Override
    public SalesDto createSale(SalesDto salesDto) {

        Client client = clientRepository.findById(Long.valueOf(salesDto.getClientId()))
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        Seller seller = sellerRepository.findById(Long.valueOf(salesDto.getSellerId()))
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));

        double total = salesDto.getSaleTransactions()
                .stream()
                .mapToDouble(transaction -> transaction.getPrice() * transaction.getQuantity())
                .sum();

        salesDto.setTotal(total);

        List<SaleTransaction> transactions = new ArrayList<>();

        salesDto.getSaleTransactions()
                .stream()
                .map(saleTransactionDto -> {

                            Product product = this.productRepository.findById(Long.valueOf(saleTransactionDto.getProductId()))
                                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));
                    SaleTransaction saleTransaction =  SaleTransaction.builder()
                            .price(saleTransactionDto.getPrice())
                            .quantity(saleTransactionDto.getQuantity())
                            .product(product)
                            .build();

                            transactions.add(saleTransaction);
                            this.salesTransactionRepository.save(saleTransaction);
                            
                            return transactions;
                        }
                );

        Sale sale = Sale.builder()
                .creationDate(LocalDateTime.now())
                .total(total)
                .client(client)
                .seller(seller)
                .transactions(transactions).build();

        this.salesRepository.save(sale);
        return salesDto;
    }
}
