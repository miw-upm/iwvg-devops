package es.upm.miw.iwvg.forge.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.upm.miw.iwvg.forge.junit.exception.AllForgeJunitExceptionTests;

@RunWith(Suite.class)
@SuiteClasses({
    PointTest.class,
    AllForgeJunitExceptionTests.class
})
public class AllForgeJunitTests {

}
