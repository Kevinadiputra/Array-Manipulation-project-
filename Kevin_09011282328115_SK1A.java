import java.io.*;
import java.util.*;

public class Kevin_09011282328115_SK1A{

	static List<Data> dataList = new ArrayList<>();
	static boolean isRunning = true;
	static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	static BufferedReader input = new BufferedReader(inputStreamReader);

	static class Data {
		String name;
		int clas;
		double score;

		Data(String name, int clas, double score){
			this.name = name;
			this.clas = clas;
			this.score = score; 
		}
	}
	static void showMenu() throws IOException{
		System.out.println("========= MENU ==========");
		System.out.println("[1] Show All Data");
		System.out.println("[2] Insert Data");
		System.out.println("[3] Edit Data");
		System.out.println("[4] Delete Data");
		System.out.println("[5] Exit");
		System.out.println("CHOICE MENU: ");

		int selectedMenu = Integer.valueOf(input.readLine());

		switch (selectedMenu){
		case 1:
			showALLData();
			break;
		case 2:
			insertData();
			break;
		case 3:
			editData();
			break;
		case 4:
			deleteData();
			break;
		case 5:
			System.out.println("THANK YOU !!!");
			System.exit(0);
			break;
		default:
			System.out.println("WRONG CHOICE !!!!");		
		}
	}
	static void showALLData(){
		if(dataList.isEmpty()){
			System.out.println("No Data yet !!!");
		}else{
			for (int i =0;i < dataList.size(); i++){
				Data data = dataList.get(i);
				System.out.println(String.format("[%d] Nama: %s, Kelas: %d, Nilai: %.2f", i, data.name, data.clas, data.score));
			}
		}
	}
	static void	insertData() throws IOException{
		System.out.println("Name: ");
		String name = input.readLine();
		System.out.println("Class: ");
		int clas = Integer.parseInt(input.readLine());
		System.out.println("Score: ");
		double score = Double.parseDouble(input.readLine());

		Data data = new Data(name, clas, score);
		dataList.add(data);
	}
	static void editData() throws IOException {
		showALLData();
		System.out.println("Choose the data number: ");
		int indexData = Integer.valueOf(input.readLine());

		if(indexData <= 0 && indexData <dataList.size()){
			Data data = dataList.get(indexData);

			System.out.println("New Name: ");
			String newName = input.readLine();
			System.out.println("New Class: ");
			int newClass = Integer.parseInt(input.readLine());
			System.out.println("New score: ");
			double newScore = Double.parseDouble(input.readLine());

			data.name = newName;
			data.clas = newClass;
			data.score = newScore;


		}else{
			System.out.println("Invalid Data Number !!!");
		}
	}
	static void	deleteData() throws IOException {
		showALLData();
		System.out.println("Choose Data number: ");
		int indexData = Integer.valueOf(input.readLine());

		if(indexData>= 0 && indexData < dataList.size()){
			dataList.remove(indexData);
		}else{
			System.out.println("Invalid Data Number !!!");
		}
	}

	public static void main(String[] args) throws IOException{
		do{
			showMenu();
		}while (isRunning);
	}
}	