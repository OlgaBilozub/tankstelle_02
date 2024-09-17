package client;
import controller.TankController;
import domain.Tank;
import repository.TankRepository;
import repository.TankRepositoryFile;
import service.TankService;
import service.TankServiceImpl;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // Очищаємо файл перед збереженням нових даних
//        FileWriter writer = new FileWriter("tank_data.txt", false); // false - очищає файл
//        writer.write("");
//        writer.close();
        TankRepository repository = new TankRepositoryFile();
        TankService service = new TankServiceImpl(repository);
        TankController controller = new TankController(service);

//        controller.save("Diesel", 3.33);
//        controller.save("AИ-76", 3.50);
//        controller.save("AИ-80", 6.50);
//        controller.save("AИ-92", 3.05);
//        controller.save("AИ-98", 4.10);


        // Отримати всі продукти
        System.out.println("List of all products:");
        List<Tank> products = controller.findAll();
        products.forEach(System.out::println);

//
//        // Сортувати список продуктів
        List<Tank> sortByProduct = new ArrayList<>(products);
       sortByProduct.sort(Comparator.comparingDouble(Tank::getPrice));

//
//        // Вивести відсортований список
        System.out.println("\nList of all products (after sorting by price):");
        sortByProduct.forEach(System.out::println);



//       //Удалить продукт по номеру
        System.out.println("Product ID 4 is not available:");
        controller.deleteById(4);
        products.forEach(System.out::println);

        //Найти продукт по ID
        System.out.println("Product ID 1 is Active:");
        controller.findByIdTank(1);
        products.forEach(System.out::println);


        //Меняем в продукте цену и ID
        System.out.println("New price and new ID:");
        controller.updateById(2,5.77);
        products.forEach(System.out::println);

        








    }
}
