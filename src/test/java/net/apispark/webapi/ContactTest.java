package net.apispark.webapi;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import net.apispark.webapi.db.ContactPersistence;
import net.apispark.webapi.representation.Contact;

import static org.hamcrest.CoreMatchers.*;

public class ContactTest {

	@Test
	//adding a new contact should return the created contact with an assigned id
	public void test1() {
		Contact john = ContactPersistence.INSTANCE.addContact
				(new Contact("41ee2e80-75bf-11e5-b476-cbcba715b961", "John", "Smith", "svg-1","Homme"));
		Assert.assertThat(john, is(instanceOf(Contact.class)));
	}
	
	
	@Test
	//adding a new contact then requesting it by id should return the contact
	public void test2() {
		Contact jeff = ContactPersistence.INSTANCE.addContact
				(new Contact("41ee2e80-75bf-11e5-b476-cbcba715b962", "Jeff", "Smith", "svg-2","Homme"));
		Assert.assertEquals(jeff,ContactPersistence.INSTANCE.getContact("41ee2e80-75bf-11e5-b476-cbcba715b962") );
	}
	
}
