package org.koreait.global.configs;

import org.springframework.beans.factory.annotation.
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class FileUploadConfug implements WebMvcConfigurer {
    @Value("${file.upload.path}")
    private String filePath;

    @Value("${file.upload.url}")
    private String fileUrl;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileUrl + "**").addResourceLocations("file:///" + filePath);
    }
}
