package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //можно переиспользовать
                .configure("hibernate.cfg.xml") //чтение файла
                .addAnnotatedClass(Employee.class) //класс с анотациями для работы с БД
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); //нельзя переиспользовать
            session.beginTransaction(); //открываем транзакцию
            //в параметрах пишем имя класса, имя поля именно наших классов
            List<Employee> employees = session.createQuery("FROM Employee " +
                    "WHERE name = 'Aleksandr' AND salary>800").getResultList();
            for(Employee e : employees) {
                System.out.println(e);
            }
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
