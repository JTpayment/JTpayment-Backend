package com.JTpayment.project.domain.mail.service;

public interface MailCheckService {
    Boolean execute(String email, String code);
}
