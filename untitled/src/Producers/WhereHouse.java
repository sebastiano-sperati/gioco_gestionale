package Producers;

import Ricette.ItemType;

import java.util.HashMap;
import java.util.Map;

public class WhereHouse {
    private static class Slot{
        private int qta;
        private final int capacity;
        private final Slot previous;

        private Slot(int capacity, Slot previous){
            this.qta = 0;
            this.capacity = capacity;
            this.previous = previous;
        }
    }

    private final Map<ItemType, Slot> lastSlot;
    private final int slotCapacity;

    public WhereHouse(int slotCapacity){
        if(slotCapacity <= 0) throw new IllegalArgumentException();

        this.slotCapacity = slotCapacity;
        this.lastSlot = new HashMap<>();
    }

    public void add(ItemType item, int qta){
        checkArgument(item, qta);

        Slot last = this.lastSlot.get(item);

        while (qta > 0){

            if(last == null || last.qta == last.capacity){
                last = new Slot(this.slotCapacity, last);
                this.lastSlot.put(item,last);
            }

            int availebleSpace = last.capacity - last.qta;
            int toAdd = Math.min(qta,availebleSpace);

            last.qta += toAdd;
            qta -= toAdd;
        }
    }

    public int getQta(ItemType item){
        if(item == null) throw new NullPointerException();

        int total = 0;
        Slot current = this.lastSlot.get(item);

        while (current != null){
            total += current.qta;
            current = current.previous;
        }

        return total;
    }

    public boolean has(ItemType itemType, int qta){
        checkArgument(itemType,qta);

        return getQta(itemType) >= qta;
    }

    public boolean remoove(ItemType item, int qta){
        checkArgument(item, qta);

        if(!has(item,qta)) return false;

        Slot last = this.lastSlot.get(item);

        while (qta > 0){
            int toRemoove = Math.min(qta, last.qta);

            last.qta -= toRemoove;
            qta -= toRemoove;

            if(last.qta == 0){
                last = last.previous;
            }
        }

        if(last == null){
            this.lastSlot.remove(item);
        } else {
            this.lastSlot.put(item,last);
        }

        return true;
    }

    private static void checkArgument(ItemType item, int qta){
        if(item == null) throw new NullPointerException();
        if(qta < 0) throw new IllegalArgumentException();
    }

}
