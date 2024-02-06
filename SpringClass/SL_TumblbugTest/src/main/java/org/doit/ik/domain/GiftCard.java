package org.doit.ik.domain;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftCard {
	// 필드 
	private Gift gift ; 
	private int buyAmount ; 
	private int leftAmount ; 
	private int gift_min ; 
	private String gift_desc ; 
	private ArrayList<ItemSet> items ;


	
}
