package com.sample.server;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.sample.SampleMybatisApplication;
import com.sample.dao.ConsumerMapper;
import com.sample.model.Consumer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Map;

//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by zhenghuasheng on 2016/7/9.
 */

@Path("c")
@Service(protocol = { "rest","dubbo"})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@org.springframework.stereotype.Service("consumerServer")
public class ConsumerServer implements IConsumerServer{
    private static Logger logger = Logger.getLogger(SampleMybatisApplication.class);
    @Autowired
    private ConsumerMapper consumerMapper;
//    @Autowired
//    private UserServer userServer;
//    @Autowired
//    private RedisCache redisCache;


    public Consumer getConsumerByName(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("memberName", name);
//        PtResult ptResult = userServer.getUserBykey(1L);
//       PtResult result = (PtResult) redisCache.get("ptResult").get();
//        if (result != null){
//            System.out.println("get from cache!");
//        }else {
//            redisCache.put("ptResult",ptResult);
//        }

        return consumerMapper.getConsumerRequest(params);
    }



    @Path("result")
    @GET
    public String getDubboxResult(){
        return "dubbox";
    }

}
