package com.fortis.tictactoe.configs;

import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fortis.tictactoe.enums.ExceptionType;
import com.fortis.tictactoe.models.ApiException;
import com.fortis.tictactoe.models.ApiResponse;

@SuppressWarnings({ "rawtypes", "unchecked" })
@RestControllerAdvice(basePackages = "com.fortis.tictactoe.controllers")
public class ResponseAdvise implements ResponseBodyAdvice {

	private static final Logger LOG = Logger.getLogger(ResponseAdvise.class);

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return !"org.springframework.http.converter.ByteArrayHttpMessageConverter".equals(converterType.getName());
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		try {
			if (body == null) {
				return new ApiResponse<>(null);
			} else {
				if (body.getClass().equals(ApiException.class)) {
					LOG.error(((ApiException) body).getMessage(), ((ApiException) body));
					return new ApiResponse<>(null, false, ((ApiException) body).getExceptionType().name());
				} else {
					return new ApiResponse<>(body);
				}
			}
		} catch (Exception e) {
			return new ApiResponse(null, false, ExceptionType.SERVER_ERROR.name());
		}
	}
}
