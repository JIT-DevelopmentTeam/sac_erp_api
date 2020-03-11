package com.fh.controller;

import com.fh.controller.base.BaseController;
import com.fh.util.PageData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/token")
public class TokenController extends BaseController {

    /**
     * 获取token（传递参数：userid）
     * @return
     */
    @RequestMapping(value = "/getToken")
    public Map<String, Object> getToken() {
        Map<String, Object> json = new HashMap<String, Object>();
        PageData pd = this.getPageData();
        int effective_Time = 7200;
        String userid = pd.getString("userid");
        String tokeValue = new Date().getTime() + "token" + new Double(Math.ceil(Math.random()*1000000)).intValue() + "value";
        Jedis jedis = new Jedis("localhost");
        jedis.set(userid, tokeValue);
        jedis.expire(userid, effective_Time);
        json.put("token", tokeValue);
        json.put("effective_Time", effective_Time);
        return json;
    }

}
