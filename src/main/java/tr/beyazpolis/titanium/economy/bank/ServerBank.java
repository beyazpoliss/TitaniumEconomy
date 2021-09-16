package tr.beyazpolis.titanium.economy.bank;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.currencies.Currencies;
import tr.beyazpolis.titanium.economy.manager.CurrencyManager;

public interface ServerBank {

  /**
   * @param nbt is nbt name.
   * @param currencies is Currency.
   * This method saves the bank a new type of money.
   */
  public void addCurrency(@NotNull final String nbt, @NotNull final Currencies currencies);

  /**
   * @param nbt is nbt name.
   * This method deletes a type of money from the bank.
   */
  public void removeCurrency(@NotNull final String nbt);

  /**
   * @param nbt is nbt name.
   * @return returns true if the currency exists.
   */
  public boolean hasCurrency(final @NotNull String nbt);

  /**
   * @param currencyManager is currency manager.
   * This method loads all currencies without configuring.
   */
  public void reloadCurrency(@NotNull final CurrencyManager currencyManager);

  /**
   * @return all registered currencies.
   */
  public Collection<Currencies> getCurrencies();

  /**
   * @param nbt is nbt name.
   * @exception tr.beyazpolis.titanium.economy.exception.CurrencyNBTException
   * If there is no currency belonging to this nbt, it gives an error.
   */
  public void hasCurrencyException(@NotNull final String nbt);

}
