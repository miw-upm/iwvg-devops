package es.upm.miw.iwvg.forge.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ServiceIT.class,
	NaturalDaoIT.class
})
public class AllForgeTestIntegrationTests {

}
