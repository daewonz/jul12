package com.ddww.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/* controller = 이제 흐름을 제어합니다.
 * 
 * 
 * 
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/* Controller			= 흐름제어
 * 						= 컨트롤 기능을 하는 인스턴스
 * 						= 사용자의 요청이 들어오면 해당 URL에 맞는
 * 						  페이지와 데이터를 보내줍니다.
 * 
 * Service				= Controller와 DB사이에 놓여질 프로그램 로직
 * 
 * DTO/VO				= 맨날 만들던 DTO
 * DAO					= 데이터베이스와 연결되어서 작업합니다. => mybatis를 DAO가 불러들여서 일을 시키면
 * 																   마이바티스가 일해서 준 값을 다시 서비스에게 주고
 * 																   서비스는 그걸 컨트롤러에게 줍니다.
 * 																 
 * DTO/VO/DAO : 모델 
 * 
 * 사용자 -> 컨트롤러 -> 서비스 -> DAO -> mybatis -> DB	--------------┐
 * 사용자 <- JSP+DB <- 컨트롤러 <- 서비스 <- DAO <- mybatis <- DB-----┘	
 * 
 * 연결하는법
 * 1. @Autowired = 스프링에서 제공, 타입이 일치하는 녀석을 연결
 * 2. @Inject	 = 자바에서 제공, 타입이 일치하는 녀석을 연결
 * 3. @Resource	 = 자바에서 제공, 이름이 일치하는 녀석을 연결
 * 
 * 
 * 
 * 스프링 기술
 * 
 * POJO	(Plain Old Java Object) 
 * 		어려운 코딩하는 것이 아니라 간단하게 코딩하기
 * 
 * 1. 	DI(Dependency Injection) 의존 주입
 * 			프레임워크가 객체의 의존성 주입을 담당합니다. == IoC
 * 
 * 
 * 2.	IoC(Inversion of Control) 제어 역전
 * 			프레임워크가 권한을 가져갑니다. ex) Autowired
 * 			자바가 객체를 생성하고 서로 연결하고 사용하는데
 * 			이러한 기술을 IoC컨테이너가 관리, 서비스 해줍니다.
 * 			IoC컨테이너는 객체의 생성/초기화/서비스/소멸 -->(라이프사이클)
 * 						  라이프 사이클을 관리합니다.
 * 
 * 
 * 3.	AOP(Aspect Oriented Programming) 관점지향 프로그래밍
 * 			객체지향과 다른 개념. 각 객체마다 중복되는 작업들이 있다면
 * 			해당 중복 작업을 기준으로 동일 행동을 하게 만드는 것.
 * 			메소드가 실행되기 전, 실행된 직후, 시행시점에 따라 따로 기능을 
 * 			적용 시키는 것.
 */



@Controller
public class BoardController {
	//서비스와 연결하기 = Autowired
	@Autowired
	private BoardService boardService;

	
	
	//사용자의 어떤 요청이 들어오면 어떤 일을 하겠습니다.
	@RequestMapping(value = "/main")
		public String main() {//위 문장과 연결되어서 /main이라는 요청이 오면
		return "main"; //jsp 파일명		//아래 해당 jsp 파일을 열어줍니다.	
	}
	
	@GetMapping("/board")
	public ModelAndView board() {
		//model이라고 선언을 해주면 값을 보낼 수 있습니다.
		//모델이 데이터베이스에서 온 값을 붙여서 보내는 역할입니다.
		ModelAndView mv = new ModelAndView("board");
		mv.addObject("name", "홍길동");
		return mv;
		//모델과 뷰를 한번에 붙여서 보내는 작업입니다.
	}
	
	
	
}
