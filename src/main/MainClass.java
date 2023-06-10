package main;

import java.text.ParseException;
import java.util.Scanner;

import dao.AccountDao;
import dto.AccountDto;

public class MainClass {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AccountDao dao = new AccountDao();
		
		
		
		boolean on = false;
		while(!on) {
			System.out.println("가계부를 입력하겠습니다.");
			System.out.println("1.가계부에 내용 추가하기");
			System.out.println("2.가계부에 내용 삭제하기");
			System.out.println("3.가계부에 내용 수정하기");
			System.out.println("4.가계부에 내용 검색하기");
			System.out.println("5.가계부 보기");
			System.out.println("6.가계부를 파일에 저장하기");
			System.out.println("7.가계부내역 불러오기");
			System.out.println("8.종료하기");
			System.out.println("(1~8)까지 입력해주세요");
			if (sc.hasNextInt()) {
				Integer inputNum = sc.nextInt();
				switch (inputNum) {
					case 1: 
						dao.insert();
						break;
					case 2: 
						dao.delete();
						break;
					case 3: 
						dao.update();
						break;
					case 4: 
						dao.select();
						break;
					case 5: 
						dao.all();
						break;
	//				case 6: 
	//					dao.insert();
	//					break;
	//				case 7: 
	//					dao.insert();
	//					break;
					case 8: 
						System.out.println("가계부를 종료합니다");
						on = true;
						break;
				
				default:
					System.out.println("숫자를 다시 입력해주세요(1~8)");
					break;
				}
			}
			else {
				String inputNum = sc.next();
				System.out.println("숫자를 입력하세요");
			}
		
		}
		
	}
	

}
