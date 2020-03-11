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

    public static String Authorization_Code = "21b66d6f-0e82-4f5c-8cc8-acba8032bf54";
    public static int effective_Time = 7200;

    /**
     * 获取token（传递参数：userid）
     * @return
     */
    @RequestMapping(value = "/getToken")
    public Map<String, Object> getToken() {
        Map<String, Object> json = new HashMap<String, Object>();
        PageData pd = this.getPageData();
        String Authorization = pd.getString("Authorization");
        if (Authorization_Code.equals(Authorization)) {
            Jedis jedis = new Jedis("localhost");
            if (jedis.exists(Authorization)) {
                json.put("token", jedis.get(Authorization));
                json.put("effective_Time", jedis.ttl(Authorization));
            } else {
                String tokeValue = new Date().getTime() + "token" + new Double(Math.ceil(Math.random()*1000000)).intValue() + "value";
                jedis.set(Authorization_Code, tokeValue);
                jedis.expire(Authorization_Code, effective_Time);
                json.put("token", tokeValue);
                json.put("effective_Time", effective_Time);
            }
        }
        return json;
    }

}
