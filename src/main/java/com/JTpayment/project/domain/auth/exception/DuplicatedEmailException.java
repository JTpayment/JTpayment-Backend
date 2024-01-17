package com.JTpayment.project.domain.auth.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class DuplicatedEmailException extends BasicException {
    public DuplicatedEmailException() {
        super(ErrorCode.DUPLICATED_EMAIL);
    }
}
