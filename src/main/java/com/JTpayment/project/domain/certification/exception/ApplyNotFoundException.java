package com.JTpayment.project.domain.certification.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class ApplyNotFoundException extends BasicException {

    public ApplyNotFoundException() {
        super(ErrorCode.APPLY_NOT_FOUND);
    }
}
