package pl.yshop.plugin.objects;

import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import java.util.ArrayList;
import java.util.List;

public class ElementUtil {
    private static final List<Element> elements = new ArrayList<>();

    public static List<Element> getElements(){
        return elements;
    }

    @SneakyThrows
    public void loadElements(JsonObject object){
        elements.clear();
        object.get("data").getAsJsonArray().forEach(jsonElement -> {
            Element element = new Element(jsonElement.getAsJsonObject());
            elements.add(element);
        });
    }
}