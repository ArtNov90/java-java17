package java17.ex01;

import java.util.function.Function;

import org.junit.Test;

import java17.data.Account;
import java17.data.Person;


/**
 * Exercice 01 - java.util.function.Function
 */
public class Function_01_Test {
	
	@FunctionalInterface
	public interface IntToPerson {
	    Person apply(Integer integer);
	}
	
	@FunctionalInterface
	public interface PersonToAccount {
	    Account apply(Person person);
	}
	  /******** PART 1 - Integer -> Person *******/

    // Définir l'implémentation de l'interface fonctionnelle IntToPerson
    private IntToPerson intToPerson = (integer) -> {
        return new Person(
            "first_" + integer,
            "last_" + integer,
            integer,
            "pass_" + integer
        );
    };
    

    // end::intToPerson[]

    @Test
    public void test_intToPerson() throws Exception {

        // TODO invoquer la fonction intToPerson avec en paramètre l'entier 10.
    	Person result = intToPerson.apply(10);

        assert result.getFirstname().equals("first_10");
        assert result.getLastname().equals("last_10");
        assert result.getAge().equals(10);
        assert result.getPassword().equals("pass_10");
    }

    /******** PART 2 - Person -> Account *******/

    // tag::personToAccount[]
    // TODO Compléter la définition de cette fonction
    // TODO la propriété owner est valorisé avec la personne en paramètre
    // TODO la propriété balance est valorisé à 1000
    private PersonToAccount personToAccount = (person) -> {
        return new Account(person, 1000);
    };
    // end::personToAccount[]

    @Test
    public void test_personToAccount() throws Exception {

        Person person = new Person("Jules", "France", 10, "pass");

        // TODO invoquer la fonction personToAccount
        Account result = personToAccount.apply(person);
        assert result.getOwner().equals(person);
        assert result.getBalance().equals(1000);
    }
}
