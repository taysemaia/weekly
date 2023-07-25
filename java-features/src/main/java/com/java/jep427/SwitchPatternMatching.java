package com.java.jep427;

import com.java.jep409.Credit;
import com.java.jep409.Debit;
import com.java.jep409.PaymentMethod;
import com.java.jep409.Pix;
import com.java.service.PaymentService;

public class SwitchPatternMatching {

    private PaymentService paymentService;

    private void validate1(PaymentMethod paymentMethod) {
        if (paymentMethod instanceof Credit credit) {
            paymentService.executePayment(credit);
        } else if (paymentMethod instanceof Debit debit) {
            paymentService.executePayment(debit);
        } else if((paymentMethod instanceof Pix pix) && pix.isValidKey()) {
            paymentService.executePayment(pix);
        }
    }


    //JEP406
    private void validate(Object obj) {
        switch (obj) {
            case Credit credit -> paymentService.executePayment(credit);
            case Debit debit -> paymentService.executePayment(debit);
           // case Pix pix && pix.isValidKey() -> paymentService.executePayment(pix); //Guarded pattern
            default -> throw new IllegalStateException("Unexpected value: " + obj);
        }
    }
    private void validate(PaymentMethod method) {
        switch (method) {
            case Credit credit -> paymentService.executePayment(credit);
            case Debit debit -> paymentService.executePayment(debit);
            case Pix pix when pix.isValidKey() -> paymentService.executePayment(pix); // guarded pattern (&&) foi substituido pelo when
            case null -> System.out.print("opa");
            default -> throw new IllegalStateException("Unexpected value: " + method);
        }
    }
}
