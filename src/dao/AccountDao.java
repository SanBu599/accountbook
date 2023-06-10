package dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import dto.AccountDto;
import singleton.Singleton;

public class AccountDao {
	private Scanner sc = new Scanner(System.in);
	
	public AccountDao() {
		// TODO Auto-generated constructor stub
	}
	
	//추가
	
	public void insert() {		
		System.out.println("입력을 시작합니다.");
		System.out.println("날짜를 입력해주세요.");
		String date = sc.next();
		System.out.println("용도를 입력해주세요.");
		String purpose = sc.next();
		System.out.println("수입/지출 입력해주세요");
		String incomeSpending = sc.next();
		System.out.println("금액을 입력해주세요");
		Integer money = sc.nextInt();
		System.out.println("내용을 적어주세요");
		String memo = sc.next();
		
		Singleton s = Singleton.getInstance();
		s.accounList.add(new AccountDto(date, purpose, incomeSpending, money, memo));
	}
	
	//삭제
	public void delete() {
		System.out.println("삭제할 용도를 입력하세요");
		String purpose = sc.next();
		
		int index = select0(purpose);
		if(index==-1) {
			System.out.println("용도를 찾을 수 없습니다.");
			System.out.println("다시입력해주세요");
		}
		else {
			Singleton s = Singleton.getInstance();
			s.accounList.remove(index);
			System.out.println("삭제했습니다.");
		}
		
	}
	
	//수정
	public void update() {
		System.out.print("수정할 용도를 입력하세요 ");
		String purpose = sc.next();
		
		int index = select0(purpose);
		if(index == -1) {
			System.out.println("용도를 찾을 수 없습니다");
		}
		
		System.out.println("수정할 날짜:");
		String date =sc.next();
		System.out.println("수정할 용도:");
		String purpose1 = sc.next();
		System.out.println("수정할 수입/지출:");
		String incomeSpending =sc.next();
		System.out.println("수정할 금액:");
		Integer money = sc.nextInt();
		System.out.println("수정할 내용:");
		String memo = sc.next();
		
		Singleton s = Singleton.getInstance();
		AccountDto dto = s.accounList.get(index);
		dto.setDate(date);
		dto.setPurpose(purpose1);
		dto.setIncomeSpending(incomeSpending);
		dto.setMoney(money);
		dto.setMemo(memo);
		System.out.println("수정완료했습니다.");
		
	}
		
	//검색
	public void select()  {
		boolean on = false;
		while(!on) {
			System.out.println("검색할 내용은 아래와 같습니다");
			System.out.println("1.용도 검색하기");
			System.out.println("2.날짜 검색하기");
			System.out.println("3.월별 검색하기");
			System.out.println("4.기간별 검색하기");
			System.out.println("5.돌아가기");
			System.out.println("(1~5) 숫자를 입력해주세요.");
			
			if (sc.hasNextInt()) {
				Integer selNum = sc.nextInt();
				switch(selNum) {
					case 1:
						System.out.println("검색할 용도를 입력하세요");
						String sel1 = sc.next();
						select1(sel1);
						break;
					case 2:
						System.out.println("검색할 날짜를 입력하세요");
						String day = sc.next();
						select2(day);
						break;
					case 3:
						System.out.println("검색할 월을 입력하세요");
						String month = sc.next();
						select3(month);
						break;
					case 4:
						System.out.println("검색할 기간을 입력하세요");
						select4();
						break;
					case 5:
						on = true;
						break;
					default:
							System.out.println("숫자를 다시 입력해주세요(1~5)");
							break;
				}
			}
			else {
				String selNum = sc.next();
				System.out.println("숫자를 입력해주세요");
			}
		}
	}
	//용도검색 정확버전
	public int select0(String purpose){
		
		Singleton s = Singleton.getInstance();
		int index = -1;
		for (int i = 0; i < s.accounList.size(); i++) {
			if(s.accounList.contains(purpose)==true) {
				System.out.println(s.accounList.get(index));
				break;
			}
		}
		return index;
	}
	//용도검색 유사버전
	public void select1(String purpose) {
		
		int index = -1;
		Singleton s = Singleton.getInstance();	
		for(int i = 0;i<s.accounList.size();i++) {
			AccountDto dto = s.accounList.get(i);
			if(dto.getPurpose().contains(purpose)) {
				System.out.println(dto);
			}
			else {
				System.out.println("찾는 용도가 없습니다.");
			}
		
		}
		
	}
	//날짜검색
	public void select2(String day){
		Calendar cal = Calendar.getInstance();
		Singleton s = Singleton.getInstance();
		for(int i = 0;i<s.accounList.size();i++) {
			
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date parsedDate = dateFormat.parse();
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		String day = dayFormat.format(parsedDate);
		}
	}
	//월별검색
	public void select3(String month) {
		Calendar cal = Calendar.getInstance();
		Singleton s = Singleton.getInstance();
		
		for(int i = 0;i<s.accounList.size();i++) {
			AccountDto dto = s.accounList.get(i);
			String date = dto.getDate();
			
		}
		
	}
	//기간별검색
	public void select4(){
		
	}	
	
	//모두보기
	public void all() {
		Singleton s = Singleton.getInstance();
		if(s.accounList.isEmpty()) {
			System.out.println("입력된 값이 없습니다.");
			return;
		}
		for (int i = 0; i < s.accounList.size(); i++) {
			System.out.println(s.accounList.get(i).toString());
		}
	}
	
}
