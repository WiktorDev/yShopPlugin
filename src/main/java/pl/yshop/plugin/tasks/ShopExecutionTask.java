package pl.yshop.plugin.tasks;

import pl.yshop.plugin.objects.ElementUtil;

public abstract class ShopExecutionTask implements Runnable {
    public abstract void executeCommand(String command);
    @Override
    public void run() {
        ElementUtil.getElements().forEach(element ->{
            String command = element.getCommand();
            String paymentUUID = element.getUuid();
            String formmatedCommand = command.replace("{PLAYER}", element.getNickname()).replace("{COUNT}", String.valueOf(element.getCount()));
            this.executeCommand(formmatedCommand);
        });
    }
}