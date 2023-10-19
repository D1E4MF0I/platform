package com.than;

import lombok.Getter;

import java.util.EnumSet;

/**
 * @author Than
 * @package: com.than
 * @className: UserType
 * @description: TODO
 * @date: 2023/10/18 22:05
 */
@Getter
public enum UserType {
    ORDINARY("Ordinary"),
    ADMINISTRATOR("Administrator");

    private String value;

    UserType(String value) {
        this.value = value;
    }


    public static boolean isValidType(String type) {
        return EnumSet.allOf(UserType.class).stream()
                .map(UserType::getValue)
                .anyMatch(t -> t.equalsIgnoreCase(type));
    }
}
