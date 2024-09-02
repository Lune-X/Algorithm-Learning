package com.xyc;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatGPT {

    private static final String API_KEY = "2241a291e50d455a8e425bd205d1907c";
    private static final String GPT_API_URL = "https://api.aimlapi.com/chat/completions";


    // 封装的API调用方法
    public String getGPTResponse(List<JSONObject> conversation) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // 创建JSON请求体
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("model", "gpt-4");
        jsonBody.put("messages", new JSONArray(conversation));  // 包含整个对话历史
        jsonBody.put("temperature", 0.7);

        // 创建HTTP请求
        RequestBody body = RequestBody.create(jsonBody.toString(), MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(GPT_API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        // 发送请求并获取响应
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        // 解析响应，提取GPT的内容
        String responseBody = response.body().string();
        JSONObject responseJson = new JSONObject(responseBody);
        JSONArray choices = responseJson.getJSONArray("choices");
        return choices.getJSONObject(0).getJSONObject("message").getString("content").trim();
    }

    public static void main(String[] args) {
        ChatGPT chatGPTApp = new ChatGPT();
        Scanner scanner = new Scanner(System.in);

        // 创建一个列表来维护对话历史
        List<JSONObject> conversation = new ArrayList<>();

        System.out.println("你可以开始提问了，输入 'exit' 退出对话。");

        while (true) {
            System.out.println("请输入您的问题：");
            String userInput = scanner.nextLine();

            // 如果用户输入 'exit'，则退出对话
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("对话结束。");
                break;
            }

            try {
                // 将用户的输入添加到对话中
                JSONObject userMessage = new JSONObject();
                userMessage.put("role", "user");
                userMessage.put("content", userInput);
                conversation.add(userMessage);

                // 调用封装的API调用方法
                String gptResponse = chatGPTApp.getGPTResponse(conversation);
                System.out.println("GPT的回答: " + gptResponse);

                // 将GPT的回复添加到对话中
                JSONObject gptMessage = new JSONObject();
                gptMessage.put("role", "assistant");
                gptMessage.put("content", gptResponse);
                conversation.add(gptMessage);

            } catch (IOException e) {
                System.err.println("API调用失败: " + e.getMessage());
            }
        }

        scanner.close();
    }
}