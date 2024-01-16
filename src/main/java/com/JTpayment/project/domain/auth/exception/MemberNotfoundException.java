package com.JTpayment.project.domain.auth.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class MemberNotfoundException extends BasicException {
    public MemberNotfoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }
}
