package net.mcreator.nbutils;

import net.fabricmc.api.ClientModInitializer;
import net.mcreator.nbutils.init.NbutilsModKeyMappings;
import net.mcreator.nbutils.init.NbutilsModScreens;

public class NbutilsModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		NbutilsModKeyMappings.init();
		NbutilsModScreens.register();
	}
}
