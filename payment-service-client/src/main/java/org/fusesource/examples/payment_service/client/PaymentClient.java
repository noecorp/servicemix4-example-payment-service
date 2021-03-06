/*
 * Copyright (C) Red Hat, Inc.
 * http://www.redhat.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fusesource.examples.payment_service.client;

import java.net.MalformedURLException;
import java.net.URL;

import org.fusesource.examples.payment_service.Payment;
import org.fusesource.examples.payment_service.PaymentService;
import org.fusesource.examples.payment_service.types.TransferRequest;
import org.fusesource.examples.payment_service.types.TransferResponse;

public class PaymentClient {
    private static final String WSDL_URL = "http://localhost:9090/paymentService?WSDL";

    public static void main(String args[]) throws MalformedURLException {
        Payment payment = new PaymentService(new URL(WSDL_URL)).getPaymentPort();

        TransferRequest request = new TransferRequest();
        request.setBank("bank1");
        request.setFrom("Eric");
        request.setTo("Scott");
        request.setAmount("40.00");

        System.out.println("Request Bank = " + request.getBank());

        TransferResponse response = payment.transferFunds(request);

        System.out.println("Response = " + response.getReply());

        request.setBank("bank2");

        System.out.println("Request Bank = " + request.getBank());

        response = payment.transferFunds(request);

        System.out.println("Response = " + response.getReply());
    }
}
