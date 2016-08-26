package by.ibrel.kitan.test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author ibrel
 * @version ${version} (24.08.2016)
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:kitan-dao-beans-for-test.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class Test {
    class A{

        A(){
            System.out.println("Конструктор без аргументов класса A");
        }

        A(String args){
            System.out.println("Конструктор с одним аргументом класса A");
        }
    }

    class B extends A{

        B(){
            this(""); // вызов конструктора с одним аргументом класса B
            System.out.println("Конструктор без аргументов класса B");
        }

        B(String args){
            super(""); // вызов конструктора с одним аргументом класса A
            System.out.println("Конструктор с одним аргументом класса B");
        }
    }

    // Тест-класс и вывод

    public static void main(String args[]) {

    }
}
