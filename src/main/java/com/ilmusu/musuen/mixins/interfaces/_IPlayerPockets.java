package com.ilmusu.musuen.mixins.interfaces;

import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

public interface _IPlayerPockets
{
    Inventory getPockets();

    void setPocketLevel(World world, int level);

    int getPocketLevel();

    void setPocketsOpen(boolean open);

    boolean arePocketsOpen();

    void clone(_IPlayerPockets other);

    void updatePocketSlot(PocketSlot slot);

    class PocketSlot extends Slot
    {
        public boolean enabled = false;
        public boolean isRecipeBookOpen = false;
        public boolean arePocketsOpen = false;

        public PocketSlot(Inventory inventory, int index, int x, int y)
        {
            super(inventory, index, x, y);
        }

        @Override
        public boolean isEnabled()
        {
            return !this.isRecipeBookOpen && this.arePocketsOpen && this.enabled;
        }
    }
}