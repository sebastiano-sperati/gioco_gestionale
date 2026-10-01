package Ricette;

import java.util.HashMap;
import java.util.Map;

public class RecipyBook {

    private final Map<ItemType, Recipy> recipyMap;


    public RecipyBook() {
        this.recipyMap = new HashMap<>();

        this.recipyMap.put(ItemType.SPADA, new Recipy(Map.of(ItemType.ELSA, 1, ItemType.LAMA, 1, ItemType.MANICO, 1), 1, ItemType.SPADA));
        this.recipyMap.put(ItemType.LAMA, new Recipy(Map.of(ItemType.LINGOTTI_FERRO, 3), 1, ItemType.LAMA));
        this.recipyMap.put(ItemType.ELSA, new Recipy(Map.of(ItemType.LINGOTTI_FERRO, 2), 1, ItemType.ELSA));
        this.recipyMap.put(ItemType.MANICO, new Recipy(Map.of(ItemType.LEGNO, 1, ItemType.PELLE, 1), 1, ItemType.MANICO));
        this.recipyMap.put(ItemType.LINGOTTI_FERRO, new Recipy(Map.of(ItemType.FERRO_GREZZO, 1, ItemType.CARBONE, 2), 1, ItemType.LINGOTTI_FERRO));
    }

    public Recipy getRecepy(ItemType item){
        return this.recipyMap.get(item);
    }
}
