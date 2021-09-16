package tr.beyazpolis.titanium.economy.api;

import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.TitaniumEconomy;
import tr.beyazpolis.titanium.economy.bank.ServerBank;

public interface EconomyAPI {

  @NotNull
  public ServerBank getServerBank();
}
