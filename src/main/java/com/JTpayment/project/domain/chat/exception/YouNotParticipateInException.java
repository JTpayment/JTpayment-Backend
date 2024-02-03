package com.JTpayment.project.domain.chat.exception;

import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;

public class YouNotParticipateInException extends BasicException {

    public YouNotParticipateInException() {
        super(ErrorCode.YOU_NOT_PARTICIPATE_IN);
    }
}
