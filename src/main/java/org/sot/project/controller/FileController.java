package org.sot.project.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.sot.project.common.ApiResponse;
import org.sot.project.common.DataType;
import org.sot.project.common.ParamType;
import org.sot.project.controller.dto.ImageUrlDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/03
 **/
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

	public final static String IMG_PATH_PREFIX = "static/upload/imgs";


	@ApiOperation(value = "图片上传")
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	@ApiImplicitParams({@ApiImplicitParam(name = "files", value = "文件数组", dataType = DataType.ARRAY, paramType = ParamType.PATH)})
	public ApiResponse<ImageUrlDTO> httpUpload(@RequestParam("files") MultipartFile files[]) {
		ImageUrlDTO result = new ImageUrlDTO();
		List<String> urls = result.getUrls();
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getOriginalFilename();  // 文件名
			String path = IMG_PATH_PREFIX + '/' + fileName;
			File dest = new File(path);
			urls.add(path);
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

}
