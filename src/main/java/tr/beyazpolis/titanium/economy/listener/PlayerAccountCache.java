package tr.beyazpolis.titanium.economy.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;
import tr.beyazpolis.titanium.economy.TitaniumEconomy;
import tr.beyazpolis.titanium.economy.currencies.type.Currency;

public class PlayerAccountCache implements Listener {

  @NotNull
  private final TitaniumEconomy titaniumEconomy;

  public PlayerAccountCache(@NotNull final TitaniumEconomy titaniumEconomy) {
    this.titaniumEconomy = titaniumEconomy;
  }

  @EventHandler
  public void onJoinEvent(@NotNull final PlayerJoinEvent event){
    final Player player = event.getPlayer();
    this.titaniumEconomy.getServerBank().getCurrencies().forEach(currencies -> {
      Currency currency = (Currency) currencies;

    });
  }

  @NotNull
  public TitaniumEconomy getTitaniumEconomy() {
    return titaniumEconomy;
  }
}
