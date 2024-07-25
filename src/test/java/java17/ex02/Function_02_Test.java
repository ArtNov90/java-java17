package java17.ex02;

import java.util.function.BiFunction;

import org.junit.Test;

import java17.data.Account;
import java17.data.Person;

/**
 * Exercice 02 - java.util.function.BiFunction
 */
public class Function_02_Test {
	@FunctionalInterface
	public interface AccountBuilder {
		Account build(Person person, Integer solde);
	}

	// tag::buildAccount[]
	// TODO Compléter la fonction buildAccount
	// TODO la fonction possède 2 paramètres en entrée : une personne et un solde
	AccountBuilder buildAccount = (person, solde) -> new Account(person, solde);
	// end::buildAccount[]

	@Test
	public void test_build_account() throws Exception {

		// TODO invoquer la fonction buildAccount pour que le test soit passant
		Person person = new Person("John", "France", 80, "pass");
		Account account = buildAccount.build(person, 500);

		assert account.getBalance().equals(500);
		assert account.getOwner().getFirstname().equals("John");
		assert account.getOwner().getLastname().equals("France");
		assert account.getOwner().getAge().equals(80);
		assert account.getOwner().getPassword().equals("pass");
	}

}
