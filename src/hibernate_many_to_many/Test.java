package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Dance");
//            Child child1 = new Child("Kate", 22);
//            Child child2 = new Child("Marry", 17);
//            Child child3 = new Child("Lee", 25);
//
//
//            section1.addChildrenToSection(child1);
//            section1.addChildrenToSection(child2);
//            section1.addChildrenToSection(child3);
//
//            session.beginTransaction();
//
//            session.persist(section1);//сохраняем данные,дети сохранятся
//            // вместе с секцией благодаря работе каскада
//
//            session.getTransaction().commit();
//            System.out.println("Done");
            /*********************************************************/
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Max", 10);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);//сохраняем данные,секции сохранятся
//            // вместе с ребенком благодаря работе каскада
//
//            session.getTransaction().commit();
//            System.out.println("Done");
            /************************************************************/
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 8);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done");
            /*************************************************************/
            session = factory.getCurrentSession();

            session.beginTransaction();

            Child child = session.get(Child.class, 6);

            session.delete(child);

            session.getTransaction().commit();
            System.out.println("Done");
            /***********************************************************/
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 2);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
