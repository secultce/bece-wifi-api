package com.bece.wifi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bece.wifi.api.entities.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer>{

}
