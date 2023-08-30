package com.than.service.axis;

import com.than.base.Result;
import com.than.controller.bean.AxisMsgBean;
import org.springframework.stereotype.Service;

/**
 * @author Than
 * @package: com.than.service.axis
 * @className: ParentsAndKidsAxisService
 * @description: 亲人时间轴的service
 * @date: 2023/8/30 21:42
 */
@Service
public class ParentsAndKidsAxisService {

    public Result getAxis(){

        return new Result();
    }

    public Result addAxisMsg(AxisMsgBean bean){
        return new Result();
    }

}
