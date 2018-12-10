package ge.bank.payment.service.impl;

import ge.bank.payment.model.Account;
import ge.bank.payment.model.OwnTransfer;
import ge.bank.payment.repository.AccountRepository;
import ge.bank.payment.service.TransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class OwnTransferImpl implements TransferService {

    @Autowired
    AccountRepository accountRepository;
    @Override
    @Transactional
    public void OwnTransfer(OwnTransfer ownTransferRequest) {
        Account aF=accountRepository.getByAccountName(ownTransferRequest.getAccountFrom());
        Account aT=accountRepository.getByAccountName(ownTransferRequest.getAccountTo());

        aF.setBalance(aF.getBalance().subtract(ownTransferRequest.getAmount()));
        accountRepository.save(aF);
        // IF YOU WANT CHECK Transactional Power Try To uncomment this line
//        if(1==1){
//             throw new IndexOutOfBoundsException("This is Random Exception");
//        }
        aT.setBalance(aT.getBalance().add(ownTransferRequest.getAmount()));
        accountRepository.save(aT);
    }
}
