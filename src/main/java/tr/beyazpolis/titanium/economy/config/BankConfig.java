package tr.beyazpolis.titanium.economy.config;

import java.util.Arrays;
import org.bukkit.plugin.Plugin;

public class BankConfig extends Config {

  public BankConfig(final Plugin plugin, final String ymlName) {
    super(plugin, ymlName);
  }

  @Override
  public void loadYML() {
    super.loadYML();
    if (!isSet("Currency")){

      this.set("Currency.Gold.nbt","gold#1923");
      this.set("Currency.Gold.type","item");

      this.set("Currency.Gold.settings.menus.display_name","&6Gold Bar");
      this.set("Currency.Gold.settings.menus.material","GOLD_INGOT");
      this.set("Currency.Gold.settings.menus.glow",false);
      this.set("Currency.Gold.settings.menus.lore", Arrays.asList("","",""));

      this.set("Currency.Gold.settings.item.display_name","&6Gold Bar");
      this.set("Currency.Gold.settings.item.material","GOLD_INGOT");
      this.set("Currency.Gold.settings.item.glow",false);
      this.set("Currency.Gold.settings.item.lore", Arrays.asList("","",""));

      this.set("Currency.CrystalCoin.nbt","CrystalCoin");
      this.set("Currency.CrystalCoin.type","virtual");

      this.set("Currency.CrystalCoin.settings.menus.display_name","&3Crystal Coin");
      this.set("Currency.CrystalCoin.settings.menus.material","CRYSTAL");
      this.set("Currency.CrystalCoin.settings.menus.glow",false);
      this.set("Currency.CrystalCoin.settings.menus.lore", Arrays.asList("","",""));

      this.set("Currency.Xp.nbt","XPShop");
      this.set("Currency.Xp.type","xp");

      this.set("Currency.Xp.settings.menus.display_name","&2XP");
      this.set("Currency.Xp.settings.menus.material","Stone");
      this.set("Currency.Xp.settings.menus.glow",false);
      this.set("Currency.Xp.settings.menus.lore", Arrays.asList("","",""));
    }
  }
}
