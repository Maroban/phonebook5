package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	// 필드
	@Autowired
	private PhoneService phoneService;

	@Autowired
	private PhoneDao phoneDao;

	// 생성자

	// 메소드 - GS

	// 메소드 - 일반

	/*** 리스트 ***/
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("[PhoneController.list]");

		// PhoneList 가져오기
		List<PersonVo> personList = phoneDao.getPersonList();

		// model에 담기
		model.addAttribute("pList", personList);

		// Front Controller ==> list.jsp 포워드
		return "list";
	}

	/*** 등록 폼 ***/
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("[PhoneController.writeForm]");

		// Front Controller ==> wirteFOrm.jsp 포워드
		return "writeForm";
	}

	/*** 등록 ***/
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("[PhoneController.write]");

		// insert() 메소드 사용
		phoneDao.insert(personVo);

		System.out.println(personVo);

		// 리다이렉트
		return "redirect:/list";
	}

	/*** 등록 버전 2 ***/
	@RequestMapping(value = "/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam("company") String company) {

		// insert2() 메소드 사용
		phoneDao.insert2(name, hp, company);

		// 리다이렉트
		return "redirect:/list";
	}

	/*** 삭제 ***/
	@RequestMapping(value = "/delete/{person_id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@PathVariable("person_id") int person_id) {
		System.out.println("[PhoneController.delete]");

		// delete() 메소드 사용
		phoneDao.delete(person_id);

		// 리다이렉트
		return "redirect:/list";
	}

	/*** 수정 폼 ***/
	@RequestMapping(value = "/modifyForm/{person_id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@PathVariable("person_id") int person_id, Model model) {

		// 한사람 정보 가져오기
		PersonVo personVo = phoneService.getPerson(person_id);

		// model에 담기
		model.addAttribute("personVo", personVo);

		// modifyForm.jsp 포워드
		return "modifyForm";
	}

	/*** 수정 폼 버전 2 ***/
	@RequestMapping(value = "/modifyForm2/{person_id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm2(@PathVariable("person_id") int person_id, Model model) {

		// 한사람 정보 가져오기
		Map<String, Object> personMap = phoneDao.getPerson2(person_id);

		// model에 담기
		model.addAttribute("pMap", personMap);

		// modifyForm.jsp 포워드
		return "modifyForm2";
	}

	/*** 수정 ***/
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {

		// update() 메소드 사용
		phoneDao.update(personVo);

		// 리다이렉트
		return "redirect:/list";
	}

}
