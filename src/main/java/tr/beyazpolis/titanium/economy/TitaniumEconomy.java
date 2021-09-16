package tr.beyazpolis.titanium.economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tr.beyazpolis.titanium.economy.api.EconomyAPI;
import tr.beyazpolis.titanium.economy.api.TitaniumAPI;
import tr.beyazpolis.titanium.economy.bank.Bank;
import tr.beyazpolis.titanium.economy.bank.ServerBank;
import tr.beyazpolis.titanium.economy.listener.PlayerAccountCache;
import tr.beyazpolis.titanium.economy.manager.ConfigManager;
import tr.beyazpolis.titanium.economy.manager.CurrencyManager;

public class TitaniumEconomy extends JavaPlugin {

  private static EconomyAPI economyAPI;

  @Nullable
  private ConfigManager configManager;

  @Nullable
  private CurrencyManager currencyManager;

  @Nullable
  private ServerBank serverBank;

  @Override
  public void onEnable() {
    this.configManager = new ConfigManager(this);
    this.loadingYaml();

    this.serverBank = new Bank();

    this.currencyManager = new CurrencyManager(serverBank,configManager.getBankConfig());
    this.currencyManager.loadCurrency();

    this.getServer().getPluginManager().registerEvents(new PlayerAccountCache(this),this);

    economyAPI = new TitaniumAPI(this);
  }

  @Override
  public void onDisable() {
    this.getConfigManager().save();
    configManager = null;
  }

  @NotNull
  public ConfigManager getConfigManager() {
    if (this.configManager == null){
      this.configManager = new ConfigManager(this);
    }
    return configManager;
  }

  @NotNull
  public CurrencyManager getCurrencyManager() {
    if (currencyManager == null)
      this.currencyManager = new CurrencyManager(this.getServerBank(),this.getConfigManager().getBankConfig());
    return currencyManager;
  }

  @NotNull
  public ServerBank getServerBank() {
    if (serverBank == null)
      this.serverBank = new Bank();
    return serverBank;
  }

  public static EconomyAPI getEconomyAPI() {
    return economyAPI;
  }

  private void loadingYaml(){
    Bukkit.getScheduler().runTaskAsynchronously(this, () -> this.getConfigManager().loading());
  }
}
