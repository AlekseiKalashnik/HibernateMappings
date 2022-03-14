package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //можно переиспользовать
                .configure("hibernate.cfg.xml") //чтение файла
                .addAnnotatedClass(Employee.class) //класс с анотациями для работы с БД
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); //нельзя переиспользовать
            session.beginTransaction(); //открываем транзакцию
//            Employee firstEmployee = session.get(Employee.class, 1);
//            session.delete(firstEmployee);

            session.createQuery("DELETE Employee " +
                    "WHERE name='Aleksandr'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");
        }

        finally {
            factory.close();
        }
    }
}
