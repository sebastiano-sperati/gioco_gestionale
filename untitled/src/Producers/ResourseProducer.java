package Producers;

import Ricette.ItemType;

public class ResourseProducer {
    private final ItemType itemType;
    private final int ticksRequired;
    private int elapsedTicks;

    public ResourseProducer(ItemType itemType, int ticksRequired){
        if(itemType == null) throw new NullPointerException();
        if(ticksRequired <= 0) throw new IllegalArgumentException();

        this.elapsedTicks = 0;
        this.itemType = itemType;
        this.ticksRequired = ticksRequired;
    }

    public boolean tick(){
        this.elapsedTicks++;

        if(this.elapsedTicks >= this.ticksRequired){
            this.elapsedTicks = 0;
            return true;
        }

        return false;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
