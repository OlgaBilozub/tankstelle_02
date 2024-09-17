package controller;



import domain.Tank;
import service.TankService;

import java.util.List;

public class TankController {

    private TankService service;

    public TankController(TankService service) {
        this.service = service;
    }

    public Tank save(String tankTitle, double tankPrice) {
        return service.save(tankTitle,tankPrice);

    }

    public List<Tank> findAll(){
        return service.getAllActiveTanks();

    }

    public Tank findByIdTank(long id){
        return service.getTankById(id);

    }

    public void updateById (long id,double newPrice){
        service.updateTank(id,newPrice);

    }

    public void deleteById (long id){
        service.deleteTankById(id);
    }

}