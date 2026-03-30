
package net.mcreator.nbutils.network;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

import net.mcreator.nbutils.procedures.OpenOnKeyPressedProcedure;

public class OpenMessage {
	public static void pressAction(Player entity, int type, int pressedms) {
		if (entity == null)
			return;
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		if (type == 0) {
			OpenOnKeyPressedProcedure.execute(world, x, y, z, entity);
		}
	}
}
