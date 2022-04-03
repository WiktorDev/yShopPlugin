package pl.yshop.plugin.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import okhttp3.*;
import pl.yshop.plugin.Main;
import pl.yshop.plugin.utils.Logger;

public class ApiRequest {
    @SneakyThrows
    public static JsonObject getPendingTransactions(){
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(Main.getInstance().getConfiguration().getListPath())
                .method("GET", null)
                .addHeader("Auth", Main.getInstance().getConfiguration().getApikey())
                .build();
        Response response = client.newCall(request).execute();
        if(response == null) return null;
        if(Main.getInstance().getConfiguration().isDebug() && response.code() != 200){
            switch (response.code()){
                case 401:
                    Logger.logError("Nazwa serwera, klucz API badz adres api jest niepoprawny!");
                    response.body().close();
                    return null;
                case 404:
                    Logger.logInfo("Nie odnaleziono nowych transakcji do wykonania");
                    response.body().close();
                    return null;
                default:
                    Logger.logWarning("Nieznany status HTTP!");
                    response.body().close();
                    return null;
            }
        }
        JsonObject object = new JsonParser().parse(response.body().string()).getAsJsonObject();
        response.body().close();
        return object;
    }

    @SneakyThrows
    public static void completeTransaction(String uuid){
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "uuid="+uuid);
        Request request = new Request.Builder()
                .url(Main.getInstance().getConfiguration().getCompletePath())
                .method("POST", body)
                .addHeader("Auth", Main.getInstance().getConfiguration().getApikey())
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();
        response.close();
    }
}