package repository;



import domain.Costumer;

import java.util.List;

public interface CostumerRepository {

    Costumer save (Costumer costumer);//сохраняем клиента
    List<Costumer> findAll();// находим список клиента
    Costumer findById(long id);//находим номер клиента
    void updateById (Costumer costumer);//обновляем по номеру
    void deleteById (long id);//удаляем по номеру


}