package tr.beyazpolis.titanium.economy.profile;

import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.account.Account;

public class PlayerProfile implements Profile{

  @NotNull
  private final Account bank;

  @NotNull
  private final UUID uuid;

  public PlayerProfile(@NotNull final Account bank, @NotNull final UUID uuid) {
    this.bank = bank;
    this.uuid = uuid;
  }

  @Override
  public UUID getUUID() {
    return uuid;
  }

  @NotNull
  public Account getAccount() {
    return bank;
  }
}
