package pl.yshop.plugin.objects;

import com.google.gson.JsonObject;

public class Element {
    private String uuid;
    private String nickname;
    private int count;
    private String server;
    private String command;

    public Element(JsonObject object){
        this.uuid = object.get("paymentUUID").getAsString();
        this.nickname = !object.get("nickname").isJsonNull() ? object.get("nickname").getAsString() : null;
        this.count = object.get("count").getAsInt();
        this.server = object.get("server").getAsString();
        this.command = object.get("command").getAsString();
    }

    public String getUuid() {
        return uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public int getCount() {
        return count;
    }

    public String getServer() {
        return server;
    }

    public String getCommand() {
        return command;
    }
}