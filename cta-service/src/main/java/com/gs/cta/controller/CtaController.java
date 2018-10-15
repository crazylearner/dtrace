package com.gs.cta.controller;

import brave.http.HttpTracing;
import brave.httpclient.TracingHttpClientBuilder;
import com.google.gson.Gson;
import com.gs.cta.config.GSApplicationContext;
import com.gs.cta.dao.CTARepository;
import com.gs.cta.entity.CallToAction;
import com.sun.javafx.collections.MappingChange;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.httpclient.DefaultApacheHttpClientFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by schellamuthu on 12/10/18.
 */
@RestController
@RequestMapping(value = "/cta")
@Slf4j
public class CtaController {

    @Autowired
    CTARepository ctaDao;

    @Autowired
    HttpTracing tracing;


    @PostMapping
    public Response createCta(@RequestBody CallToAction callToAction) {
        Response response  =  new Response();
        response.setId(ctaDao.save(callToAction).getId());
        sendEmail();
        response.setSuccess(true);
        return response;
    }

    private void sendEmail() {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            httpClient = TracingHttpClientBuilder.create(tracing).build();
            HttpPost httpPost = new HttpPost("http://localhost:8802/email/send");
            EmailRequest er = new EmailRequest();
            er.setSubject("Hey ya!!");
            er.setTo("sowmiyachellamuthu@gmail.com");
            er.setText("Wow! This is some random test.. ");
            httpPost.setHeader("Content-Type", "application/json");
            String erStr = new Gson().toJson(er);
            StringEntity stringEntity = new StringEntity(erStr);
            httpPost.setEntity(stringEntity);
            closeableHttpResponse = httpClient.execute(httpPost);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        } finally {
            HttpClientUtils.closeQuietly(closeableHttpResponse);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }

    @Data
    public class Response {
        private boolean success;
        private long id;
    }

    @Data
    public static class EmailRequest {
        String to;
        String subject;
        String text;
    }
}
