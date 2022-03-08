package br.com.devlhse.myaccount.adapter.web.statement;

import br.com.devlhse.myaccount.adapter.persistence.transfer.mapper.StatementMapper;
import br.com.devlhse.myaccount.core.service.statement.in.BankStatementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/statements")
public class StatementController {

    private final BankStatementUseCase bankStatementUseCase;

    @GetMapping("{accountId}")
    public ResponseEntity statement(@PathVariable("accountId") Long accountId) {
        var statementOutput = StatementMapper.toOutput(bankStatementUseCase.getStatement(accountId));
        return ResponseEntity.ok(statementOutput);
    }
}
