package exectionsample.run;

import java.util.regex.Pattern;

import exectionsample.SampleException;

public class MainRun {
	public static void main(String[] args) throws SampleException {

		//기준 문서(유형)
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-1234-1234";
		
		String regExp2= "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String data2 = "chanhok95@naver.com";
		
		
		
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		result=Pattern.matches(regExp2, data2);
		System.out.println(result);
		
		if (args.length == 0) {
			throw new SampleException("오류나버렸네");

		} else {
			args[0] = "test";
			System.out.println(args[0]);
		}
	}
}
