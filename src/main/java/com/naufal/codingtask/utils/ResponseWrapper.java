package com.naufal.codingtask.utils;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResponseWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // Only apply this advice if @WrapWithKey is present
        return returnType.hasMethodAnnotation(WrapWithKey.class);
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response
    ) {
        // If annotation is missing, return body directly (shouldn't happen due to supports() check)
        WrapWithKey annotation = returnType.getMethodAnnotation(WrapWithKey.class);
        if (annotation == null) {
            return body;
        }

        // Otherwise, wrap in a dynamic key
        String key = annotation.value();
        Map<String, Object> wrapper = new HashMap<>();
        wrapper.put(key, body);
        return wrapper;
    }
}
