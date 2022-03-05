package pl.yshop.plugin.objects;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
