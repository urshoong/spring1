package org.zerock.spring1.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

//web.xml
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //ZerockSecurityConfig.class 추가해야 사용할 수 있다
        return new Class[]{RootConfig.class, ZerockSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ZerockServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        return new Filter[] {filter};
    }

    //파일업로드를 위한 web.xml 설정
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        // MultipartConfigElement(임시폴더경로, 파일최대크기, , 어느 크기까지 메모리에 저장해둘거냐)
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement("C:\\upload\\temp");

        registration.setMultipartConfig(multipartConfigElement);

    }
}
