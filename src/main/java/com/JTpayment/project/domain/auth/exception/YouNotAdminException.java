package com.JTpayment.project.domain.auth.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class YouNotAdminException extends BasicException {

    public YouNotAdminException() {
        super(ErrorCode.YOU_NOT_ADMIN);
    }
}
