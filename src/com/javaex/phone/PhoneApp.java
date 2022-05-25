package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PhoneDao phoneDao = new PhoneDao();

		System.out.println("******************************************");
		System.out.println("*            전화번호 관리 프로그램           *");
		System.out.println("******************************************");
		System.out.println("");

		
		boolean run = true;
		while (run) {
			System.out.println("");
			System.out.print("1.리스트    2.등록    3.수정    4.삭제    5.검색    6.종료");
			System.out.println("");
			System.out.println("------------------------------------------------");
			System.out.print(">메뉴번호: ");
			
			int num = sc.nextInt();
			sc.nextLine();
			
			switch (num) {
				//리스트
				case 1:
					System.out.println("<1.리스트>");
					
					List<PersonVo> phoneList = phoneDao.phoneSelect();
					for(int i = 0; i<phoneList.size(); i++) {
						
						PersonVo personVo = phoneList.get(i);
						System.out.println(personVo.getPersonId() + ". " + personVo.getName() + "  "
										   + personVo.getHp() + "  " + personVo.getCompany() );
						
					}
					break;
				
				//등록
				case 2:
					System.out.println("<2.등록>");
					
					System.out.print("이름 > ");
					String name = sc.next();
					
					System.out.print("휴대전화 > ");
					String hp = sc.next();
					
					System.out.print("회사번호 > ");
					String company = sc.next();
					
					PersonVo p = new PersonVo(name, hp, company);
					
					phoneDao.phoneInsert(p);
					break;
				
				//수정
				case 3:
					System.out.println("<3.수정>");
					
					System.out.print("번호> ");
					int personId = sc.nextInt();
					
					System.out.print("이름 > ");
					String rename = sc.next();
					
					System.out.print("휴대전화 > ");
					String rehp = sc.next();
					
					System.out.print("회사번호 > ");
					String recompany = sc.next();
					
					PersonVo rep = new PersonVo(personId, rename, rehp, recompany);
					
					phoneDao.phoneUpdate(rep);
					break;
				
				//삭제
				case 4:
					System.out.println("<4.삭제>");
					
					System.out.print("번호> ");
					int pdelete = sc.nextInt();
					
					phoneDao.phoneDelete(pdelete);
					break;
					
				//검색
				case 5:
					System.out.println("<5.검색>");				
					
					System.out.print("검색어 >");
					String serch = sc.nextLine();
					 
					phoneDao.phoneSerch(serch);
					List<PersonVo> sList = phoneDao.phoneSerch(serch);
					
					for(int i = 0; i<sList.size(); i++) {
						PersonVo personVo = sList.get(i);
						System.out.println(personVo.getPersonId() + ". " + personVo.getName() + "  "
										   + personVo.getHp() + "  " + personVo.getCompany() );
						
					}
					
					break;
					
				//종료
				case 6:
					System.out.println("<6.종료>");
					
					System.out.println("***************************************");
					System.out.println("*              감사합니다                *");
					System.out.println("***************************************");
					System.out.println("");
					
					run = false;
					break;
	
				default:
					System.out.println("[다시 입력해 주세요.]");
					
					break;
					
			}

		}

		sc.close();
	}

}

