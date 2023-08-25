package com.than.file;

import com.than.file.exception.FolderCreationFailedException;

import java.io.File;

/**
 * @author Than
 * @package: com.than.file
 * @className: FileManage
 * @description: TODO
 * @date: 2023/8/23 18:00
 */
public class FileManage {

    /**
     * <p>递归创建文件夹, 如果不这样创建, 父文件夹也不存在时不会一同创建</p>
     *
     * @param file 目标文件夹对象
     * @throws FolderCreationFailedException 创建失败异常
     */
    public static void mkdir(File file) throws FolderCreationFailedException {

        if (!file.getParentFile().exists()) {
            mkdir(file.getParentFile());
        }

        if (file.getParentFile().exists()) {
            if (!file.mkdirs()) {
                throw new FolderCreationFailedException("Folder creation failed");
            }
        }
    }


}
