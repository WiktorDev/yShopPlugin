package pl.yshop.plugin.config;

import org.bukkit.configuration.file.FileConfiguration;
import pl.yshop.plugin.Main;
import java.util.logging.Level;

public class Configuration {
    private String apiurl;
    private String apikey;
    private String server;
    private String listPath;
    private String completePath;
    private boolean debug;

    public boolean isDebug() {
        return debug;
    }

    public Configuration(Main instance){
        FileConfiguration config = instance.getConfig();
        this.apiurl = config.getString("auth.apiurl");
        this.apikey = config.getString("auth.apikey");
        this.server = config.getString("auth.server");
        this.listPath = apiurl+"/server/"+server+"/pendingTransactions";
        this.completePath = apiurl+"/server/"+server+"/pendingTransaction";
        this.debug = config.getBoolean("debug");
        if(this.apikey == null){
            instance.getLogger().log(Level.SEVERE, "Wartosc apikey w config.yml jest ustawiona niepoprawnie!");
            instance.getServer().getPluginManager().disablePlugin(instance);
            return;
        }
        if(this.server == null){
            instance.getLogger().log(Level.SEVERE, "Wartosc server w config.yml jest ustawiona niepoprawnie!");
            instance.getServer().getPluginManager().disablePlugin(instance);
            return;
        }
        if(this.apiurl == null){
            instance.getLogger().log(Level.SEVERE, "Wartosc apiurl w config.yml jest ustawiona niepoprawnie!");
            instance.getServer().getPluginManager().disablePlugin(instance);
            return;
        }
    }
    public String getApiurl() {
        return apiurl;
    }

    public String getApikey() {
        return apikey;
    }

    public String getServer() {
        return server;
    }

    public String getListPath() {
        return listPath;
    }

    public String getCompletePath() {
        return completePath;
    }
}