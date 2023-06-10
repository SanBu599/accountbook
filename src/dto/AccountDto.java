package dto;

import java.text.SimpleDateFormat;

public class AccountDto {
	private String Date;
	private String Purpose;
	private String IncomeSpending;
	private Integer Money;
	private String Memo;
	
	public AccountDto() {
		// TODO Auto-generated constructor stub
	}

	public AccountDto(String date, String purpose, String incomeSpending, Integer money, String memo) {
		super();
		Date = date;
		Purpose = purpose;
		IncomeSpending = incomeSpending;
		Money = money;
		Memo = memo;
	}

	public String getDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일"); 
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getPurpose() {
		return Purpose;
	}

	public void setPurpose(String purpose) {
		Purpose = purpose;
	}

	public String getIncomeSpending() {
		return IncomeSpending;
	}

	public void setIncomeSpending(String incomeSpending) {
		IncomeSpending = incomeSpending;
	}

	public Integer getMoney() {
		return Money;
	}

	public void setMoney(Integer money) {
		Money = money;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	@Override
	public String toString() {
		return "날짜=" + Date + ", 용도=" + Purpose + ", 수입/지출=" + IncomeSpending + ", 금액="
				+ Money + ", 메모=" + Memo;
	}

	
	
	
}

