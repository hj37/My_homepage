package jsoup;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	public static void main(String[] args) {
		String url = "https://www.koreabaseball.com/TeamRank/TeamRank.aspx";	//크롤링할 url지정 
		Document doc = null; //Document에는 페이지의 전체 소스가 저장된다.
	
	try {
		doc = Jsoup.connect(url).get();
		
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	
	//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
	//		==>원하는 값들이 들어있는 덩어리를 가져온다.
	
	Elements element = doc.select("table.tData");
	
	
	System.out.println("=================================================");
	
	//Iterator을 사용하여 하나씩 값 가져오기
    //덩어리안에서 필요한부분만 선택하여 가져올 수 있다.
	//클래스 이름이 점임 
    Iterator<Element> ie1 = element.select("th").iterator();

    Iterator<Element> ie2 = element.select("td").iterator();


    while (ie1.hasNext()) {

        System.out.print(ie1.next().text() +"\t");

    }
    System.out.println();
    while (ie2.hasNext()) {

        System.out.print(ie2.next().text() +"\t");

    }

	
	
	}
}
