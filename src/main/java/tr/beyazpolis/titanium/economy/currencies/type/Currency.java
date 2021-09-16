package tr.beyazpolis.titanium.economy.currencies.type;

import com.sun.istack.internal.NotNull;
import java.util.List;
import tr.beyazpolis.titanium.economy.currencies.Currencies;
import tr.beyazpolis.titanium.economy.money.type.CurrencyType;

public interface Currency extends Currencies {

  public CurrencyType getCurrencyType();

  public List<String> getLore();

  public boolean isGlow();

  public String getMaterialName();

  public String getNbtName();

  public String getName();

  public void setLore(@NotNull final List<String> lore);

  public void setGlow(@NotNull final boolean glow);

  public void setMaterialName(@NotNull final String materialName);

  public void setNbtName(@NotNull final String nbtName);

  public void setName(@NotNull final String name);

  public String getConfigName();


}
