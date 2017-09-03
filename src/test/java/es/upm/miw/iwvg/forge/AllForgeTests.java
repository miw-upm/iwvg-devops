package es.upm.miw.iwvg.forge;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.upm.miw.iwvg.forge.junit.AllForgeJunitTests;
import es.upm.miw.iwvg.forge.log.AllForgeLogTests;
import es.upm.miw.iwvg.forge.test.AllForgeTestIntegrationTests;
import es.upm.miw.iwvg.forge.test.AllForgeTestTests;

@RunWith(Suite.class)
@SuiteClasses({
    AllForgeJunitTests.class,
    AllForgeLogTests.class,
    AllForgeTestTests.class,
    AllForgeTestIntegrationTests.class})
public class AllForgeTests {

}
