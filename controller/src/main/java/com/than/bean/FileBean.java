package com.than.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.beans.JavaBean;

/**
 * @package: com.than.bean
 * @className: FileBean
 * @author Than
 * @description: TODO
 * @date: 2023/8/23 16:12
 */
@Data
public class FileBean {

    private int id;
    private String url;
    private String path;
    private String time;

}
