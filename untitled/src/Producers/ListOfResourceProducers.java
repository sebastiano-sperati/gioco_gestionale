package Producers;

import Ricette.ItemType;

import java.util.List;

public class ListOfResourceProducers {
    ResourseProducer coal = new ResourseProducer(ItemType.CARBONE,3);
    ResourseProducer irons = new ResourseProducer(ItemType.FERRO_GREZZO, 3);
    ResourseProducer wood = new ResourseProducer(ItemType.LEGNO, 5);
    ResourseProducer skin = new ResourseProducer(ItemType.PELLE, 5);

    List<ResourseProducer> prducers = List.of(coal, irons, wood, skin);

    public List<ResourseProducer> getPrducers() {
        return prducers;
    }
}
