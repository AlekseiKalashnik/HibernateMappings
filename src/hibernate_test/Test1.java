package hibernate_test;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //можно переиспользовать
                .configure("hibernate.cfg.xml") //чтение файла
                .addAnnotatedClass(Employee.class) //класс с анотациями для работы с БД
                .addAnnotatedClass(Detail.class) //класс с анотациями для работы с БД
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession(); //нельзя переиспользовать
            session.beginTransaction();

            Employee employee = session.get(Employee.class, 2);//id нашего объекта из таблицы
            session.delete(employee);
            System.out.println(employee.getEmployeeDetail());

            session.getTransaction().commit(); //закрываем транзацкию
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
