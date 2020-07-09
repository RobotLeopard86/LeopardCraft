package leopardcraft.entity;

import java.util.UUID;

import leopardcraft.base.LeopardCraft;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LeopardEntity extends TameableEntity {
	public static final EntityType<LeopardEntity> LEOPARD = LeopardCraft.register("leopard", EntityType.Builder.create(LeopardEntity::new, EntityClassification.CREATURE).size(1.4F, 1.4F));
	
	public static EntityType<LeopardEntity> getEntityType() {
		return LEOPARD;
		
	}
	
	public LeopardEntity(EntityType<? extends LeopardEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public LeopardEntity createChild(AgeableEntity ageable) {
		LeopardEntity leopardentity = LEOPARD.create(this.world);
		UUID uuid = this.getOwnerId();
		
		if(uuid != null) {
			leopardentity.setOwnerId(uuid);
			leopardentity.setTamed(true);
		}
		
		leopardentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(leopardentity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		
		return leopardentity;
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == LeopardCraft.syrupBottleItem || stack.getItem() == LeopardCraft.pancake || stack.getItem() == LeopardCraft.pancakeWithSyrup;
	}
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
	      ItemStack itemstack = player.getHeldItem(hand);
	      Item item = itemstack.getItem();
	      if (itemstack.getItem() instanceof SpawnEggItem) {
	         return super.processInteract(player, hand);
	      } else if (this.world.isRemote) {
	         return this.isOwner(player) || item.getItem() == LeopardCraft.syrupBottleItem || item.getItem() == LeopardCraft.pancake || item.getItem() == LeopardCraft.pancakeWithSyrup;
	      } else {
	         if (this.isTamed()) {
	            if (item.isFood() && item.getItem() == LeopardCraft.syrupBottleItem || item.getItem() == LeopardCraft.pancake || item.getItem() == LeopardCraft.pancakeWithSyrup && this.getHealth() < this.getMaxHealth()) {
	               if (!player.abilities.isCreativeMode) {
	                  itemstack.shrink(1);
	               }

	               this.heal((float)item.getFood().getHealing());
	               return true;
	            }

	         } else if (item.getItem() == LeopardCraft.syrupBottleItem || item.getItem() == LeopardCraft.pancake || item.getItem() == LeopardCraft.pancakeWithSyrup) {
	            if (!player.abilities.isCreativeMode) {
	               itemstack.shrink(1);
	            }

	            if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
	               this.setTamedBy(player);
	               this.navigator.clearPath();
	               this.setAttackTarget((LivingEntity)null);
	               this.sitGoal.setSitting(true);
	               this.world.setEntityState(this, (byte)7);
	            } else {
	               this.world.setEntityState(this, (byte)6);
	            }

	            return true;
	         }

	         return super.processInteract(player, hand);
	      }
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.fromItems(LeopardCraft.syrupBottleItem, LeopardCraft.pancake, LeopardCraft.pancakeWithSyrup), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(28.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.43D);
	}
	
		
}