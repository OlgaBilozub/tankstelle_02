package repository;



import domain.Tank;

import java.util.List;

public interface TankRepository {

    Tank save (Tank tank);//сохраняем продукт
    List<Tank> findAll();// находим список продуктов
    Tank findById(long id);//находим номер продукта
    void updateById (Tank tank);//обновляем по номеру продукт
    void deleteById (long id);//удаляем по номеру продукт

}

