package com.appWallet.myWallet.service;

import com.appWallet.myWallet.dto.DtoWallet;
import com.appWallet.myWallet.entity.Wallet;

import java.math.BigDecimal;
import java.util.UUID;

public interface WalletService {

    void updateWalletBalance(DtoWallet dtoWallet);

    BigDecimal getWalletBalance(UUID uuid);

    void addWallet();

    void removeWallet(Wallet wallet);
}
