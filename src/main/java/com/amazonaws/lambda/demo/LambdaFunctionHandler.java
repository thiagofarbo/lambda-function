package com.amazonaws.lambda.demo;

import java.util.UUID;

import com.amazonaws.lambda.request.ProductRequest;
import com.amazonaws.lambda.response.ProductResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

public class LambdaFunctionHandler implements RequestHandler<ProductRequest, String> {

    @Override
    public String handleRequest(ProductRequest input, Context context) {
        context.getLogger().log("Input: " + input);

        ProductResponse response = new ProductResponse();
        response.setId(UUID.randomUUID().toString());
        response.setName(input.getName());
        
        context.getLogger().log("Response: " + response);
        
        Gson gson = new Gson();
        
        String json = gson.toJson(response);
        
        return json;
    }

}
