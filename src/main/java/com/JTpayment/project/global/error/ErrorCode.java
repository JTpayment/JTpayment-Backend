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

    //CERTIFICATION
    APPLY_NOT_FOUND("요청글을 찾을 수 없습니다.", 404),
    CERTIFICATION_NOT_FOUND("게시판을 찾을 수 없습니다.", 404),

    //BOARD
    BOARD_NOT_FOUND("게시물을 찾을 수 없습니다.", 404),
    MISMATCH_CERTIFICATION("게시판이 일치하지 않습니다.", 403),
    MISMATCH_AUTHOR("작성자가 아닙니다.", 403),

    //REPORT
    REPORT_NOT_FOUND("신고글을 찾을 수 없습니다.", 404),

    //MEMBER
    DUPLICATED_ID("중복된 아이디 입니다.", 409),
    DUPLICATED_NICKNAME("중복된 닉네임 입니다.", 409),
    DUPLICATED_EMAIL("중복된 이메일 입니다.", 409),
    MEMBER_NOT_FOUND("등록되지 않은 유저입니다.", 404),
    PASSWORD_INVALID("비밀번호가 일치하지 않습니다.", 403),
    YOU_NOT_ADMIN("어드민 권한이 없습니다.", 403),

    //ORDER
    ORDER_NOT_FOUND("주문을 찾을 수 없습니다.", 404);

    private final String message;
    private final int status;
}
