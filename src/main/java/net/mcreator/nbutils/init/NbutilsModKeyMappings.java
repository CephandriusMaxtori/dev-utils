
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.nbutils.init;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import net.minecraft.client.Minecraft;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.chat.Component;

import net.mcreator.nbutils.procedures.OpenOnKeyPressedProcedure;

public class NbutilsModKeyMappings {
	public static final KeyBinding OPEN = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.nbutils.open", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_H, "category.nbutils"));

	public static void init() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.player != null && OPEN.wasPressed()) {
				OpenOnKeyPressedProcedure.execute(client.level, client.player.getX(), client.player.getY(), client.player.getZ(), client.player);
			}
		});
	}
}
