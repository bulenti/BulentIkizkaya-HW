package ikizkaya.bulent.test;

import ikizkaya.bulent.model.*;
import ikizkaya.bulent.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.time.Month;

public class StudentManagementSystemTest {

    public static void main(String[] args) {

            if(isDataExists()) saveTestData();

      }

        private static boolean isDataExists() {
                EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
                return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList().size() == 0;
        }

        private static void saveTestData(){
                Student student1 = new Student("Hale Jale", 1980, "Tuzla", 'f');
                Student student2 = new Student("Huseyin Sana ", 1981, "Kadıkoy", 'm');
                Student student3 = new Student("Semih Bana", 1981, "Kartal", 'm');
                Student student4 = new Student("Hakkı Ona", 1982, "Pendik", 'm');
                Student student5 = new Student("Feride Kime", 1983, "Kartal", 'f');
                Student student6 = new Student("Melda Kıra", 1982, "Pendik", 'f');
                Student student7 = new Student("Mustafa Saka", 1982, "Kartal", 'm');
                Student student8 = new Student("Atilla Haka", 1983, "Tuzla", 'm');

                Course cr1= new Course("IT", 526,30);
                Course cr2= new Course("IT", 538,20);
                Course cr3= new Course("IT", 555,50);

                Instructors vr1=new VisitingResearcher(001,"Yavuz San", "Tuzla", 2128764," ",1550);
                Instructors pi1=new PermanentInstructor(002,"Fatih Kale", "Tuzla", 2325672," ",2550);
                Instructors pi2=new PermanentInstructor(003,"Atilla Kars", "Tuzla", 2426543," ",2550);

                cr1.setInstructors(vr1);
                cr2.setInstructors(pi2);
                cr3.setInstructors(pi1);


                EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

            try {
                entityManager.getTransaction().begin();
                entityManager.persist(cr1);
                entityManager.persist(cr2);
                entityManager.persist(cr3);

                entityManager.persist(student1);
                entityManager.persist(student2);
                entityManager.persist(student3);
                entityManager.persist(student4);
                entityManager.persist(student5);
                entityManager.persist(student6);
                entityManager.persist(student7);
                entityManager.persist(student8);


                entityManager.persist(vr1);
                entityManager.persist(pi2);
                entityManager.persist(pi1);
                entityManager.getTransaction().commit();
                System.out.println("All data persisted!...");

            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            } finally {
                EntityManagerUtils.closeEntityManager(entityManager);
            }

        }
}
