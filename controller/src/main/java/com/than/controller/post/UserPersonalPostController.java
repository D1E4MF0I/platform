package com.than.controller.post;

import com.than.base.Result;
import com.than.controller.bean.PersonalPostBean;
import com.than.service.post.UserPersonalPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Than
 * <p>用户自身的帖子管理类,包括发布,删除等操作,这个类中所有接口都需要附带cookie</p>
 */
@RestController
@RequestMapping("/post/personal")
public class UserPersonalPostController {

    @Autowired
    private UserPersonalPostService userPersonalPostService;

    /**
     * <p>发布一个帖子</p>
     * <p>需要在请求头中附带cookie,将在拦截器中检测,cookie为空时不会进入此方法</p>
     *
     * @param bean 帖子的实体json
     * @return 返回是否成功
     */
    @PostMapping("/send")
    public Result addPost(@RequestBody PersonalPostBean bean) {
        userPersonalPostService.addPost(bean);

        return new Result();
    }


    /**
     * <p>删除一个帖子</p>
     * <p>需要在请求头中附带cookie,将在拦截器中检测,cookie为空时不会进入此方法</p>
     *
     * @param id 要删除的帖子的id
     * @return 返回是否删除成功
     */
    @PostMapping("/remove")
    public Result deletePost(@RequestParam("post_id") String id) {
        userPersonalPostService.deletePost(id);

        return new Result();
    }

    /**
     * <p>获取所有个人帖子</p>
     * <p>需要在请求头中附带cookie,将在拦截器中检测,cookie为空时不会进入此方法</p>
     *
     * @return 返回所有用户个人的帖子
     */
    @GetMapping("/get_all")
    public Result getAllOwnPost() {
        userPersonalPostService.getAllOwnPost();

        return new Result();
    }


    /**
     * <P>修改一个帖子</P>
     * <p>需要在请求头中附带cookie,将在拦截器中检测,cookie为空时不会进入此方法</p>
     *
     * @param bean 帖子实体
     * @return 返回是否修改成功, 附带帖子实体
     */
    @PostMapping("/update")
    public Result updatePost(@RequestBody PersonalPostBean bean) {
        userPersonalPostService.updatePost(bean);

        return new Result();
    }


}
