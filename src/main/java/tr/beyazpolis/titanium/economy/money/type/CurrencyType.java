package tr.beyazpolis.titanium.economy.money.type;

import org.jetbrains.annotations.NotNull;

public enum CurrencyType {
  ITEM("item"),
  EXP("xp"),
  VIRTUAL("Virtual");

  private final String name;

  private CurrencyType(final String name){
    this.name = name;
  }

  @NotNull
  public static CurrencyType ofType(String name, String currencyName){
    if (name == null)
      throw new NullPointerException("TitaniumEconomy " + currencyName + ": The currency type is null!");

    for (final CurrencyType value : values()) {
      if (value.getName().equalsIgnoreCase(name)){
        return value;
      }
    }

    throw new UnsupportedOperationException("TitaniumEconomy " + currencyName + ": The " + name + " is Unsupported currency type!");
  }

  public String getName() {
    return name;
  }
}
