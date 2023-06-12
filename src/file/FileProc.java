package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import dto.AccountDto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import singleton.Singleton;

public class FileProc {
	
	private File file = null;
	
	Scanner sc =new Scanner(System.in);
	public FileProc() {
	}
	// 파일 저장
	public void write() {
		
		try {
			System.out.println("저장할 파일이름을 적어주세요.");
			String fileName = sc.next();
			file = new File("c:\\tmp\\"+fileName+".txt");
			if(file.createNewFile()) {
				System.out.println("파일생성성공");
			}else {
				System.out.println("파일생성실패");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Singleton s = Singleton.getInstance();
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (int i = 0; i < s.accounList.size();i++) {
				AccountDto dto = s.accounList.get(i);
				pw.println(dto.print());
				pw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("파일 저장 완료");
	}
	
	// 파일 불러오기
	public void read() {
		System.out.println("불러올 파일이름을 적어주세요.");
		String fileName = sc.next();
		String filename = "c://tmp"+fileName+".txt";
		Singleton s = Singleton.getInstance();
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String str= "";
			
			while((str = br.readLine())!=null){
				String spilt[] =str.split("/");
				
				AccountDto dto = new AccountDto(spilt[0],spilt[1],spilt[2],Integer.parseInt(spilt[3]),spilt[4]);
				s.accounList.add(dto);
				System.out.println(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("불러오기 완료");
	}
}