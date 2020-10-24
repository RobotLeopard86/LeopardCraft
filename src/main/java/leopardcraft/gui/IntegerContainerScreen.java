package leopardcraft.gui;

import com.mojang.blaze3d.systems.RenderSystem;

import leopardcraft.block.IntegerContainerBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;

public class IntegerContainerScreen extends Screen {
	
	public static TextFieldWidget value;
	
	public BlockPos boundBlockPos;

	public IntegerContainerScreen() {
		super(new StringTextComponent("Set Value of Integer Container (0 to 1000)"));
	}
	
	@Override
	protected void init() {
		value = new TextFieldWidget(font, width / 2 + 10, height / 2 + 10, 160, 20, "");
		value.changeFocus(true);
		value.setVisible(true);
		value.setEnabled(true);
		value.setText(this.minecraft.world.getWorld().getBlockState(boundBlockPos).get(IntegerContainerBlock.valueProperty).toString());
		this.func_212928_a(value);
	}
	
	@Override
	public boolean keyPressed(int key, int kp2, int kp3) {
		  if (key == 256) {
			 String valueText = value.getText();
			 int num = 0;
			 if(valueText == "") {
			      return !value.keyPressed(key, kp2, kp3) && !value.func_212955_f() ? super.keyPressed(key, kp2, kp3) : true;
			 }
			 try {
				 num = Integer.parseInt(valueText);
			 } catch(NumberFormatException nfe) {
				 this.minecraft.player.sendMessage(new StringTextComponent("Invalid integer. Try again."));
			     return !value.keyPressed(key, kp2, kp3) && !value.func_212955_f() ? super.keyPressed(key, kp2, kp3) : true;
			 }
			 if(num < 0 || num > 1000) {
				 this.minecraft.player.sendMessage(new StringTextComponent("Integer must be in range 0 to 1000. Try again."));
			     return !value.keyPressed(key, kp2, kp3) && !value.func_212955_f() ? super.keyPressed(key, kp2, kp3) : true;
			 }
			 this.minecraft.world.getWorld().setBlockState(boundBlockPos, this.minecraft.world.getWorld().getBlockState(boundBlockPos).with(IntegerContainerBlock.valueProperty, num));
	         this.minecraft.player.closeScreen();
	      }
	      return !value.keyPressed(key, kp2, kp3) && !value.func_212955_f() ? super.keyPressed(key, kp2, kp3) : true;
	}
	
	public void updateScreen() {
		updateScreen();
		value.moveCursorBy(value.getText().length());
	}
	
	protected void mouseClicked(int x, int y, int btn) {
		super.mouseClicked(x,  y, btn);
		value.mouseClicked(x, y, btn);
	}
	
	
	@Override
	public boolean isPauseScreen() {
		return false;
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		blit(width / 2, height / 2, 0, 0, width, height);
		value.render(mouseX, mouseY, partialTicks);
		super.render(mouseX, mouseY, partialTicks);
	}
	
	public static void open(BlockPos pos) {
		IntegerContainerScreen screen = new IntegerContainerScreen();
		screen.boundBlockPos = pos;
		Minecraft.getInstance().displayGuiScreen(screen);
	}

}