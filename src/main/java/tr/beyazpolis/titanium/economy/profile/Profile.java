package tr.beyazpolis.titanium.economy.profile;

import java.util.UUID;
import tr.beyazpolis.titanium.economy.account.Account;

public interface Profile {

  /**
   * @return player uuid.
   */
  public UUID getUUID();

  /**
   * @return Player Bank Account.
   */
  public Account getAccount();
}
