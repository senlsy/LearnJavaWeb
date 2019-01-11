package soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(CDPlayerConfig.class)//导入另外的javaconfig文件，会创建CDPlayer类型的bean，依赖compactDisc实例
@ImportResource("classpath:cd-config.xml")//导入xml配置文件，会创建BlankDisc类型的bean：compactDisc实例
public class SoundSystemConfig {

}
