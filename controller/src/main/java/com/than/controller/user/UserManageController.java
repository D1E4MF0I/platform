package com.than.controller.user;

import com.than.base.Result;
import com.than.bean.UserPersonalMsgBean;
import org.springframework.web.bind.annotation.*;

/**
 * @author Than
 * <p>用户管理控制层，修改用户信息等操作在这里完成,只能对用户自身操作,此类所有操作需要在请求头中附带cookie</p>
 */
@RestController
@RequestMapping("/user/manage")
public class UserManageController {

    /**
     *<P>修改用户名</P>
     * @param name 新名称
     * @return 是否修改成功,附带新名称
     */
    @PostMapping("/change_username")
    public Result changeUsername(@RequestParam("new_name")String name){

        return new Result();
    }


    /**
     * <p>修改用户头像</p>
     * @param url 用户头像的url
     * @return 是否修改成功,附带用户头像url
     *
     * <p>此处接受的参数为url,所以上传之前应该先上传头像文件</p>
     *
     */
    @PostMapping("/change_picture")
    public Result changeAccountPicture(@RequestParam("picture_url")String url){

        return new Result();
    }

    /**
     *<p>修改用户背景</p>
     * @param url 背景图片的url
     * @return 是否修改成功,附带背景url
     */
    @PostMapping("/change_background")
    public Result changeAccountBackground(@RequestParam("picture_url")String url){

        return new Result();
    }

    /**
     *<p>修改用户签名</p>
     * @param signature 用户签名
     * @return 是否修改成功,附带用户签名
     */
    @PostMapping("/change_signature")
    public Result changeUserSignature(@RequestParam("signature")String signature){

        return new Result();
    }

    /**
     * <p>修改用户地区</p>
     * @param region 用户地区
     * @return 是否修改成功,附带用户地区
     */
    @PostMapping("/change_region")
    public Result changeUserRegion(@RequestParam("region")String region){

        return new Result();
    }

    /**
     *  <p>修改用户信息,不过此接口通过上传一个用户实体进行修改,用于批量修改信息</p>
     * @param bean 用户总体信息
     * @return 是否修改成功,附带总体信息
     */
    @PostMapping("/change_user_msg")
    public Result changeUserMsgByJson(@RequestBody UserPersonalMsgBean bean){

        return new Result();
    }

    /**
     * <p>修改用户类型</p>
     * @param type 用户类型
     * @return 是否修改成功,附带用户类型
     * <p>用户类型分为两种: 家长和孩子</p>
     */
    @PostMapping("/change_type")
    public Result changeUserType(@RequestParam("type")String type){

        return new Result();
    }


}
