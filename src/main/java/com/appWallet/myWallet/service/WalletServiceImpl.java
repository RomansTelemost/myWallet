package com.appWallet.myWallet.service;

import com.appWallet.myWallet.dto.DtoWallet;
import com.appWallet.myWallet.entity.Wallet;
import com.appWallet.myWallet.repo.WalletRepository;
import com.appWallet.myWallet.utils.OperationType;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void updateWalletBalance(DtoWallet dtoWallet) {
        Wallet wallet = walletRepository.findById(dtoWallet.getWalletId()).stream().findFirst().orElse(null);
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet with " + dtoWallet.getWalletId() + " was not found");
        }
        synchronized (wallet) {
            if (OperationType.WITHDRAW.equals(dtoWallet.getOperationType())) {
                wallet.setBalance(wallet.getBalance().subtract(dtoWallet.getAmount()));
                walletRepository.save(wallet);
                return;
            }
            if (OperationType.DEPOSIT.equals(dtoWallet.getOperationType())) {
                wallet.setBalance(wallet.getBalance().add(dtoWallet.getAmount()));
                walletRepository.save(wallet);
                return;
            }
        }
        throw new UnsupportedOperationException("Not supported operation type");
    }

    @Override
    public BigDecimal getWalletBalance(UUID uuid) {
        Wallet wallet = walletRepository.findById(uuid).stream().findFirst().orElse(null);
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet with " + uuid + " was not found");
        }
        return wallet.getBalance();
    }

    @Override
    public void addWallet() {
        Wallet wallet = new Wallet();
        wallet.setBalance(new BigDecimal(100));
        walletRepository.save(wallet);
    }

    @Override
    public void removeWallet(Wallet wallet) {
        walletRepository.delete(wallet);
    }
}
