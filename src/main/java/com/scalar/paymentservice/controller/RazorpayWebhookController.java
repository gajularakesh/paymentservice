package com.scalar.paymentservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhookController {

    @PostMapping("/razorpayWebhook")
    public void paymentDone(@RequestBody Object object){
        System.out.println(object);
    }
}
