package com.practicaldime.gql;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.practicaldime.zesty.app.AppServer;
import com.practicaldime.zesty.servlet.HandlerRequest;
import com.practicaldime.zesty.servlet.HandlerResponse;

public class CountriesApp {
	
	private static final Logger LOG = LoggerFactory.getLogger(CountriesApp.class);
	private static final String CRLF = "\r\n";
	
	public static void main(String[] args) {
		int port = 1337;
		String host = "localhost";
		
		Map<String, String> props = Maps.newHashMap();
		props.put("appctx", "/ws");
		props.put("cors", "true");

		AppServer router = new AppServer(props).router();
		
		router
		.get("/check", "", "application/json", null, (HandlerRequest request, HandlerResponse response) -> {
			response.send(String.format("incoming request: '%s'", request.getRequestURI()));
			return null;
		})
		.post("/graphql", "", "application/json", null, (HandlerRequest request, HandlerResponse response) -> {
			String query = request.body(String.class);
			response.send(String.format("incoming request: '%s'", request.getRequestURI()));
			return null;
		})		
		.listen(port, host, (msg) -> {
			LOG.info(msg);
		});		
	}
}
