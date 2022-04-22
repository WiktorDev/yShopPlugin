package pl.yshop.plugin.tasks;

import org.bukkit.Bukkit;
import pl.yshop.plugin.api.ApiRequest;
import pl.yshop.plugin.objects.Element;
import pl.yshop.plugin.objects.ElementUtil;
import pl.yshop.plugin.serialize.Serializer;

import java.util.ArrayList;
import java.util.List;

public abstract class ShopExecutionTask implements Runnable {
    public abstract void executeCommand(String command);

    @Override
    public void run() {
        new ElementUtil().loadElements(ApiRequest.getPendingTransactions());
       ElementUtil.getElements().forEach(element ->{
            String paymentUUID = element.getUuid();
            Serializer.deserialize(element.getCommand()).forEach(command -> {
                if(command == null) return;
                String formmatedCommand = command.replace("{PLAYER}", element.getNickname()).replace("{COUNT}", String.valueOf(element.getCount()));
                this.executeCommand(formmatedCommand);
            });
            ApiRequest.completeTransaction(paymentUUID);
        });
    }
}