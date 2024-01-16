package com.JTpayment.project.domain.auth.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class DuplicatedNicknameException extends BasicException {
    public DuplicatedNicknameException() {
        super(ErrorCode.DUPLICATED_NICKNAME);
    }
}
