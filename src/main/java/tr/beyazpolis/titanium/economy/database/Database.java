package tr.beyazpolis.titanium.economy.database;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.account.Account;
import tr.beyazpolis.titanium.economy.bank.ServerBank;
import tr.beyazpolis.titanium.economy.profile.PlayerProfile;

public interface Database {

  public Account getOrCreateAccount(@NotNull UUID uuid);

  public void saveProfile(@NotNull UUID uuid);

  public void openDatabase();

}
