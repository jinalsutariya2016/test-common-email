package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.annotation.Mock;

public class EmailTest {
	
	private static final String[] TEST_EMAILS = {"ab@bc.com", "a.b@bc.org", "abcdefgfdhg@gdfghgfgd.com.bd"};

	@Mock
    MimeMessage mimeMessage;
	
	
	/* Concrete email Class for testing */
	private EmailConcrete email;
	
	@Before
	public void setUpemailTest() throws Exception{
		
		 email = new EmailConcrete();
	}
	
	
	@After
	public void tearDownEmailTest() throws Exception{
		
		
		
	}
//	/****************************************** Test addBcc (String... email) function  100% done*/

	@Test
	public void testAddBcc() throws Exception{
		
		email.addBcc(TEST_EMAILS);
		
		assertEquals(3, email.getBccAddresses().size());
	}
	
	@Test
	public void testAddBcc_shouldThrowException_whenEmailsIsNull() {
		String[] strings = {};
		try {
			this.email.addBcc(strings);
		} catch (Exception e) {
			assertNotNull(e);
			assertEquals(e.getMessage(), "Address List provided was invalid");
		}
	}
		
	
//	/*******************************************Test addCc (String email) function 100% done */ 
	@Test
	public void testAddCc() throws Exception{
		for(final String emailAddress : TEST_EMAILS) {
			email.addCc(emailAddress);
			
		}
		
		assertEquals(3, email.getCcAddresses().size());
	}
	
	//	/*******************************************Test addHeader (String name, String value) function 100% done*/
	
	@Test(expected = IllegalArgumentException.class)
     public void testAddHeaderEmptyName() throws Exception
	     {
	        email.addHeader("", "abc");
     }
	@Test(expected = IllegalArgumentException.class)
    public void testAddHeaderEmptyValue() throws Exception
	     {
	        email.addHeader("Jinal", "");
    }
//	/*******************************************Test addReplyTo (String email, String name) function done 100% */
	
	@Test
	public void testAddReplyTo() throws Exception{
		for(final String address : TEST_EMAILS) {
			email.addReplyTo(address);
		}
		assertEquals(TEST_EMAILS.length, email.getReplyToAddresses().size());
		
		
	}

	
}
 