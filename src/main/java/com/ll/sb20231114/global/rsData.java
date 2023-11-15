package com.ll.sb20231114.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class rsData<T> {
    private String resultCode;
    private String msg;
    private T data;
}
