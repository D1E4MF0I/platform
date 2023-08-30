package com.than.service.axis;

import com.than.base.Result;
import com.than.controller.bean.AxisMsgBean;
import org.springframework.stereotype.Service;

/**
 * @author Than
 * @package: com.than.service.axis
 * @className: UserOwnAxisService
 * @description: 个人时间轴service
 * @date: 2023/8/30 21:42
 */
@Service
public class UserOwnAxisService {

    public Result getOwnAxis(){
        return new Result();
    }


    public Result addAxisMsg(AxisMsgBean bean){
        return new Result();
    }

}
