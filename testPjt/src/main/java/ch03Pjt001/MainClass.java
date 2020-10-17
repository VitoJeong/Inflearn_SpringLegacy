package ch03Pjt001;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		TransportationWalk transportationWalk = new TransportationWalk();
//		transportationWalk.move();
		
		// classpath아래의 xml파일의 내용을 통해 container를 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		
		// id에 해당하는 객체를 원하는 데이터 타입으로 가져오겠다.
		TransportationWalk transportationWalk = ctx.getBean("tWalk", TransportationWalk.class);
		transportationWalk.move();
		
		ctx.close();
		
	}
	
}
