package com.nagarro.nagp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import com.nagarro.nagp.domain.Category;
import com.nagarro.nagp.exception.InvalidRequestException;

@RunWith(PowerMockRunner.class)
public class InventoryResourceUnitTest {
	
	private InventoryResource inventoryResource;
	private Inventory fragileInventory;
	private Inventory durableInventory;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup(){
		inventoryResource= new InventoryResource();
		fragileInventory = new Inventory(Category.FRAGILE);
		durableInventory = new Inventory(Category.DURABLE);
	}
	
	@Test
	public void shouldCreateInventoryWhenFragileInventoryPassedAsArgument(){
		assertEquals(fragileInventory, inventoryResource.createInventory(fragileInventory));
	}
	
	@Test
	public void shouldCreateInventoryWhenDurableInventoryPassedAsArgument(){
		assertEquals(durableInventory, inventoryResource.createInventory(durableInventory));
	}
	
	@Test
	public void shouldGiveFalseWhenCreateDurableInvetoryMatchedWithFragile(){
		assertNotEquals(fragileInventory, inventoryResource.createInventory(durableInventory));
	}
	
	@Test
	public void shouldGiveFalseWhenCreateFragileInvetoryMatchedWithDurable(){
		assertNotEquals(durableInventory, inventoryResource.createInventory(fragileInventory));
	}
	
	@Test(expected = InvalidRequestException.class)
	public void shouldThrowExceptionWhenInventoryIsNull(){
		inventoryResource.createInventory(null);
	}
	
}
