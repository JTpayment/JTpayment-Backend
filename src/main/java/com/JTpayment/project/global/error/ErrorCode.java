package com.JTpayment.project.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //SERVER ERROR
    UNKNOWN_ERROR("알 수 없는 오류입니다.", 500),

    //TOKEN
    TOKEN_IS_EXPIRED("토큰이 만료 되었습니다.", 403),
    TOKEN_IS_INVALID("토큰이 유효 하지 않습니다.", 401),

    //MEMBER
    DUPLICATED_ID("중복된 아이디 입니다.", 409),
    DUPLICATED_NICKNAME("중복된 닉네임 입니다.", 409),
    DUPLICATED_EMAIL("중복된 이메일 입니다.", 409),
    MEMBER_NOT_FOUND("등록되지 않은 유저입니다.", 404),
    PASSWORD_INVALID("비밀번호가 일치하지 않습니다.", 403);


    private final String message;
    private final int status;
}
