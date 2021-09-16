package tr.beyazpolis.titanium.economy.money;

import org.jetbrains.annotations.NotNull;

public class PlayerMoney implements Money {

  private double money;
  private final String nbtName;

  public PlayerMoney(final double money, @NotNull final String nbtName) {
    this.money = money;
    this.nbtName = nbtName;
  }

  @Override
  public double getMoney() {
    return money;
  }

  @Override
  public void setMoney(double money) {
    this.money = money;
  }

  @Override
  public String getCurrencyNbtName() {
    return nbtName;
  }
}
