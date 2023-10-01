package com.ins09.dynrename;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import com.ins09.dynrename.Commands.Rename;

/*
 * Dynamic-Rename java plugin
 */
public class DynamicRename extends JavaPlugin {
  private static final Logger LOGGER = Logger.getLogger("dynamicrename");
  public static String nmPlugin = "[Dyn-Rename]";

  public void onEnable() {
    LOGGER.info("Dynamic-Rename enabled");

    // Register commands
    this.getCommand("rename").setExecutor(new Rename());
  }

  public void onDisable() {
    LOGGER.info("Dynamic-Rename disabled");
  }

}
