package com.JTpayment.project.domain.payment.presentation;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.payment.entity.Order;
import com.JTpayment.project.domain.payment.presentation.dto.request.PayReq;
import com.JTpayment.project.domain.payment.presentation.dto.request.PaymentCallbackReq;
import com.JTpayment.project.domain.payment.service.OrderService;
import com.JTpayment.project.domain.payment.service.PaymentCallbackService;
import com.JTpayment.project.domain.payment.service.PaymentService;
import com.JTpayment.project.global.util.MemberUtil;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final PaymentCallbackService paymentCallbackService;
    private final MemberUtil memberUtil;

    @GetMapping("/order")
    public String order(@RequestParam(name = "message", required = false) String message,
                        @RequestParam(name = "orderUid", required = false) String id,
                        Model model) {

        model.addAttribute("message", message);
        model.addAttribute("orderUid", id);

        return "order";
    }
    @PostMapping("/order")
    public String autoOrder(@RequestBody Map<String, Object> requestBody) {
        Long price = Long.valueOf(requestBody.get("price").toString());

        Member member = memberUtil.currentMember();
        Order order = orderService.execute(member, price);

        String message = "주문 실패";
        if(order != null) {
            message = "주문 성공";
        }

        String encode = URLEncoder.encode(message, StandardCharsets.UTF_8);

        return "redirect:/order?message="+encode+"&orderUid="+order.getOrderUid();
    }

    @GetMapping("/payment/{id}")
    public String paymentPage(@PathVariable(name = "id", required = false) String orderUid,
                              Model model) {

        PayReq requestDto = paymentService.execute(orderUid);
        model.addAttribute("requestDto", requestDto);
        return "payment";
    }

    @ResponseBody
    @PostMapping("/payment")
    public ResponseEntity<IamportResponse<Payment>> validationPayment(@RequestBody PaymentCallbackReq req) {
        IamportResponse<Payment> iamportResponse = paymentCallbackService.execute(req);
        return new ResponseEntity<>(iamportResponse, HttpStatus.OK);
    }

    @GetMapping("/success-payment")
    public String successPaymentPage() {
        return "success-payment";
    }

    @GetMapping("/fail-payment")
    public String failPaymentPage() {
        return "fail-payment";
    }
}
