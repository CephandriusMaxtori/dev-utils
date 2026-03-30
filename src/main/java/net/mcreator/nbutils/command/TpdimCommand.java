
package net.mcreator.nbutils.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.nbutils.procedures.OpenOnKeyPressedProcedure;

public class TpdimCommand {
	public static void register() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(CommandManager.literal("tpdims").requires(src -> src.hasPermissionLevel(2)).executes(context -> {
				ServerCommandSource source = context.getSource();
				ServerLevel world = source.getWorld();
				double x = source.getPosition().x;
				double y = source.getPosition().y;
				double z = source.getPosition().z;
				Entity entity = source.getEntity();
				OpenOnKeyPressedProcedure.execute(world, x, y, z, entity);
				return 1;
			}));
		});
	}
}
