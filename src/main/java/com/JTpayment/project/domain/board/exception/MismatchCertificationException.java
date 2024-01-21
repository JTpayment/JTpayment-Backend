package com.JTpayment.project.domain.board.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class MismatchCertificationException extends BasicException {

    public MismatchCertificationException() {
        super(ErrorCode.MISMATCH_CERTIFICATION);
    }
}
