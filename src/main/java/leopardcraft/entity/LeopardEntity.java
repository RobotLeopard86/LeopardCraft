package leopardcraft.entity;

import java.util.UUID;

import leopardcraft.base.LeopardCraft;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Hand;
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
		
		return leopardentity;
	}
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
	      ItemStack itemstack = player.getHeldItem(hand);
	      Item item = itemstack.getItem();
	      if (itemstack.getItem() instanceof SpawnEggItem) {
	         return super.processInteract(player, hand);
	      } else if (this.world.isRemote) {
	         return this.isOwner(player) || item.getFood().isMeat();
	      } else {
	         if (this.isTamed()) {
	            if (item.isFood() && item.getFood().isMeat() && this.getHealth() < this.getMaxHealth()) {
	               if (!player.abilities.isCreativeMode) {
	                  itemstack.shrink(1);
	               }

	               this.heal((float)item.getFood().getHealing());
	               return true;
	            }

	            if (!(item instanceof DyeItem)) {
	               boolean flag = super.processInteract(player, hand);
	               if (!flag || this.isChild()) {
	                  this.sitGoal.setSitting(!this.isSitting());
	               }

	               return flag;
	            }

	            if (this.isOwner(player) && !this.isBreedingItem(itemstack)) {
	               this.sitGoal.setSitting(!this.isSitting());
	               this.isJumping = false;
	               this.navigator.clearPath();
	               this.setAttackTarget((LivingEntity)null);
	            }
	         } else if (item.getFood().isMeat()) {
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
	
	
	
}