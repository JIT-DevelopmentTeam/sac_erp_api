package com.fh.interceptor;

import cn.jpush.api.BaseResult;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
* 类名称：登录过滤，权限验证
* 类描述： 
* @author FH qq313596790[青苔]
* 作者单位： 
* 联系方式：
* 创建时间：2015年11月2日
* @version 1.6
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String userid = request.getParameter("userid");
		String token = request.getParameter("token");
		Jedis jedis = new Jedis("localhost");
		if (jedis.exists(userid) && jedis.get(userid).equals(token)) {
			return true;
		}
		BaseResult baseResult = new BaseResult();
		baseResult.setErrmsg("token无效");
		returnJson(response, JSONObject.toJSONString(baseResult));
		return false;
	}

	private void returnJson(HttpServletResponse response, String json) throws Exception{
		PrintWriter writer = null;
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		try {
			writer = response.getWriter();
			writer.print(json);

		} catch (IOException e) {
			logger.error("response error",e);
		} finally {
			if (writer != null)
				writer.close();
		}
	}
	
}
