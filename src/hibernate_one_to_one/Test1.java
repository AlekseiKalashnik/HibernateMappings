package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //можно переиспользовать
                .configure("hibernate.cfg.xml") //чтение файла
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)//класс с анотациями для работы с БД
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); //нельзя переиспользовать
            Employee employee = new Employee("Alex", "K", "IT", 2000);
            Detail detail = new Detail("Mos", "1234554321", "a@com");
            employee.setEmployeeDetail(detail);
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
