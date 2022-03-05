package pl.yshop.plugin.config;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;
import pl.yshop.plugin.Main;

import java.util.logging.Level;

@Getter
@Setter
public class Configuration {
    private String apiurl = "https://yshop.pl/publicapi";
    private String apikey;
    private String server;

    public Configuration(Main instance){
        FileConfiguration config = instance.getConfig();;
        this.apikey = config.getString("auth.apikey");
        this.server = config.getString("auth.server");
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
    }
}
