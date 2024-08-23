package com.situ.stadium.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameValue<T> {
    private String name;
    private T value;
}
