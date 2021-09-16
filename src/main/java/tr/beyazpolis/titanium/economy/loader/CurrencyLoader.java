package tr.beyazpolis.titanium.economy.loader;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.bank.ServerBank;
import tr.beyazpolis.titanium.economy.currencies.Currencies;
import tr.beyazpolis.titanium.economy.currencies.type.Currency;
import tr.beyazpolis.titanium.economy.currencies.type.CurrencyItem;
import tr.beyazpolis.titanium.economy.currencies.type.original.DefaultCurrency;
import tr.beyazpolis.titanium.economy.config.BankConfig;
import tr.beyazpolis.titanium.economy.currencies.type.original.ItemCurrency;
import tr.beyazpolis.titanium.economy.exception.CurrencyNBTException;
import tr.beyazpolis.titanium.economy.exception.CurrencyNotTypeException;
import tr.beyazpolis.titanium.economy.money.type.CurrencyType;

public class CurrencyLoader {

  @NotNull
  private final ServerBank serverBank;

  public CurrencyLoader(@NotNull final ServerBank serverBank) {
    this.serverBank = serverBank;
  }

  public void load(@NotNull final String currencyName,@NotNull final BankConfig bankConfig){
    try {
      this.load(currencyName,CurrencyType.ofType(bankConfig.getConfiguration().getString("Currency." + currencyName + ".currencyType"), currencyName),bankConfig);
    }catch (UnsupportedOperationException | NullPointerException e){
      e.printStackTrace();
    }
  }

  private void load(@NotNull final String currencyName,final CurrencyType currencyType,final BankConfig bankConfig){
    boolean typeItem = currencyType.getName().equalsIgnoreCase("item");
    boolean xp = currencyType.getName().equalsIgnoreCase("xp");
    boolean virtual = currencyType.getName().equalsIgnoreCase("virtual");

    final String menuItemName = bankConfig.getConfiguration().getString("Currency."+ currencyName + ".settings.menus.display_name");
    final List<String> menuItemLore = bankConfig.getConfiguration().getStringList("Currency."+ currencyName + ".settings.menus.lore");
    final boolean menuItemGlow = bankConfig.getConfiguration().getBoolean("Currency."+ currencyName + ".settings.menus.glow");
    final String nbtName = bankConfig.getConfiguration().getString("Currency."+ currencyName + ".nbt");
    final String menuItemMaterialName = bankConfig.getConfiguration().getString("Currency."+ currencyName + ".settings.menus.material");

    final Currency currency = new DefaultCurrency(menuItemName,menuItemLore,menuItemGlow,menuItemMaterialName,nbtName,currencyName,currencyType);
    try {
      currency.saveMenuItem();
      if (typeItem){
        final String itemName = bankConfig.getConfiguration().getString("Currency."+ currencyName + ".settings.item.display_name");
        final String materialName = bankConfig.getConfiguration().getString("Currency."+ currencyName + ".settings.item.material");
        final boolean glow = bankConfig.getConfiguration().getBoolean("Currency."+ currencyName + ".settings.item.glow");
        final List<String> itemLore = bankConfig.getConfiguration().getStringList("Currency."+ currencyName + ".settings.item.lore");
        final CurrencyItem itemCurrency = new ItemCurrency(itemName,materialName,itemLore,glow,currency);
        itemCurrency.saveCurrencyItem();
        this.load(itemCurrency);
      } else if (xp || virtual){
        this.load(currency);
      }
      throw new CurrencyNotTypeException("Currency is not type!");
    }catch (NullPointerException | CurrencyNBTException | CurrencyNotTypeException e){
      e.printStackTrace();
      System.out.println("TitaniumEconomy " + currencyName + ": Currency is not load!");
    }
  }

  private void load(@NotNull Currencies currencies){
    if (currencies instanceof CurrencyItem){
      final CurrencyItem currencyItem = (CurrencyItem) currencies;
      serverBank.addCurrency(currencyItem.getCurrency().getNbtName(),currencyItem);
    } else if (currencies instanceof Currency){
      serverBank.addCurrency(((Currency) currencies).getNbtName(),currencies);
    }
  }

  @NotNull
  public ServerBank getServerBank() {
    return serverBank;
  }
}
