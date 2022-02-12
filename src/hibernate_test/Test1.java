package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //можно переиспользовать
                .configure("hibernate.cfg.xml") //чтение файла
                .addAnnotatedClass(Employee.class) //класс с анотациями для работы с БД
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); //нельзя переиспользовать
            Employee employee = new Employee("Aleksandr", "SO",
                    "HR", 800);
            session.beginTransaction(); //открываем транзакцию
            session.save(employee); //сохраняем изменения в базе
            session.getTransaction().commit(); //закрываем транзацкию

            System.out.println(employee);
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
