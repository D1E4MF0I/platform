package com.than.controller.axis;

import com.than.base.Result;
import com.than.bean.AxisMsgBean;
import org.springframework.web.bind.annotation.*;

/**
 * @author Than
 * <p>用户自身的时间轴控制层,获取时间轴等操作在这里进行</p>
 *
 *
 * <p>时间轴是注册账号时默认创建的,每一次发帖子或者评论,都会自动添加进时间轴,用户也可以自己往时间轴内添加信息,用户的时间轴只有自己或者亲人可见</p>
 */
@RestController
@RequestMapping("/axis/own")
public class UserOwnAxis {

    /**
     * <p>获取自己的时间轴</p>
     * @return 返回时间轴信息
     */
    @GetMapping("/own_axis")
    public Result getOwnAxis(){
        return new Result();
    }

    /**
     * <p>额外添加一个时间轴信息,注意: <strong>这是额外添加的,不会算作评论或者帖子</strong></p>
     * @param bean 时间轴信息实体
     * @return 返回是否添加成功
     */
    @PostMapping("/add_msg")
    public Result addAxisMsg(@RequestBody AxisMsgBean bean){
        return new Result();
    }

}
