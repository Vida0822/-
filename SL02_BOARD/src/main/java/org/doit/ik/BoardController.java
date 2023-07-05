package org.doit.ik;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("> /board/list GET...");
		model.addAttribute("list", this.boardService.getList());
	}
	
	@GetMapping("/register")
	public void register(Model model) {
		log.info("> /board/register GET...");
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) { // request.getParameter 자동 적용
		log.info("> /board/register POST...");
		this.boardService.register(board);
		// board.getBno();
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list"; // response.sendRedirect
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("> /board/get or /board/modify GET...");
		model.addAttribute("board", this.boardService.get(bno));
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("> /board/remove GET...");
		if (this.boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");			
		} // if
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) { // request.getParameter 자동 적용
		log.info("> /board/modify POST...");
		if (this.boardService.modify(board)) {	
			rttr.addFlashAttribute("result", "success");
		}
		return String.format("redirect:/board/get?bno=%d",board.getBno()); // response.sendRedirect
		// return "redirect:/board/get?bno="+board.getBno(); // response.sendRedirect
		// return "redirect:/board/list";
	}
	
}
