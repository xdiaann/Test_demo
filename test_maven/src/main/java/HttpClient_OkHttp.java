import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author MR.Z
 * @date 2020/1/15 10:49
 */
public class HttpClient_OkHttp {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    private OkHttpClient client = new OkHttpClient();
    private final String BASE_URL = "";

    @Test
    public void testGet() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void okHttpTestGet() throws IOException {
        String api = "/api/files/1";
        String url = String.format("%s%s", BASE_URL, api);
        Request request = new Request.Builder().url(url).get().build();
        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    @Test
    public void testPost() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        HttpPost httpPost = new HttpPost(url);
        CommonTest.UserVO userVO = CommonTest.UserVO.builder().name("h2t2").build();
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        httpPost.setEntity(new StringEntity(JSONObject.toJSONString(userVO), "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void okHttpTestPost() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        //请求参数
        JSONObject json = new JSONObject();
        json.put("name", "hetiantian");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), String.valueOf(json));
        //post请求
        Request request = new Request.Builder().url(url).post(requestBody).build();

        final Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }

    @Test
    public void testPut() throws IOException {
        String api = "/api/user";
        String url = String.format("%s%s", BASE_URL, api);
        HttpPut httpPut = new HttpPut(url);
        CommonTest.UserVO userVO = CommonTest.UserVO.builder().name("h2t").id(16L).build();
        httpPut.setHeader("Content-Type", "application/json;charset=utf8");
        httpPut.setEntity(new StringEntity(JSONObject.toJSONString(userVO), "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPut);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }


}
