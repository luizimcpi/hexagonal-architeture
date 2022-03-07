package br.com.devlhse.myaccount.core.domain.transferencia;

import java.math.BigDecimal;

public class Conta {

    private Long id;
    private BigDecimal saldo;

    public Conta(Long id, BigDecimal saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public void debitar(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
    }

    public void creditar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
