import Ricette.ItemType;
import Ricette.Recipy;
import Ricette.RecipyBook;

public class Request {
    private final ItemType item;

    public Request(ItemType item){
        this.item = item;
    }

    public Recipy findRecipy(RecipyBook recipyBook){
        return recipyBook.getRecepy(this.item);
    }
}
