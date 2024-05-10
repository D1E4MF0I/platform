package com.than.timetree.bean;

import java.util.Collections;
import java.util.List;

public class TimeTree {
    // 主用户ID
    private String userId;
    // 可操作用户列表
    private String[] useUserIdList;
    // 时间轴节点列表
    private List<TimeTreeNode> timeTreeNodeList;

    // TODO:添加返回规则细则，如错误报错代码等
    public boolean add(TimeTreeNode tnn){
        timeTreeNodeList.add(tnn);
        Collections.sort(timeTreeNodeList);
        return timeTreeNodeList.contains(tnn);
    }

    // TODO:优化搜索 / 删除逻辑 | 返回逻辑细则
    public boolean del(Long timeTreeNodeId){
        for (int i = 0; i < timeTreeNodeList.size(); i++) {
            TimeTreeNode timeTreeNode = timeTreeNodeList.get(i);
            if(timeTreeNode.getId().equals(timeTreeNodeId)){
                timeTreeNodeList.remove(timeTreeNode);
                return true;
            }
        }
        return false;
    }
}
