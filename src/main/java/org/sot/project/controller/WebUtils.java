package org.sot.project.controller;

/**
 * @author ShiDu
 * @date 2021/11/1 4:53 下午
 */

import java.util.concurrent.Callable;
import lombok.extern.slf4j.Slf4j;
import org.sot.project.common.ApiResponse;

/**
 * web进程工具类
 *
 * @author Timing
 * @date 2021/9/26 8:31 下午
 */
@Slf4j
public class WebUtils {
	public static ApiResponse process(Callable callable) {
		//初始化泛型对象，这里要注意是否有构造器
		ApiResponse apiResponse = new ApiResponse();
		//开始执行业务代码，封装错误信息
		try {
			apiResponse.setData(callable.call());
			apiResponse.setMessage("成功执行");
			apiResponse.setCode(200);
			return apiResponse;
		}catch (Exception e){
			log.error("报错",e);
			apiResponse.setCode(400);
			apiResponse.setMessage("出现异常");
			return apiResponse;
		}
	}
}
