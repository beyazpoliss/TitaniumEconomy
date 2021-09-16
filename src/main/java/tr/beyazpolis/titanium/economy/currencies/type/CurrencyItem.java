package tr.beyazpolis.titanium.economy.currencies.type;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.bank.ServerBank;
import tr.beyazpolis.titanium.economy.currencies.Currencies;

public interface CurrencyItem extends Currencies {

  public ItemStack saveCurrencyItem();

  public Currency getCurrency();

  public String getItemName();

  public boolean isItemGlow();

  public List<String> getItemLore();

  public String getItemMaterial();

  public void setItemDisplayName(final String itemDisplayName);

  public void setItemGlow(final boolean itemGlow);

  public void setItemLore(final List<String> itemLore);

  public void setItemMaterialName(final String itemMaterial);

}
