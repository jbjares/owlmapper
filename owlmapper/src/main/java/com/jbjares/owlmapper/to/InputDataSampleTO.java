package com.jbjares.owlmapper.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InputDataSampleTO implements Serializable{

	private static final long serialVersionUID = -8625681303748340213L;


	private List<SpreadDeathTO> spread_deaths = new ArrayList<SpreadDeathTO>();
	
	public List<SpreadDeathTO> getSpread_deaths() {
		return spread_deaths;
	}
	public void setSpread_deaths(List<SpreadDeathTO> spread_deaths) {
		this.spread_deaths = spread_deaths;
	}
	
	
}
