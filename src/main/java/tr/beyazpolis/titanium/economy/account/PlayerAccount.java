package tr.beyazpolis.titanium.economy.account;

import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tr.beyazpolis.titanium.economy.TitaniumEconomy;
import tr.beyazpolis.titanium.economy.exception.CurrencyNBTException;
import tr.beyazpolis.titanium.economy.money.Money;

public final class PlayerAccount implements Account {

  @Nullable
  private HashMap<String, Money> moneyHashMap;

  public PlayerAccount(){
    this.moneyHashMap = new HashMap<>();
  }

  @Override
  @NotNull
  public Money getMoneyByName(final @NotNull String nbtName) {
    if (this.getMoneysMap().get(nbtName) == null){
      throw new NullPointerException("TitaniumEconomy the desired currency was not found!");
    }
    return this.getMoneysMap().get(nbtName);
  }

  @Override
  public void addMoney(final @NotNull String nbtName,@NotNull final Money money) {
    try {
      TitaniumEconomy.getEconomyAPI().getServerBank().hasCurrencyException(nbtName);
      this.getMoneysMap().put(nbtName,money);
    }catch (CurrencyNBTException e){
      e.printStackTrace();
    }
  }

  @NotNull
  private HashMap<String, Money> getMoneysMap(){
    if (this.moneyHashMap == null) {
      this.moneyHashMap = new HashMap<>();
    }
    return moneyHashMap;
  }

  public HashMap<String, Money> getMoneyHashMap() {
    throw new UnsupportedOperationException("It's not good that you have access to this HashMap!");
  }
}
