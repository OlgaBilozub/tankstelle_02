package service;



import domain.Tank;
import repository.TankRepository;

import java.util.List;

public class TankServiceImpl implements TankService {
    private TankRepository tankRepository;

    public TankServiceImpl(TankRepository tankRepository) {
        this.tankRepository = tankRepository;

    }

    @Override
    public Tank save(String tankTitle, double tankPrice) {
        Tank tank = new Tank(tankTitle, tankPrice);
        return tankRepository.save(tank);
    }

    @Override
    public List<Tank> getAllActiveTanks() {
        return tankRepository.findAll()
                .stream()
                .filter(Tank::isActive)
                .toList();
    }

    @Override
    public void updateTank(long id, double newPrice) {
        Tank tank = tankRepository.findById(id);
        if (tank != null) {
            tank.setPrice(newPrice);
            tankRepository.updateById(tank);
        } else {
            throw new RuntimeException("Танк з ID: " + id + " не знайдено.");
        }
    }

    @Override
    public void deleteTankById(long id) {
        tankRepository.deleteById(id);
    }

    @Override
    public Tank getTankById(long id) {
        Tank tank = tankRepository.findById(id);
        if (tank == null) {
            throw new RuntimeException("Танк з ID: " + id + " не знайдено.");
        }
        return tank;
    }


}
