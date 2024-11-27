package com.appWallet.myWallet.controller;

import com.appWallet.myWallet.dto.DtoWallet;
import com.appWallet.myWallet.entity.Wallet;
import com.appWallet.myWallet.service.WalletService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/addWallet")
    public void addNewWallet() {
        walletService.addWallet();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException e) {
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/wallet")
    public void updateBalance(@RequestBody DtoWallet dtoWallet) {
            walletService.updateWalletBalance(dtoWallet);
//        Response response = new Response();
//        response.setStatus(1);
//        return response;
//        return
    }

    @GetMapping("/wallet")
    public BigDecimal getWalletBalance(@RequestParam UUID uuid) {
        return walletService.getWalletBalance(uuid);
    }

    @DeleteMapping("/removeWallet")
    public void removeWallet(@RequestBody Wallet wallet) {
        walletService.removeWallet(wallet);
    }

}
