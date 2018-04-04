package com.yf.resources;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FdfsClientConfig.class)
public class ResourcesApplication {

    public static void main(String[] args) {

        SpringApplication.run(ResourcesApplication.class, args);

    }

}
