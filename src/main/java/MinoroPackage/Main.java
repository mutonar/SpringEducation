package MinoroPackage;

import MinoroPackage.Entities.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
        // создаем пустой спринговый контекст, который будет искать свои бины по аннотациям в указанном пакете
        // Не находит он классы
        ApplicationContext context =
                new AnnotationConfigApplicationContext("MinorPackage.Entities");
    /*
        Cat cat = context.getBean(Cat.class);
        Dog dog = (Dog) context.getBean("Dog");
        Dog dog2 = context.getBean("Dog", Dog.class);

        System.out.println(cat.getName());
        System.out.println(dog.getName());
*/
        // новые примеры из видео уроков
        // обязательно файл applicationcontext.xml должен лежать в папке помеченной как Resource Root
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("applicationcontext.xml");
        TestBean bean1 = context1.getBean("testBean", TestBean.class);
        Animal cat = context1.getBean("animalBeanCat", Cat.class);  // На прямую вызвать бин кота
        AnalizeAnimal aAnimal = new AnalizeAnimal(cat);                   // внедрение зависимости вручную
        AnalizeAnimal aAnimal1 =  context1.getBean("AnalizeAnimalBean", AnalizeAnimal.class);           // внедрение зависимости из контекта Бинов
        AnalizeAnimal aAnimalSeter =  context1.getBean("AnalizeAnimalSeterBean", AnalizeAnimal.class);  // внедрение зависимости из контекта Бинов
        //aAnimal1.getAnamalName();
        aAnimalSeter.getAnimalName();
        System.out.println("Name From Bean: " + aAnimalSeter.getAnimalName() +
                " Weight: " + Integer.toString(aAnimalSeter.getWeight()));   // просто вывод

        // чтение и выдоид данных из файла
        AnalizeAnimal aAnimalSeterFromFile =  context1.getBean("AnalizeAnimalSeterBeanFromFile", AnalizeAnimal.class); // внедрение зависимости из контекта Бинов
        System.out.println("Name From Bean: " + aAnimalSeterFromFile.getAnimalName() +
                " Weight: " + Integer.toString(aAnimalSeterFromFile.getWeight()));   // просто вывод

        aAnimalSeterFromFile.getListnameAnimal(); // Вывод листа который занесли с помощью xml конфига

        //нескольно экземпляров бинов
        Animal dog1 = context1.getBean("animalBeanDog", Dog.class);
        Animal dog2 = context1.getBean("animalBeanDog", Dog.class);
        dog1.setName("Betchovin");
        System.out.println(dog1.getName());
        System.out.println(dog2.getName());

        context1.close(); // закрываем работу с ним

    }


}
