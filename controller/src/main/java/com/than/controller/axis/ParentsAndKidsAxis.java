package com.than.controller.axis;

import com.than.base.Result;
import com.than.bean.AxisMsgBean;
import org.springframework.web.bind.annotation.*;

/**
 * @author Than
 * <p>亲人之间的时间轴,联系父母和孩子</p>
 * <p>时间轴不提供评论功能,<strong>想ta就去给他打个电话吧！</strong></p>
 */
@RestController
@RequestMapping("/axis/family")
public class ParentsAndKidsAxis {

    /**
     * <p>获取家人时间轴</p>
     * @return 返回时间轴信息
     */
    @GetMapping("/family_axis")
    public Result getAxis(){
        return new Result();
    }

    /**
     * <p>额外添加一个时间轴信息,注意: <strong>这是额外添加的,不会算作评论或者帖子</strong></p>
     * <p>这个信息会添加在孩子和父母的共同时间轴上,不会对他们自己的时间轴产生影响</p>
     * @param bean 时间轴信息实体
     * @return 返回是否添加成功
     */
    @PostMapping("/add_msg")
    public Result addAxisMsg(@RequestBody AxisMsgBean bean){
        return new Result();
    }

}