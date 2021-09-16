package tr.beyazpolis.titanium.economy.bank;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.currencies.Currencies;
import tr.beyazpolis.titanium.economy.exception.CurrencyNBTException;
import tr.beyazpolis.titanium.economy.manager.CurrencyManager;

public class Bank implements ServerBank {

  @NotNull
  private final HashMap<String, Currencies> currenciesHashMap;

  public Bank(){
    this.currenciesHashMap = new HashMap<>();
  }

  private Map<String, Currencies> getCurrenciesMap(){
    return currenciesHashMap;
  }

  @Override
  public void addCurrency(final @NotNull String nbt, final @NotNull Currencies currencies) {
    System.out.println();
    try {
      this.hasCurrencyException(nbt);
      this.getCurrenciesMap().put(nbt,currencies);
    }catch (CurrencyNBTException e){
      e.printStackTrace();
    }
  }

  @Override
  public void removeCurrency(final @NotNull String nbt) {

  }

  @Override
  public void hasCurrencyException(final @NotNull String nbt) {
    if (this.getCurrenciesMap().get(nbt) != null){
      throw new CurrencyNBTException("This currency already exists!");
    }
  }

  @Override
  public boolean hasCurrency(final @NotNull String nbt) {
    return this.getCurrenciesMap().get(nbt) != null;
  }

  @Override
  public void reloadCurrency(final @NotNull CurrencyManager currencyManager) {
    this.getCurrenciesMap().clear();
    currencyManager.loadCurrency();
  }

  @Override
  public Collection<Currencies> getCurrencies() {
    return this.getCurrenciesMap().values();
  }
}
