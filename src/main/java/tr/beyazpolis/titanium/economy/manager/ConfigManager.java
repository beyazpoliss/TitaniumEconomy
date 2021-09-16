package tr.beyazpolis.titanium.economy.manager;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tr.beyazpolis.titanium.economy.config.BankConfig;
import tr.beyazpolis.titanium.economy.config.MenusConfig;

public class ConfigManager {

  @Nullable
  private MenusConfig menusConfig;

  @Nullable
  private BankConfig bankConfig;

  @NotNull
  private final Plugin plugin;

  public ConfigManager(@NotNull final Plugin plugin) {
    this.plugin = plugin;
    this.menusConfig = new MenusConfig(plugin,"menus.yml");
    this.bankConfig = new BankConfig(plugin,"bank.yml");
  }

  public void loading(){
    this.getMenusConfig().loadYML();
    this.getBankConfig().loadYML();
    this.getMenusConfig().saveYML();
    this.getBankConfig().saveYML();
  }

  public void save(){
    this.getMenusConfig().saveYML();
    this.getBankConfig().saveYML();
  }

  @NotNull
  public BankConfig getBankConfig() {
    if (bankConfig == null)
      this.bankConfig = new BankConfig(plugin,"bank.yml");
    return bankConfig;
  }

  @NotNull
  public MenusConfig getMenusConfig() {
    if (menusConfig == null)
      this.menusConfig = new MenusConfig(plugin,"menus.yml");
    return menusConfig;
  }

  @NotNull
  public Plugin getPlugin() {
    return plugin;
  }
}
