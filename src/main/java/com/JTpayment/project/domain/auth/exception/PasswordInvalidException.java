package com.JTpayment.project.domain.auth.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class PasswordInvalidException extends BasicException {
    public PasswordInvalidException() {
        super(ErrorCode.PASSWORD_INVALID);
    }
}
