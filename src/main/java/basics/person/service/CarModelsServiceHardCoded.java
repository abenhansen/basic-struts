package basics.person.service;

public class CarModelsServiceHardCoded implements CarModelsService {

   @Override
    public String[] getCarModels() {
        String [] carModelsAvailable = {"Ford","Chrysler","Toyota","Nissan", "Audi", "Tesla", "Mercedes", "Volkswagen"};
        return carModelsAvailable ;
    }

}