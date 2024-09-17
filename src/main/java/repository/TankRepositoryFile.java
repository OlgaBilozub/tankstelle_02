package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Tank;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class TankRepositoryFile implements TankRepository {
    private File database;
    private ObjectMapper mapper;
    private long currentId;

    public TankRepositoryFile() {
        database = new File("tank_db.txt");
        mapper = new ObjectMapper();
        currentId = findMaxId();
    }

    private long findMaxId() {
        List<Tank> tanks = findAll();
        return tanks
                .stream()
                .mapToLong(Tank::getId)
                .max()
                .orElse(0);
    }
//    private void getMaxId() {
//        List<Tank> tanks = findAll();
//        if (!tanks.isEmpty()) {
//            Tank lastTanks = tanks.get(tanks.size() - 1);
//            currentId = lastTanks.getId();

    @Override
    public Tank save(Tank tank) {
        List<Tank> tanks = findAll();
        tank.setId(++currentId);
        tank.setActive(true);
        tanks.add(tank);
        System.out.println("Saving tank: " + tank);

        try {
            mapper.writeValue(database, tanks);
            return tank;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save tank", e);
        }

    }

    @Override
    public List<Tank> findAll() {
        try {
            if (!database.exists() || database.length() == 0) {
                return new ArrayList<>();
            }
            Tank[] tanks = mapper.readValue(database, Tank[].class);
            List<Tank> tankList = new ArrayList<>();
            Collections.addAll(tankList, tanks);
            return tankList;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read tanks from file", e);
        }
    }


    @Override
    public Tank findById(long id) {
        return findAll()
                .stream()
                .filter(tank -> tank.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateById(Tank updatedTank) {
        List<Tank> tanks = findAll();
        for (int i = 0; i < tanks.size(); i++) {
            if (tanks.get(i).getId() == updatedTank.getId()) {
                tanks.set(i, updatedTank);
                break;
            }
        }

        try {
            mapper.writeValue(database, tanks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(long id) {
        List<Tank> tanks = findAll();
        tanks.removeIf(tank -> tank.getId() == id);

        try {
            mapper.writeValue(database, tanks);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

