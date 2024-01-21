package com.JTpayment.project.domain.board.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class MismatchAuthorException extends BasicException {

    public MismatchAuthorException() {
        super(ErrorCode.MISMATCH_AUTHOR);
    }
}
