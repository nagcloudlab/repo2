package com.example.web;

import com.example.service.TransferService;
import com.example.web.dto.TransferRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/transfer")
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public String doTransfer(@ModelAttribute TransferRequest transferRequest) {
        transferService.transfer(transferRequest.getAmount(), transferRequest.getSourceAccount(), transferRequest.getDestinationAccount());
        return "redirect:transfer-status.html";
    }

}
