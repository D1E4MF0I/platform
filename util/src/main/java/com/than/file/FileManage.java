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

    public static void mkdir(File file)throws FolderCreationFailedException{

        if(!file.getParentFile().exists()){
            mkdir(file.getParentFile());
        }

        if(file.getParentFile().exists()){
            if(!file.mkdirs()){
                throw new FolderCreationFailedException("Folder creation failed");
            }
        }
    }


}
