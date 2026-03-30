/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package net.mcreator.nbutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;
import net.mcreator.nbutils.command.TpdimCommand;
import net.mcreator.nbutils.init.NbutilsModMenus;

public class NbutilsMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("nbutils");
	public static final String MODID = "nbutils";

	@Override
	public void onInitialize() {
		LOGGER.info("nbutils (Fabric) initializing");
		TpdimCommand.register();
		NbutilsModMenus.register();
	}
}
