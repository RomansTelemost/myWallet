package com.appWallet.myWallet.controller;

import com.appWallet.myWallet.entity.Wallet;
import com.appWallet.myWallet.repo.WalletRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class WalletControllerTest {

    @Autowired
    WalletRepository walletRepository;

    private final UUID uuid = UUID.randomUUID();

    @Test
    public void addNewWallet() {
        Assertions.assertNotNull(walletRepository);
        walletRepository.save(getWallet());
//        Wallet wallet = Optional.of(walletRepository.findById(uuid)).orElse(null);
//        Assertions.assertNotNull(wallet);
//        Assertions.assertEquals(wallet.getId(), uuid);
    }

    private Wallet getWallet() {
        Wallet wallet = new Wallet();
//        wallet.setId(uuid);
        wallet.setBalance(new BigDecimal(0));
        return wallet;
    }

}