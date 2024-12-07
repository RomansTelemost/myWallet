package com.appWallet.myWallet.service;

import com.appWallet.myWallet.dto.DtoWallet;
import com.appWallet.myWallet.entity.Wallet;
import com.appWallet.myWallet.repo.WalletRepository;
import com.appWallet.myWallet.utils.OperationType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    @Transactional
    public void updateWalletBalance(DtoWallet dtoWallet) {
        Wallet wallet = Optional.of(walletRepository.findById(dtoWallet.getWalletId())).orElse(null);
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet with uuid " + dtoWallet.getWalletId() + " was not found");
        }
        if (!dtoWallet.getAmount().equals(dtoWallet.getAmount().abs())) {
            throw new IllegalArgumentException("Wallet with uuid " + dtoWallet.getWalletId() + " the balance parameter cannot be less than 0");
        }
        synchronized (wallet) {
            if (OperationType.WITHDRAW.equals(dtoWallet.getOperationType())) {
                wallet.setBalance(wallet.getBalance().subtract(dtoWallet.getAmount()));
                if (wallet.getBalance().compareTo(new BigDecimal(0)) < 0) {
                    throw new IllegalArgumentException("Not enough balance to execute this operation");
                }
                walletRepository.save(wallet);
                return;
            }
            if (OperationType.DEPOSIT.equals(dtoWallet.getOperationType())) {
                wallet.setBalance(wallet.getBalance().add(dtoWallet.getAmount()));
                walletRepository.save(wallet);
                return;
            }
        }
        throw new UnsupportedOperationException("Not supported operation type " + dtoWallet.getOperationType());
    }

    @Override
    public BigDecimal getWalletBalance(UUID uuid) {
        Wallet wallet = Optional.of(walletRepository.findById(uuid)).orElse(null);
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet with " + uuid + " was not found");
        }
        return wallet.getBalance();
    }

    @Override
    public Wallet addWallet() {
        Wallet wallet = new Wallet();
        wallet.setBalance(new BigDecimal(0));
        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public boolean removeWalletById(UUID uuid) {
        Wallet wallet = walletRepository.findById(uuid);
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet with " + uuid + " was not found");
        }
        return walletRepository.deleteById(uuid) != 0;
    }

    @Override
    public List<Wallet> getAllWallet() {
        List<Wallet> wallets = new ArrayList<>();
        walletRepository.findAll().forEach(wallets::add);
        return wallets;
    }
}
