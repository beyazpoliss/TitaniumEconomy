package tr.beyazpolis.titanium.economy.database.type;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.account.Account;
import tr.beyazpolis.titanium.economy.database.Database;

public class Mongo implements Database {


  @Override
  public Account getOrCreateAccount(@NotNull final UUID uuid) {
    return null;
  }

  @Override
  public void saveProfile(@NotNull final UUID uuid) {

  }

  @Override
  public void openDatabase() {

  }
}
