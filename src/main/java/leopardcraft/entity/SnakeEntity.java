package leopardcraft.entity;

import leopardcraft.base.LeopardCraft;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SnakeEntity extends AnimalEntity {

	public static final EntityType<SnakeEntity> SNAKE = LeopardCraft.register("snake", EntityType.Builder.create(SnakeEntity::new, EntityClassification.MONSTER).size(0.6F, 0.7F));
	
	public EntityType<SnakeEntity> getEntityType() {
		return SNAKE;
	}
	
	public SnakeEntity(EntityType<? extends SnakeEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, BeeEntity.class, 6.0F, 1.0D, 1.2D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	    this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
	}
	
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(22.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.00032D);
	}
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
	      ItemStack itemstack = player.getHeldItem(hand);
	      if (itemstack.getItem() == Items.GLASS_BOTTLE && !player.abilities.isCreativeMode) {
	         itemstack.shrink(1);
	         if (itemstack.isEmpty()) {
	            player.setHeldItem(hand, new ItemStack(LeopardCraft.snakeVenom));
	         } else if (!player.inventory.addItemStackToInventory(new ItemStack(LeopardCraft.snakeVenom))) {
	            player.dropItem(new ItemStack(LeopardCraft.snakeVenom), false);
	         }

	         return true;
	      } else {
	         return super.processInteract(player, hand);
	      }
	   }

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		SnakeEntity snakeentity = SNAKE.create(this.world);
		
		snakeentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(snakeentity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		
		return snakeentity;
	}
}
