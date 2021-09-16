package tr.beyazpolis.titanium.economy.currencies.type.original;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.bank.ServerBank;
import tr.beyazpolis.titanium.economy.currencies.type.Currency;
import tr.beyazpolis.titanium.economy.money.type.CurrencyType;

public class DefaultCurrency implements Currency {

  private List<String> lore;
  private boolean glow;
  private String materialName;
  private String nbtName;

  private String name;
  private final String configName;

  private CurrencyType currencyType;

  public DefaultCurrency(final String name,
                         final List<String> lore,
                         final boolean glow,
                         final String material,
                         final String nbtName,
                         @NotNull final String configName,
                         @NotNull final CurrencyType type) {
    this.lore = lore;
    this.glow = glow;
    this.materialName = material;
    this.nbtName = nbtName;
    this.name = name;
    this.configName = configName;
    this.currencyType = type;
  }

  @Override
  public ItemStack saveMenuItem() {
    if (Material.getMaterial(materialName.toUpperCase()) == null){
      throw new NullPointerException("TitaniumEconomy currency menu material is null ! CurrencyName; " + configName);
    }

    final ItemStack stack = new ItemStack(Objects.requireNonNull(Material.getMaterial(materialName.toUpperCase())));
    final ItemMeta meta = stack.getItemMeta();

    if (meta == null){
      throw new NullPointerException("TitaniumEconomy currency info save method ItemStack is null! (CurrencyInfo)");
    }

    final List<String> mainLore = new ArrayList<>();
    for (final String s : lore) {
      mainLore.add(ChatColor.translateAlternateColorCodes('&',s));
    }

    meta.setLore(mainLore);

    if (name == null){
      throw new NullPointerException("TitaniumEconomy item name is null! CurrencyInfo.class");
    }

    meta.setDisplayName(name);
    stack.setItemMeta(meta);

    return stack;
  }

  @Override
  public String getConfigName() {
    return configName;
  }

  @Override
  public CurrencyType getCurrencyType() {
    return currencyType;
  }

  @Override
  public List<String> getLore() {
    return lore;
  }

  @Override
  public boolean isGlow() {
    return glow;
  }

  @Override
  public String getMaterialName() {
    return materialName;
  }

  @Override
  public String getNbtName() {
    return nbtName;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setLore(final List<String> lore) {
    this.lore = lore;
  }

  @Override
  public void setGlow(final boolean glow) {
    this.glow = glow;
  }

  @Override
  public void setMaterialName(final String materialName) {
    this.materialName = materialName;
  }

  @Override
  public void setNbtName(final String nbtName) {
    this.nbtName = nbtName;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

}
