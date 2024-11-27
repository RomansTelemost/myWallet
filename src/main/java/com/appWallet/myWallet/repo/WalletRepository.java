package com.appWallet.myWallet.repo;

import com.appWallet.myWallet.entity.Wallet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface WalletRepository extends CrudRepository<Wallet, Long> {

    List<Wallet> findById(UUID uuid);

}
