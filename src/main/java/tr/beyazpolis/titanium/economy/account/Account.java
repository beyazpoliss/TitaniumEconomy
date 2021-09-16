package tr.beyazpolis.titanium.economy.account;

import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.money.Money;

public interface Account {

  public Money getMoneyByName(@NotNull final String nbtName);

  public void addMoney(@NotNull final String nbtName,@NotNull final Money money);

}
