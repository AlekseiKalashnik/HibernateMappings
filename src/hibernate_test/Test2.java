package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //можно переиспользовать
                .configure("hibernate.cfg.xml") //чтение файла
                .addAnnotatedClass(Employee.class) //класс с анотациями для работы с БД
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); //нельзя переиспользовать
            Employee employee = new Employee("Oleg", "T",
                    "HR", 500);
            session.beginTransaction(); //открываем транзакцию
            session.save(employee); //сохраняем изменения в базе
//            session.getTransaction().commit(); //закрываем транзацкию

            int employeeID = employee.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            //получаем работника, которого только что добавили
            Employee employee1 = session.get(Employee.class, employeeID);
            session.getTransaction().commit();
            System.out.println(employee1);

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
