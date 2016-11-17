package com.sample.server;

import com.sample.model.Consumer;

/**
 * Created by zhenghuasheng on 2016/11/17.
 */
public interface IConsumerServer {

    Consumer getConsumerByName(String name);

    String  getDubboxResult();
}
