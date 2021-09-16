package tr.beyazpolis.titanium.economy.api;

import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.TitaniumEconomy;
import tr.beyazpolis.titanium.economy.bank.ServerBank;

public class TitaniumAPI implements EconomyAPI {

  @NotNull
  private final TitaniumEconomy titaniumEconomy;

  public TitaniumAPI(@NotNull final TitaniumEconomy titaniumEconomy) {
    this.titaniumEconomy = titaniumEconomy;
  }

  @Override
  public @NotNull ServerBank getServerBank() {
    return titaniumEconomy.getServerBank();
  }

  @NotNull
  private TitaniumEconomy getTitaniumEconomy() {
    return titaniumEconomy;
  }
}
