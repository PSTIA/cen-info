package org.cen.robot.match.strategy.test;

import static org.junit.Assert.*;

import org.cen.cup.cup2013.robot.match.ElementsName2013;
import org.cen.cup.cup2013.robot.match.TargetsFactory2013;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Strategy2013Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TargetsFactoryTest() {
		TargetsFactory2013ForTest tf = new TargetsFactory2013ForTest(null);
		assert(tf.getTargets()!=null);
	
	}
	
	@Test
	public void CherryNameTest() {
		assert(ElementsName2013.CHERRY_1.equals("Cherry1"));
		assert(ElementsName2013.CHERRY_2.equals("Cherry2"));
		assert(ElementsName2013.CHERRY_3.equals("Cherry3"));
		assert(ElementsName2013.CHERRY_4.equals("Cherry4"));
		assert(ElementsName2013.CHERRY_5.equals("Cherry5")); 
		}
	@Test
	public void GiftNameTest() {
		assert(ElementsName2013.GIFT_1.equals("Gift1"));
		assert(ElementsName2013.GIFT_2.equals("Gift2"));
		assert(ElementsName2013.GIFT_3.equals("Gift3"));
		assert(ElementsName2013.GIFT_4.equals("Gift4"));
	
	}
	@Test
	public void GlassNameTest() {
		assert(ElementsName2013.GLASS_1.equals("GLASS_1"));
		assert(ElementsName2013.GLASS_2.equals("GLASS_2"));
		assert(ElementsName2013.GLASS_3.equals("GLASS_3"));
		assert(ElementsName2013.GLASS_4.equals("GLASS_4"));
		assert(ElementsName2013.GLASS_5.equals("GLASS_5"));
		assert(ElementsName2013.GLASS_6.equals("GLASS_6"));
		assert(ElementsName2013.GLASS_7.equals("GLASS_7"));
		assert(ElementsName2013.GLASS_8.equals("GLASS_8"));
		assert(ElementsName2013.GLASS_9.equals("GLASS_9"));
		assert(ElementsName2013.GLASS_10.equals("GLASS_10"));
		assert(ElementsName2013.GLASS_11.equals("GLASS_11"));
		assert(ElementsName2013.GLASS_12.equals("GLASS_12"));
	
	}
	

}
