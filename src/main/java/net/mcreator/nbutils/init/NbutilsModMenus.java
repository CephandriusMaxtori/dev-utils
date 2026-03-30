
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.nbutils.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.nbutils.world.inventory.DimsMenu;
import net.mcreator.nbutils.NbutilsMod;

public class NbutilsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, NbutilsMod.MODID);
	public static final RegistryObject<MenuType<DimsMenu>> DIMS = REGISTRY.register("dims", () -> IForgeMenuType.create(DimsMenu::new));
}
