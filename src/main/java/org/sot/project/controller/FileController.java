package org.sot.project.controller;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.sot.project.common.ApiResponse;
import org.sot.project.common.DataType;
import org.sot.project.common.FileConst;
import org.sot.project.common.ParamType;
import org.sot.project.controller.dto.ImageUrlDTO;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/03
 **/
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

	public final static String IMG_PATH_PREFIX = "/src/main/resources/static/upload/imgs";


	public final  static  String SYS_PREFIX= System.getProperty("user.dir");

	@ApiOperation(value = "图片上传")
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	@ApiImplicitParams({@ApiImplicitParam(name = "files", value = "文件数组", dataType = DataType.ARRAY, paramType = ParamType.PATH)})
	public ApiResponse<ImageUrlDTO> httpUpload(@RequestParam("files") MultipartFile files[]) {
		ImageUrlDTO result = new ImageUrlDTO();
		List<String> urls = result.getUrls();
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getOriginalFilename();  // 文件名
			//fileName修改为时间戳格式进行保存
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			String path = SYS_PREFIX+IMG_PATH_PREFIX + '/' + System.currentTimeMillis()+suffixName;
			File dest = new File(path);
			urls.add(System.currentTimeMillis()+suffixName);
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}
			try {
				files[i].transferTo(dest);
			} catch (Exception e) {
				log.error("FileController {}", e);
				return ApiResponse.<ImageUrlDTO>builder().code(400).message("上传错误请稍后尝试").data(null).build();
			}
		}
		return ApiResponse.<ImageUrlDTO>builder().code(200).message("操作成功").data(result).build();
	}

	@ApiOperation(value = "图片url接口获取")
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	@ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)})
	public ApiResponse<List<String>> imgRead(@RequestParam("urls") List<String> urls) {
		//拼接路径返回前端
		List newUrls=new ArrayList<>();
		return ApiResponse.<List<String>>builder().code(200).message("操作成功").data(newUrls).build();
	}

	@ApiOperation(value = "图片byte数组内容获取")
	@RequestMapping(value = "/getUrls",method = RequestMethod.GET)
	public ApiResponse<List<byte[]>> imagesRead(@RequestParam("urls") List<String> urls) {
		//拼接路径返回前端
		log.info("请求图片参数 {}", JSON.toJSONString(urls));
		List<byte[]> res =new ArrayList<>();
		for (int i = 0; i <urls.size(); i++) {
			File file = new File(FileConst.allFile + urls.get(i));
			FileInputStream inputStream = null;
			try {
				inputStream = new FileInputStream(file);
				byte[] bytes = new byte[inputStream.available()];
				inputStream.read(bytes, 0, inputStream.available());
				res.add(bytes);
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		return ApiResponse.<List<byte[]>>builder().code(200).message("操作成功").data(res).build();
	}

}
