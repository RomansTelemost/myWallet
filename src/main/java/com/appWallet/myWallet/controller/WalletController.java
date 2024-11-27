package com.appWallet.myWallet.controller;

import com.appWallet.myWallet.customException.CustomExceptionHandler;
import com.appWallet.myWallet.dto.DtoWallet;
import com.appWallet.myWallet.entity.Wallet;
import com.appWallet.myWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@CustomExceptionHandler
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/addWallet")
    public ResponseEntity<?> addNewWallet() {
        return new ResponseEntity<>(walletService.addWallet(), HttpStatus.CREATED);
    }

    @PostMapping("/wallet")
    public ResponseEntity<?> updateBalance(@RequestBody DtoWallet dtoWallet) {
        walletService.updateWalletBalance(dtoWallet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/wallet")
    public BigDecimal getWalletBalance(@RequestParam UUID uuid) {
        return walletService.getWalletBalance(uuid);
    }

    @DeleteMapping("/removeWallet")
    public void removeWallet(@RequestBody Wallet wallet) {
        walletService.removeWallet(wallet);
    }

    @GetMapping("/getAllWallet")
    public ResponseEntity<List<Wallet>> getAllWallet() {
        return new ResponseEntity<>(walletService.getAllWallet(), HttpStatus.OK);
    }
}
