package com.harsha;

import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Properties prop = new Properties();
       prop.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
       prop.put(Context.PROVIDER_URL, "ldap://localhost:10389");
       prop.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
       prop.put(Context.SECURITY_CREDENTIALS, "secret");
     try {
		DirContext dircont = new InitialDirContext(prop);
		Map m = dircont.getEnvironment();
		System.out.println(m);
	} catch (NamingException e) {
		e.printStackTrace();
	}
       
    }
}
