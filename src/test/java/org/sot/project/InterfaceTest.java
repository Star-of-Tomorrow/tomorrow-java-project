package org.sot.project;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;
import org.sot.project.Utils.HttpClientUtil;

/**
 * 接口测试
 * @author Timing
 * @since 2021/11/8 10:51 上午
 */
public class InterfaceTest {

	@Test
	public void testInterface(){
		//step1.登录注册
		//step2.发布瞬间
		//step3.
		List<String> responses = new ArrayList<>();
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("userId","testUser");
		paramMap.put("informationId","testInformation");
		paramMap.put("informationName","测试中文");
		paramMap.put("informationContent","testinformationContent");
		paramMap.put("informationType","moment");
		responses.add(HttpClientUtil.doPostJson("http://localhost:9090/demo/operation/createInformation", JSON.toJSONString(paramMap)));
		responses.add(HttpClientUtil.doGet("http://localhost:9090/demo/operation/information/all"));
		responses.add(HttpClientUtil.doGet("http://localhost:9090/demo/operation/informationByUserId/testUser"));
		System.out.println(responses);
	}
}
