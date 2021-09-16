package tr.beyazpolis.titanium.economy.manager;

import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.bank.ServerBank;
import tr.beyazpolis.titanium.economy.config.BankConfig;
import tr.beyazpolis.titanium.economy.loader.CurrencyLoader;

public class CurrencyManager {

  @NotNull
  private final BankConfig bankConfig;

  @NotNull
  private final CurrencyLoader currencyLoader;

  public CurrencyManager(@NotNull final ServerBank serverBank,@NotNull final BankConfig bankConfig) {
    this.bankConfig = bankConfig;
    this.currencyLoader = new CurrencyLoader(serverBank);
  }

  public void loadCurrency(){
    for (String currencyNames : bankConfig.getKeys("Currency",false)){
      currencyLoader.load(currencyNames,bankConfig);
    }
  }

  @NotNull
  public BankConfig getBankConfig() {
    return bankConfig;
  }

  @NotNull
  public CurrencyLoader getCurrencyLoader() {
    return currencyLoader;
  }
}
