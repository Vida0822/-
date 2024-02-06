package org.doit.ik.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCard {
	

	private File file ; 
	private DetailCategory detailCategory ; 
	private Member member ; 
	private Project project ; 
	private int ach_rate;
	private int paySum;
	private int left_days;
	
	
}
