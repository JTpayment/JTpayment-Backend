package com.JTpayment.project.domain.auth.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class DuplicatedIdException extends BasicException {
    public DuplicatedIdException() {
        super(ErrorCode.DUPLICATED_ID);
    }
}
