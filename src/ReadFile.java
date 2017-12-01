import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	private static final String FILENAME = "src/Prog32758Students.txt";

	public static void main(String[] args) {

		BufferedReader br = null;
		FileReader fr = null;


		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				String[] ar= sCurrentLine.split(",");
				String last = ar[0];
				String first = ar[1];
				String group = ar[2];
				System.out.println(first);
				System.out.println(last);
				System.out.println(group);
				MySQLAccess.InitDB(first,last,group);
				
			}
			Admin_Second.main(null);
			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}