package leopardcraft.entity;

import leopardcraft.base.LeopardCraft;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MonkeyEntity extends AnimalEntity {

	public static final EntityType<MonkeyEntity> MONKEY = LeopardCraft.register("monkey", EntityType.Builder.create(MonkeyEntity::new, EntityClassification.CREATURE).size(0.6F, 0.7F));
	
	public EntityType<MonkeyEntity> getEntityType() {
		return MONKEY;
	}
	
	private static final Item[] tradingLootTable = {Items.BRICK_SLAB, Items.BAKED_POTATO, LeopardCraft.pancake, Items.DIORITE, Items.JUNGLE_BOAT, LeopardCraft.sapBottleItem, LeopardCraft.venom, Items.PARROT_SPAWN_EGG, LeopardCraft.snakeSkin, LeopardCraft.leopardSpawnEgg, Items.YELLOW_DYE, Items.ENCHANTED_GOLDEN_APPLE};
	
	public MonkeyEntity(EntityType<? extends MonkeyEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new SwimGoal(this));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	    this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
	}
	
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.627D);
	}
	
	private ItemStack chooseRandomTradeItem() {
		int randomItemKey = (int)Math.round(Math.random() * 32);
		Item selectedItem;
		switch(randomItemKey) {
		case 0:
		case 1:
		case 2:
		case 3:
			selectedItem = tradingLootTable[0];
			break;
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			selectedItem = tradingLootTable[1];
			break;
		case 9:
		case 10:
		case 11:
			selectedItem = tradingLootTable[2];
			break;
		case 12:
		case 13:
		case 14:
			selectedItem = tradingLootTable[3];
			break;
		case 15:
		case 16:
		case 17:
			selectedItem = tradingLootTable[4];
			break;
		case 18:
		case 19:
		case 20:
			selectedItem = tradingLootTable[5];
			break;
		case 21:
		case 22:
		case 23:
			selectedItem = tradingLootTable[6];
			break;
		case 24:
		case 25:
			selectedItem = tradingLootTable[8];
			break;
		case 26:
		case 27:
			selectedItem = tradingLootTable[10];
			break;
		case 28:
		case 29:
			selectedItem = tradingLootTable[11];
			break;
		case 30:
			selectedItem = tradingLootTable[7];
			break;
		case 31:
			selectedItem = tradingLootTable[9];
			break;
		default:
			selectedItem = tradingLootTable[3];
		}
		return new ItemStack(selectedItem);
	}
	
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
	      ItemStack itemstack = player.getHeldItem(hand);
	      if (itemstack.getItem() == LeopardCraft.banana) {
	         if(!player.abilities.isCreativeMode) {
	        	 itemstack.shrink(1);
	         }
	         if (itemstack.isEmpty()) {
	            player.setHeldItem(hand, chooseRandomTradeItem());
	         } else if (!player.inventory.addItemStackToInventory(chooseRandomTradeItem())) {
	            player.dropItem(chooseRandomTradeItem(), false);
	         }

	         return true;
	      } else {
	         return super.processInteract(player, hand);
	      }
	}
	
	

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		MonkeyEntity monkeyentity = MONKEY.create(this.world);
		
		monkeyentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(monkeyentity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		
		return monkeyentity;
	}
}
