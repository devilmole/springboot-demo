package org.devilmole.remote;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
public class HttpClientTool {

    private static Logger logger = LogManager.getLogger(HttpClientTool.class);

    /**
     * 5分钟
     */
    public static final int MINUTE_FIVE = 300000;

    /**
     * 10分钟
     */
    public static final int MINUTE_TEN  = 600000;

    /**
     * HttpClient
     */
    private static final HttpClient client      = getInstance();

    /**
     * 让Httpclient支持https
     *
     * @return HttpClient
     */
    private static HttpClient getInstance() {
        X509TrustManager x509mgr = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] xcs, String string) {
            }
            @Override
            public void checkServerTrusted(X509Certificate[] xcs, String string) {
            }
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance(SSLConnectionSocketFactory.SSL);
            sslContext.init(null, new TrustManager[] { x509mgr }, null);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            logger.error("error to init httpclient", e);
        }
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    public static final RequestConfig getDefaultTimeOutConfig() {
        return getTimeOutConfig(60000, 30000);
    }

    private static final RequestConfig getTimeOutConfig(int socketTimeout, int connectionTimeout) {
        return RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectionTimeout).build();
    }

    /**
     * Get方法查询
     */
    public static String getMethodGetResponse(String address) throws Exception {
        return getMethodGetResponse(address, getDefaultTimeOutConfig());
    }
    /**
     * Post方法查询
     */
    public static String getMethodPostResponse(String address, Map<String, String> map) throws Exception {
        RequestConfig config = getDefaultTimeOutConfig();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()){
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        HttpEntity inputEntity=new UrlEncodedFormEntity(nvps,"UTF-8");
        return getMethodPostResponse(address, inputEntity, config);
    }

    /**
     * HttpClient Post方法请求数据
     */
    private static String getMethodPostResponse(String address, HttpEntity paramEntity, RequestConfig config)
            throws Exception {
        logger.info("Begin Access Url(" + address + ") By Post");
        byte[] content = getMethodPostContent(address, paramEntity, config);
        String result = new String(content, "utf-8");
        logger.info("Response -> " + result);
        return result;

    }

    /**
     * HttpClient Get方法请求数据
     */
    private static String getMethodGetResponse(String address, RequestConfig config) throws Exception {
        logger.info("Start Access Address(" + address + ") With Get Request");
        byte[] result = getMethodGetContent(address, config);
        return new String(result, "utf-8");
    }

    /**
     * Post Entity
     */
    private static byte[] getMethodPostContent(String address, HttpEntity paramEntity, RequestConfig config)
            throws Exception {
        HttpPost post = new HttpPost(address);
        try {
            if (paramEntity != null) {
                post.setEntity(paramEntity);
            }
            post.setConfig(config);
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                int code = response.getStatusLine().getStatusCode();
                throw new RuntimeException("HttpPost Request Access Fail Return Code(" + code + ")");
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                throw new RuntimeException("HttpPost Request Access Fail Response Entity Is null");
            }
            return convertEntityToBytes(entity);
        } finally {
            if (post != null) {
                post.releaseConnection();
            }
        }
    }
    /**
     * HttpClient get方法请求返回Entity
     */
    private static byte[] getMethodGetContent(String address, RequestConfig config) throws Exception {
        HttpGet get = new HttpGet(address);
        try {
            logger.info("Start Access Address(" + address + ") With Get Request");
            get.setConfig(config);
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                int code = response.getStatusLine().getStatusCode();
                throw new RuntimeException("HttpGet Access Fail , Return Code(" + code + ")");
            }
            return convertEntityToBytes(response.getEntity());
        } finally {
            if (get != null) {
                get.releaseConnection();
            }
        }
    }
    /**
     * 转化返回为byte数组
     *
     * @param entity
     * @return byte[]
     * @throws Exception
     */
    private static byte[] convertEntityToBytes(HttpEntity entity) throws Exception {
        InputStream inputStream = null;
        try {
            if (entity == null || entity.getContent() == null) {
                throw new RuntimeException("Response Entity Is null");
            }
            inputStream = entity.getContent();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
            return out.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

}
