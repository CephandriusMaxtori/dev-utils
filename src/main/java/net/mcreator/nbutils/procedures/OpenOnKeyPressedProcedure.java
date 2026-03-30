package net.mcreator.nbutils.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.SimpleNamedScreenHandlerFactory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.network.ServerPlayer;
import net.minecraft.text.Text;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.nbutils.world.inventory.DimsMenu;

import io.netty.buffer.Unpooled;

public class OpenOnKeyPressedProcedure {
	public static void execute(Level world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof ServerPlayer serverPlayer))
			return;

		BlockPos pos = new BlockPos(x, y, z);
		serverPlayer.openHandledScreen(new SimpleNamedScreenHandlerFactory((windowId, inventory, player) -> new DimsMenu(windowId, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos)), Text.literal("Dims")));
	}
}
