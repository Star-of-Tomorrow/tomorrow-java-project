package org.sot.project;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Timing
 * @date 2021/11/2 8:49 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DemoApplicationTests {
	public static void main(String[] args) {
		DocsConfig config = new DocsConfig();
		config.setProjectPath("/Users/shidu/SelfProjects/tomorrow-java-project"); // root project path
		config.addJavaSrcPath("/Users/shidu/SelfProjects/tomorrow-java-project/src/main/java");
		config.setProjectName("tomorrow-java-project"); // project name
		config.setApiVersion("V1.0");       // api version
		config.setDocsPath("/Users/shidu/SelfProjects/tomorrow/tomorrow-doc"); // api docs target path
		config.setAutoGenerate(Boolean.TRUE);  // auto generate
		Docs.buildHtmlDocs(config); // execute to generate
	}
}