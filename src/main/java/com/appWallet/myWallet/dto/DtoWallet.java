package com.appWallet.myWallet.dto;

import com.appWallet.myWallet.utils.OperationType;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "Кошелек с указанием типа операции и суммы")
public class DtoWallet {

    @Schema(name = "id существующего кошелька")
    private UUID walletId;

    @Schema(name = "Тип операции", description = "", allowableValues = {"DEPOSIT", "WITHDRAW"})
    private String operationType;

    private BigDecimal amount;
}
