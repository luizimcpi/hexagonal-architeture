package br.com.devlhse.myaccount.adapter.web.transfer;

import br.com.devlhse.myaccount.adapter.web.transfer.dto.TransferInput;
import br.com.devlhse.myaccount.core.service.transfer.in.BankTransferUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/transfers")
public class TransferController {

    private final BankTransferUseCase bankTransferUseCase;

    @PostMapping
    public ResponseEntity transfer(@RequestBody @Valid TransferInput input) {
        bankTransferUseCase.transfer(input.getOriginAccountId(), input.getDestinyAccountId(), input.getValue());
        return ResponseEntity.ok().build();
    }
}
