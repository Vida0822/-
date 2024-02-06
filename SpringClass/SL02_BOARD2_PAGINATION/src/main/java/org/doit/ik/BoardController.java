package org.doit.ik;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.PageDTO;
import org.doit.ik.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;
 
	/*  // 페이징 처리 안된 컨트롤 메서드 
	@GetMapping("/list")
	public void list( Model model ) {
		log.info("> /board/list get...");
		model.addAttribute("list", this.boardService.getList()) ;
	}
	*/
	
	// 페이징 처리가 된 컨트롤 메서드 
	@GetMapping("/list")
	public void list( Criteria criteria,   Model model ) {
		// 여기서 파라미터로 선언해준것만으로도 Criteria 객체 생성
		// => 기본 생성자 (1,5) 적용 <-> 처음 목록 요청했을 때 : 현재 페이지 1 / 한페이지에 출력되는 게시글 수 5 (pageNum, amount 값이 넘어가지 않으니까 ) 
		log.info("> /board/list get...");
		model.addAttribute("list", this.boardService.getListWithPage(criteria)) ;
		int total = this.boardService.getTotal(criteria);
		// < 1 [2] 3 4 5  > -> PageDTO 클래스 선언
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
	}

	@GetMapping("/register")
	public void register(  ) {
		log.info("> /board/register get...");
	}

	@PostMapping("/register")
	public String register( BoardVO board , RedirectAttributes rttr ) { // 일회성 속성값
		log.info("> /board/register get...") ;
		this.boardService.register(board);
		// board.getBno()
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	 //      /board/get?bno=5
	//       /board/modify?bno=5
	//      /board/get?pageNum=2&amount=5&bno=2
	@GetMapping( { "/get" , "/modify" } )
	public void get( @RequestParam("bno") Long bno
													, @ModelAttribute("criteria") Criteria criteria
													, Model model) {
		log.info("> /board/get or /modify get...");
		model.addAttribute("board", this.boardService.get(bno));
		// model.addAttribute("criteria", criteria );
	}
	
	@GetMapping("/remove")
	public String remove( @RequestParam("bno") Long bno, @ModelAttribute("criteria") Criteria criteria, RedirectAttributes rttr)           {
		log.info("> /board/remove get..." + bno);
		if( this.boardService.remove(bno) ) {
			rttr.addFlashAttribute("result", "success");
		} // if

		rttr.addFlashAttribute("pageNum", criteria.getPageNum() );
		rttr.addFlashAttribute("amount", criteria.getAmount());
		
		return "redirect:/board/list"+criteria.getListLink();
	}
	
	@PostMapping("/modify")
	public String modify( BoardVO board , @ModelAttribute("criteria") Criteria criteria, RedirectAttributes rttr ) { // 일회성 속성값
		log.info("> /board/modify post...");
		if( this.boardService.modify(board) ) { 
			rttr.addFlashAttribute("result", "success");
		} 
		rttr.addFlashAttribute("pageNum", criteria.getPageNum() );
		rttr.addFlashAttribute("amount", criteria.getAmount());
		
	    return "redirect:/board/list"+criteria.getListLink();
		//return String.format("redirect:/board/list?bno=%d", board.getBno());
	}
	
	
	
	
 
}
