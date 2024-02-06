package org.doit.ik.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum; // 현재페이지 번호
	private int amount; // 한 페이지에 출력할 게시글 수
	private int pageBlock; // 한 번에 출력할 페이지 번호
	
	private String type; // 검색 조건
	private String keyword; // 검색어
	
	public Criteria() {
		this(1, 5, 5);
	}

	public Criteria(int pageNum, int amount, int pageBlock) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.pageBlock = pageBlock;
	}
	
	public String getListLink(BoardVO board) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
			.queryParam("pageNum", this.pageNum)
			.queryParam("amount", this.amount)
			.queryParam("bno", board.getBno())
			.queryParam("type", this.type)
			.queryParam("keyword", this.keyword);
		return builder.toUriString();
	}
	
	// "TW".split("")
	// "T", "W"
	public String[] getTypeArr() {
		return type == null ? new String[] {} : this.type.split("");
	}
	
}
