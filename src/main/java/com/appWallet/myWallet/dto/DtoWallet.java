package com.appWallet.myWallet.dto;

import com.appWallet.myWallet.utils.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoWallet {

    private UUID walletId;

    private OperationType operationType;

    private BigDecimal amount;
}
