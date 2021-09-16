package tr.beyazpolis.titanium.economy.currencies.type.original;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.currencies.type.Currency;
import tr.beyazpolis.titanium.economy.currencies.type.CurrencyItem;

public class ItemCurrency implements CurrencyItem {

  private String itemDisplayName;

  private String itemMaterialName;
  private List<String> itemLore;
  private boolean itemGlow;

  @NotNull
  private final Currency currency;

  public ItemCurrency(final String itemDisplayName,
                      final String itemMaterialName,
                      final List<String> itemLore,
                      final boolean itemGlow,
                      final @NotNull Currency currency) {
    this.itemDisplayName = itemDisplayName;
    this.itemMaterialName = itemMaterialName;
    this.itemLore = itemLore;
    this.itemGlow = itemGlow;
    this.currency = currency;
  }

  @Override
  @NotNull
  public ItemStack saveCurrencyItem() {
    if (Material.getMaterial(itemMaterialName.toUpperCase()) == null){
      throw new NullPointerException("TitaniumEconomy currency item material is null ! CurrencyName; " + currency.getConfigName());
    }

    final ItemStack stack = new ItemStack(Objects.requireNonNull(Material.getMaterial(itemMaterialName.toUpperCase())));
    final ItemMeta meta = stack.getItemMeta();

    if (meta == null){
      throw new NullPointerException("TitaniumEconomy currency item save method ItemMeta is null!");
    }

    final List<String> mainLore = new ArrayList<>();
    for (final String s : itemLore) {
      mainLore.add(ChatColor.translateAlternateColorCodes('&',s));
    }

    meta.setLore(mainLore);

    if (itemDisplayName == null){
      throw new NullPointerException("TitaniumEconomy item name is null!");
    }

    meta.setDisplayName(itemDisplayName);
    stack.setItemMeta(meta);

    return stack;
  }

  @Override
  @NotNull
  public ItemStack saveMenuItem() {
    return currency.saveMenuItem();
  }

  @Override
  @NotNull
  public Currency getCurrency() {
    return currency;
  }

  @Override
  public String getItemName() {
    return itemDisplayName;
  }

  @Override
  public boolean isItemGlow() {
    return itemGlow;
  }

  @Override
  public List<String> getItemLore() {
    return itemLore;
  }

  @Override
  public String getItemMaterial() {
    return itemMaterialName;
  }

  @Override
  public void setItemDisplayName(final String itemDisplayName) {
    this.itemDisplayName = itemDisplayName;
  }

  @Override
  public void setItemGlow(final boolean itemGlow) {
    this.itemGlow = itemGlow;
  }

  @Override
  public void setItemLore(final List<String> itemLore) {
    this.itemLore = itemLore;
  }

  @Override
  public void setItemMaterialName(final String itemMaterial) {
    this.itemMaterialName = itemMaterial;
  }


}
