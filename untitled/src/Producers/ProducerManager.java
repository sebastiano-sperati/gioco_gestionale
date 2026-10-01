package Producers;

public class ProducerManager {
    ListOfResourceProducers producers = new ListOfResourceProducers();
    public WhereHouse whereHouse = new WhereHouse(10);
    public void produce(){
        for (ResourseProducer resourseProducer : producers.getPrducers()) {
            if(resourseProducer.tick()) whereHouse.add(resourseProducer.getItemType(), 1);
        }
    }
}
