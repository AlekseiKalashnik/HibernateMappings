package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration() //можно переиспользовать
                .configure("hibernate.cfg.xml") //чтение файла
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)//класс с анотациями для работы с БД
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession(); //нельзя переиспользовать

            session.beginTransaction();

            Department department = session.get(Department.class, 3);

            session.delete(department);

            session.getTransaction().commit();
            System.out.println("Done!");

//            Department department = new Department("HR", 500, 1500);
//            Employee employee1 = new Employee("Oui", "O", 111);
//            Employee employee2 = new Employee("Steve", "P", 4000);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//
//            session.beginTransaction();
//            session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
