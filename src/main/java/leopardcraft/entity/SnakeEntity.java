package leopardcraft.entity;

import javax.annotation.Nullable;

import leopardcraft.base.LeopardCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class SnakeEntity extends MonsterEntity {

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
	    this.goalSelector.addGoal(1, new HurtByTargetGoal(this));
	    this.goalSelector.addGoal(1, new SnakeEntity.AttackGoal(this));
	}
	
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(22.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.00032D);
	}
	
	public boolean attackEntityAsMob(Entity entityIn) {
		if(super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof LivingEntity) {
	            int i = 0;
	            if (this.world.getDifficulty() == Difficulty.NORMAL) {
	               i = 7;
	            } else if (this.world.getDifficulty() == Difficulty.HARD) {
	               i = 15;
	            }

	            if (i > 0) {
	               ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.BLINDNESS, i * 20, 0));
	               ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.WITHER, i * 10, 0));
	               ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.NAUSEA, i * 20, 0));
	            }
	         }
			
			return true;
		} else {
			return false;
		}
	}
	
	static class AttackGoal extends MeleeAttackGoal {
	      public AttackGoal(SnakeEntity snake) {
	         super(snake, 1.0D, true);
	      }

	      /**
	       * Returns whether the EntityAIBase should begin execution.
	       */
	      public boolean shouldExecute() {
	         return super.shouldExecute() && !this.attacker.isBeingRidden();
	      }

	      /**
	       * Returns whether an in-progress EntityAIBase should continue executing
	       */
	      public boolean shouldContinueExecuting() {
	         float f = this.attacker.getBrightness();
	         if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
	            this.attacker.setAttackTarget((LivingEntity)null);
	            return false;
	         } else {
	            return super.shouldContinueExecuting();
	         }
	      }

	      protected double getAttackReachSqr(LivingEntity attackTarget) {
	         return (double)(4.0F + attackTarget.getWidth());
	      }
	   }

	
	   @Nullable
	   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
	      return spawnDataIn;
	   }

	   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
	      return 0.45F;
	   }
}
