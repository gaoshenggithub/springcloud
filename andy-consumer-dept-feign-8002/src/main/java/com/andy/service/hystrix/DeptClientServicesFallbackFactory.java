package com.andy.service.hystrix;

import org.springframework.stereotype.Component;

import com.andy.model.Dept;
import com.andy.service.ServiceFeginClient;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServicesFallbackFactory implements FallbackFactory<ServiceFeginClient> {

	@Override
	public ServiceFeginClient create(Throwable cause) {
		return new ServiceFeginClient() {
			@Override
			public String discover() {
				return "服务暂停";
			}

			@Override
			public Dept get(String id) {
				return new Dept().setDb_source("sdf");
			}
		};
	}

}
