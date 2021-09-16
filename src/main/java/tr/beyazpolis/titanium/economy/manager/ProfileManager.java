package tr.beyazpolis.titanium.economy.manager;

import java.util.HashMap;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.database.Database;
import tr.beyazpolis.titanium.economy.profile.PlayerProfile;

public class ProfileManager {

  @NotNull
  private final Database database;

  private final HashMap<UUID, PlayerProfile> playerProfileHashMap;

  public ProfileManager(@NotNull final Database database) {
    this.database = database;
    this.playerProfileHashMap = new HashMap<>();
  }

  public HashMap<UUID, PlayerProfile> getPlayerProfileHashMap() {
    return playerProfileHashMap;
  }

  @NotNull
  public Database getDatabase() {
    return database;
  }
}
