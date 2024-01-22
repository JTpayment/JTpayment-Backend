package com.JTpayment.project.domain.report.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Type {
    BOARD, COMMENT;

    @JsonCreator
    public static Type from(String s) {
        return Type.valueOf(s.toUpperCase());
    }
}
