package net.mcreator.nbutils.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.nbutils.world.inventory.DimsMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DimsScreen extends AbstractContainerScreen<DimsMenu> {
	private final static HashMap<String, Object> guistate = DimsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_hub;
	Button button_repo;
	Button button_redstone;

	public DimsScreen(DimsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("nbutils:textures/screens/dims.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.nbutils.dims.label_wm"), 78, 7, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_hub = Button.builder(Component.translatable("gui.nbutils.dims.button_hub"), e -> {
		}).bounds(this.leftPos + 6, this.topPos + 25, 40, 20).build();
		guistate.put("button:button_hub", button_hub);
		this.addRenderableWidget(button_hub);
		button_repo = Button.builder(Component.translatable("gui.nbutils.dims.button_repo"), e -> {
		}).bounds(this.leftPos + 123, this.topPos + 25, 46, 20).build();
		guistate.put("button:button_repo", button_repo);
		this.addRenderableWidget(button_repo);
		button_redstone = Button.builder(Component.translatable("gui.nbutils.dims.button_redstone"), e -> {
		}).bounds(this.leftPos + 51, this.topPos + 25, 67, 20).build();
		guistate.put("button:button_redstone", button_redstone);
		this.addRenderableWidget(button_redstone);
	}
}
