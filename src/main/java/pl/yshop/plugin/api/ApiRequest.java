package pl.yshop.plugin.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.yshop.plugin.Main;

public class ApiRequest {
    @SneakyThrows
    public static JsonObject getPendingTransactions(){
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("http://1c49-62-133-144-183.ngrok.io/publicapi/server/"+Main.getInstance().getConfiguration().getServer()+"/pendingTransactions")
                .method("GET", null)
                .addHeader("Auth", Main.getInstance().getConfiguration().getApikey())
                .build();
        Response response = client.newCall(request).execute();
        JsonObject object = new JsonParser().parse(response.body().string()).getAsJsonObject();
        return object;
    }

    @SneakyThrows
    public static void completeTransaction(String uuid){

    }
}
