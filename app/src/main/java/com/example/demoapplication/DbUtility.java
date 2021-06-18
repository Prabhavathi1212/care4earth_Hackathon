package com.example.demoapplication;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DbUtility {

    private static String token;
    public static void initDButility(Activity activity) throws IOException {
            getAuthToken(activity);
    }
    private static void getAuthToken(Activity activity) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"userid\":\"fbn96143\",\"password\":\"lp6684rf9cfj+gfh\"}");
        Request request = new Request.Builder()
                .url("https://dashdb-txn-sbox-yp-lon02-01.services.eu-gb.bluemix.net/dbapi/v4/auth/tokens")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("x-deployment-id", "crn:v1:bluemix:public:dashdb-for-transactions:eu-gb:a%87bd6e512e70418596cc27c6ca431030:b44ce7fd-8a81-44bc-90a1-2495430c1858::")
                .build();



        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            JSONObject json = new JSONObject(myResponse);
                            token = (String) json.get("token");
                            createTable(activity);
                            String test = (String) json.get("token");
                        } catch (JSONException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });

    }
    public static void createTable(Activity activity) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String txt = "{\"commands\":\"CREATE TABLE contacts (location TEXT, category TEXT, itemAge TEXT, productCondition TEXT, PickupChoice TEXT, PickupAddress TEXT, DeliverAddress TEXT);\",\"limit\":10,\"separator\":\";\",\"stop_on_error\":\"no\"}";
        RequestBody body = RequestBody.create(mediaType, "{\"commands\":\"CREATE TABLE contacts (location TEXT, category TEXT, itemAge TEXT, productCondition TEXT, PickupChoice TEXT, PickupAddress TEXT, DeliverAddress TEXT);\",\"limit\":10,\"separator\":\";\",\"stop_on_error\":\"no\"}");

        Request request = new Request.Builder()
                .url("https://dashdb-txn-sbox-yp-lon02-01.services.eu-gb.bluemix.net/dbapi/v4/sql_jobs")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer " + token)
                .addHeader("x-deployment-id", "crn:v1:bluemix:public:dashdb-for-transactions:eu-gb:a%87bd6e512e70418596cc27c6ca431030:b44ce7fd-8a81-44bc-90a1-2495430c1858::")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            JSONObject json = new JSONObject(myResponse);
                             } catch (JSONException  e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
    public static void insertValues(Activity activity, String location , String category, String itemAge, String  productCondition, String  PickupChoice, String PickupAddress , String DeliverAddress) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        String query = "\"INSERT INTO contacts (location, category, itemAge, productCondition, PickupChoice, PickupAddress, DeliverAddress) VALUES (" +
                "\'"+ location +"\',\'" +category+"\',\'"+itemAge+"\',\'"+ productCondition+"\',\'" + PickupChoice+"\',\'"+ PickupAddress +"\',\'"+DeliverAddress+"\');\"";
      String text = "{\"commands\":" +query+",\"limit\":100,\"separator\":\";\",\"stop_on_error\":\"no\"}";
        RequestBody body = RequestBody.create(mediaType, text);

        Request request = new Request.Builder()
                .url("https://dashdb-txn-sbox-yp-lon02-01.services.eu-gb.bluemix.net/dbapi/v4/sql_jobs")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer " + token)
                .addHeader("x-deployment-id", "crn:v1:bluemix:public:dashdb-for-transactions:eu-gb:a%87bd6e512e70418596cc27c6ca431030:b44ce7fd-8a81-44bc-90a1-2495430c1858::")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String myResponse = response.body().string();

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject json = new JSONObject(myResponse);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
}
