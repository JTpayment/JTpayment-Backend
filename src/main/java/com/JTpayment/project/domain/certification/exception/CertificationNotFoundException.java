package com.JTpayment.project.domain.certification.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class CertificationNotFoundException extends BasicException {

    public CertificationNotFoundException() {
        super(ErrorCode.CERTIFICATION_NOT_FOUND);
    }
}
