package ge.bank.payment.controller;

import ge.bank.payment.model.OwnTransfer;
import ge.bank.payment.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Zura Tikaradze .
 */
@RestController
@RequestMapping(path = "/api/")
public class TransferController {

    @Autowired
    TransferService transferService;

    @PostMapping(value = "/ownTransfer")
    void ownTrasnfer(@RequestBody  OwnTransfer ownTransferRequest){
        transferService.OwnTransfer(ownTransferRequest);
    }
}
