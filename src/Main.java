import java.net.MalformedURLException;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		Test t_test = new Test();
		/*send the deviceName,appPackage and appActivity*/
		t_test.f_test1("Huawei P9", "com.example.mbacallado.firstexample", ".MainActivity");
	}
	

}
