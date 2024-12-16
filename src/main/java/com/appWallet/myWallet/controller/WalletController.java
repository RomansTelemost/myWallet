package com.appWallet.myWallet.controller;

import com.appWallet.myWallet.config.DataSourceConf;
import com.appWallet.myWallet.customException.CustomExceptionHandler;
import com.appWallet.myWallet.dto.DtoWallet;
import com.appWallet.myWallet.entity.Wallet;
import com.appWallet.myWallet.service.WalletService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@CustomExceptionHandler
@Tag(name ="Wallet controller tag", description = "Wallet description")
@RequiredArgsConstructor
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private DataSourceConf dataSourceConf;

    @GetMapping("/hello")
    @Hidden
    public String add() {
        dataSourceConf.devBean();
        return "hello";
    }

    @PostMapping("/addWallet")
    @Operation(summary = "Create new wallet")
    public ResponseEntity<Wallet> addNewWallet() {
        Wallet wallet = walletService.addWallet();
        return ResponseEntity.ok(wallet);
    }

    @PostMapping("/wallet")
    public ResponseEntity<?> updateBalance(@RequestBody DtoWallet dtoWallet) {
        walletService.updateWalletBalance(dtoWallet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/wallet")
    @Operation(summary = "Get balance by wallet id", description = "Return wallet balance")
    public BigDecimal getWalletBalance(@RequestParam @Parameter(description = "Id of exist wallet") UUID uuid) {
        return walletService.getWalletBalance(uuid);
    }

    @DeleteMapping("/removeWallet")
    public ResponseEntity<?> removeWallet(@RequestParam UUID uuid) {
        if (walletService.removeWalletById(uuid)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getAllWallet")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<List<Wallet>> getAllWallet() {
        return new ResponseEntity<>(walletService.getAllWallet(), HttpStatus.OK);
    }
}
