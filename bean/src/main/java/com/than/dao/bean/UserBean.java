package com.than.dao.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.EnumSet;

@Component
@Data
public class UserBean {
    // 必须
    private String name;
    @JsonIgnore
    private String password;

    private String headshot;
    private String background;
    private String signature;
    private String region;
    private String type;

    // 自动
    private String account;
    private Timestamp create_time;

    public enum UserType {
        ORDINARY("Ordinary"),
        ADMINISTRATOR("Administrator");

        private String value;

        UserType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static boolean isValidType(String type) {
            return EnumSet.allOf(UserType.class).stream()
                    .map(UserType::getValue)
                    .anyMatch(t -> t.equalsIgnoreCase(type));
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (UserType.isValidType(type)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid user type: " + type);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public UserBean() {
        account = String.valueOf(System.nanoTime());
        create_time = new Timestamp(System.currentTimeMillis());
    }

    public UserBean(String name, String password) {
        this();
        this.name = name;
        this.password = password;
    }
}
