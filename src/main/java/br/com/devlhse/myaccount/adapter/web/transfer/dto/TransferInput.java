package br.com.devlhse.myaccount.adapter.web.transfer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransferInput {

    @NotNull
    @JsonProperty("originId")
    private Long originAccountId;

    @NotNull
    @JsonProperty("destinyId")
    private Long destinyAccountId;

    @NotNull
    @JsonProperty("transferValue")
    private BigDecimal value;

}
