package Ricette;

import java.util.Map;

public class Recipy {
    private ItemType result;
    private int resultQta;
    private Map<ItemType, Integer> ingredients;

    public Recipy(Map<ItemType, Integer> ingredients, int qta, ItemType product){
        if(ingredients == null) throw new NullPointerException();

        this.result = product;
        this.resultQta = qta;
        this.ingredients = Map.copyOf(ingredients);
    }

    public Map<ItemType, Integer> getIngredients(){
        return this.ingredients;
    }

    public int getResultQta() {
        return resultQta;
    }

    public ItemType getResult(){
        return this.result;
    }
}
