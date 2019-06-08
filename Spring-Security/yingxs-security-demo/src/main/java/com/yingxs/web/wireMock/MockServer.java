package com.yingxs.web.wireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.removeAllMappings;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;


public class MockServer {
	
	public static void main(String[] args) throws IOException  {
		configureFor(9090);
		removeAllMappings();

		mock ("/order/1","01");
		mock ("/order/2","02");
		
		
		
	}

	private static void mock(String url, String file) throws IOException {
		ClassPathResource resource = new ClassPathResource("mock/response/"+file+".txt");
		String tontent = FileUtils.readFileToString(resource.getFile(),"utf-8");
		stubFor(get(urlEqualTo(url)).willReturn(aResponse().withBody(tontent).withStatus(200)));
		
	}
	

}
