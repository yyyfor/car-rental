package com.siming.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CarStatusEnum {

    IN_USE(0),
    DELETED(1);

    private final int status;
}
