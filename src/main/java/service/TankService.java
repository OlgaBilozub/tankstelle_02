package service;



import domain.Tank;

import java.util.List;

public interface TankService {

    Tank save(String tankTitle, double tankPrice);
    List<Tank> getAllActiveTanks();
    void updateTank(long productId, double newPrice);
    void deleteTankById(long id);
    Tank getTankById(long id);


}
