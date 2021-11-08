package org.sot.project.common;

/**
 * @description:
 * @author:maidang
 * @date:2021/11/07
 **/
public class FileConst {
	//mac 和linux 路径不一样
	public final static String IMG_PATH_PREFIX = "/src/main/resources/static/upload/imgs/";
	public final  static  String SYS_PREFIX= System.getProperty("user.dir");
	public final static  String allFile = SYS_PREFIX+IMG_PATH_PREFIX;

}
