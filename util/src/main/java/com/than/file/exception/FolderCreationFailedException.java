package com.than.file.exception;

/**
 * @author Than
 * @package: com.than.file.exception
 * @className: FolderCreationFailedException
 * @description: TODO
 * @date: 2023/8/23 18:04
 */
public class FolderCreationFailedException extends RuntimeException{
    public FolderCreationFailedException(String message) {
        super(message);
    }
}
