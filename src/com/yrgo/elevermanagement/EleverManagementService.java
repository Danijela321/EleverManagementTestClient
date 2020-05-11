package com.yrgo.elevermanagement;

import java.util.List;


import com.yrgo.domain.Elever;

/**
 * 
 * @author Danijela
 *
 */


public interface EleverManagementService {
	
	public void registerElever(Elever elever);
	public List<Elever>getAllElever ();
	public List<Elever>searchBysurname(String surname);

}
