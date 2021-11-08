package org.sot.project;

import java.util.ArrayList;
import java.util.List;
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
		List<String> responses = new ArrayList<>();
		responses.add(HttpClientUtil.doGet("http://localhost:9090/demo/operation/information/all"));
		responses.add(HttpClientUtil.doGet("http://localhost:9090/demo/operation/informationByUserId/1"));

	}
}
