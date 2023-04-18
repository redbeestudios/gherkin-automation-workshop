package io.redbee.support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class BeeRequest {

    private String base_url;
    private int port;
    private String path;
    private HashMap<String, Object> body;

    private HashMap<String,Object> queryParams;
    private String method;

    public BeeRequest(String base_url) {
        this.base_url = base_url;
        this.queryParams = new HashMap<>();
        this.body = new HashMap<>();
        this.port = 0;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public HashMap<String, Object> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(HashMap<String, Object> queryParams) {
        this.queryParams = queryParams;
    }

    public void setBody(HashMap<String, Object> body) {
        this.body = body;
    }

    public Response execute() {
        Response response;

        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri(this.base_url)
                .basePath(this.path)
                .log().all();

        if (this.port != 0) requestSpecification.port(this.port);

        if (this.method == "GET") {
            if (!this.queryParams.isEmpty())requestSpecification.pathParams(this.queryParams);
            response = requestSpecification.when().get();
        } else {
            if (!this.body.isEmpty()) requestSpecification.body(this.body);
            response = (this.method == "POST") ? requestSpecification.when().post() : requestSpecification.when().put();
        }

        System.out.println(String.format("\nStatus Code: %s",response.statusCode()));
        System.out.println("Response");
        System.out.println(response.prettyPrint());

        return response;
    }
}
