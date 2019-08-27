package com.nagarro.nagp.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.nagarro.nagp.Inventory;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RepositoryHelper.class)
public class FragileInventoryRepositoryUnitTest {

	@InjectMocks
	private static FragileInventoryRepository fragileInventoryRepository;
	
	@Mock
	Inventory inventory;
	
	@Test 
	public void shouldSaveFragile() throws Exception {
		
		PowerMockito.mockStatic(RepositoryHelper.class);
		PowerMockito.doNothing().when(RepositoryHelper.class , "saveFragile", inventory);
		
		RepositoryHelper.saveFragile(inventory);
		PowerMockito.verifyStatic(VerificationModeFactory.times(1));
	}
}
