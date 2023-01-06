package java8.ex01;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;


/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        // TODO créer une méthode int sumAge()
        // TODO Cette méthode retourne le résultat de l'addition des ages des personnes
        
        //default car une methode static ne peut utiliser que d'autres methodes "static"
        public default int sumAge()	{
        	int ageSum = 0;
        	for (int i=0;i<findAll().size();i++) {
        		ageSum += findAll().get(i).getAge();
        	}
        	return ageSum;
        }
        
        public default int sumAge2()	{
        	int ageSum = 0;
            List<Person> persons = findAll();
        	for (Person p: persons) {
        		ageSum += p.getAge();
        	}
        	return ageSum;
        }
        
    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    @Test
    public void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = 0;
        result = daoA.sumAge();
        assert result == 210;
    }

    @Test
    public void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = 0;
        result = daoB.sumAge();
        assert result == 5050;

    }
}
