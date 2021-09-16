package tr.beyazpolis.titanium.economy.database.type;

import java.util.UUID;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.TitaniumEconomy;
import tr.beyazpolis.titanium.economy.account.Account;
import tr.beyazpolis.titanium.economy.database.Database;
import tr.beyazpolis.titanium.economy.profile.PlayerProfile;

public class JsonDatabase implements Database {

  @NotNull
  private final Plugin plugin;

  @NotNull
  private final TitaniumEconomy economy;

  public JsonDatabase(@NotNull final Plugin plugin,@NotNull final TitaniumEconomy economy) {
    this.plugin = plugin;
    this.economy = economy;
  }

  @NotNull
  public Plugin getPlugin() {
    return plugin;
  }

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
