package com.than.controller.file;

import com.than.base.Code;
import com.than.base.Result;
import com.than.controller.bean.FileBean;
import com.than.file.FileManage;
import com.than.file.exception.FolderCreationFailedException;
import com.than.time.TimeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @package: com.than.controller.file
 * @className: FileAcceptController
 * @author Than
 * @description: 接受文件的控制层,所有文件都在这里接受
 * @date: 2023/8/23 16:08
 */
@RestController
@RequestMapping("/file")
public class FileAcceptController {

    @Value("${env.ip:127.0.0.1}")
    private String ip;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/accept")
    @ResponseBody
    public Result fileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
        String suffixName = null;
        if (fileName != null) {
            suffixName = fileName.substring(fileName.lastIndexOf("."));
        }
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID() + suffixName;
        String path = System.getProperty("user.dir")+"/home/docker/file/";

        File temp =new File(path);

        if(!temp.exists()){
            try {
                FileManage.mkdir(temp);
            }catch (FolderCreationFailedException e){
                System.out.printf("\n\u001B[%dm%s\u001B[0m%n \n", 31, e.getMessage());
            }
        }

        file.transferTo(new File(path+ fileName));

        String url="http://"+ip+":"+port+"/file/"+ fileName;

        FileBean fileBean=new FileBean();
        fileBean.setUrl(url);
        fileBean.setPath(path+ fileName);
        var time= TimeUtil.getThisTime();
        fileBean.setTime(time);


        return new Result(Code.OK,url);
    }


}
