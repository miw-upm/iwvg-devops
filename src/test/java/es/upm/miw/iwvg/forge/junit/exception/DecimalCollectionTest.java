package es.upm.miw.iwvg.forge.junit.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.iwvg.forge.junit.exception.DecimalCollection;

public class DecimalCollectionTest {
	private DecimalCollection decimalCollection;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void before() {
		this.decimalCollection = new DecimalCollection();
		this.decimalCollection.add(2.0);
		this.decimalCollection.add(-1.0);
		this.decimalCollection.add(3.0);
		this.decimalCollection.add(2.0);
	}

	@Test
	public void testDecimalCollection() {
		this.decimalCollection = new DecimalCollection();
		assertEquals(0, this.decimalCollection.size());
	}

	@Test
	public void testAdd() {
		assertEquals(4, this.decimalCollection.size());
	}

	@Test
	public void testSum() {
		assertEquals(6.0, this.decimalCollection.sum(), 10e-5);
	}

	@Test
	public void testSumArithmeticExceptionIfEmpty() {
		exception.expect(ArithmeticException.class);
		new DecimalCollection().sum();
	}

	@Test
	public void testHigher() {
		assertEquals(3.0, this.decimalCollection.higher(), 10e-5);
	}

	@Test
	public void testHigherArithmeticExceptionIfEmpty() {
		exception.expect(ArithmeticException.class);
		new DecimalCollection().higher();
	}

}
