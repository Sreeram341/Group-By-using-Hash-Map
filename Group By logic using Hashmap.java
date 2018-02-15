
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GDL {

	public static File InputFile = new File(
			"C:\\FinalSource.txt");

	public GDL() throws FileNotFoundException {

		Read_Data();

	}

	public void Read_Data() throws FileNotFoundException {

		TreeMap<String, Integer> BetFileMap = new TreeMap<String, Integer>();

		Scanner scanner = new Scanner(InputFile);

		while (scanner.hasNext()) {
			String DATE = null, VALUE = null;

			String Value = scanner.next().toString();

			String[] FinalValue = Value.split(",");

			String DT = FinalValue[0];
			
			DATE = DT.substring(DT.indexOf("-") + 1, DT.indexOf("-") + 3);

			VALUE = FinalValue[1];

			if (BetFileMap.containsKey(DATE)) {
				int new_val = BetFileMap.get(DATE) + Integer.parseInt(VALUE);

				BetFileMap.remove(DATE);

				BetFileMap.put(DATE, new_val);

			} else {

				BetFileMap.put(DATE, Integer.parseInt(VALUE));

			}

		}

		scanner.close();

		SortHashmap(BetFileMap);
	}

	public void SortHashmap(TreeMap<String, Integer> betFileMap) {

		Set<Entry<String, Integer>> FileSet = betFileMap.entrySet();
		
		ArrayList<Integer> MapVal=new ArrayList<Integer>();
		
		ArrayList<Integer> KeyVal=new ArrayList<Integer>();
		
		for(Entry<String, Integer> files : FileSet)
		{ 
			//System.out.println(files.getKey() + " ==> " + files.getValue());
			KeyVal.add(Integer.parseInt(files.getKey()));
			
			MapVal.add(files.getValue());
		}
		GroupBy(KeyVal,MapVal);
	}
	
	public TreeMap<String, String> GroupBy(ArrayList<Integer> KV,ArrayList<Integer> MV) {
		
		TreeMap<String, String> SortedTM = new TreeMap<String,String>();
		
		ArrayList<String> Months = new ArrayList<String>();
		
		Months.add("FF");
		Months.add("Janua");
		Months.add("February");
		Months.add("March");
		Months.add("April");
		Months.add("May");
		Months.add("June");
		Months.add("July");
		Months.add("August");
		Months.add("September");
		Months.add("October");
		Months.add("November");
		Months.add("December");

		
		for (int i=1;i<MV.size();i++)
		{
			if(MV.get(i)>MV.get(i-1))
			{
				//System.out.format("\n%s,%s",KV.get(i),"Increase");
				
				SortedTM.put(Months.get(KV.get(i)),"Increase");
			}
			else
			{
				//System.out.format("\n%s,%s",KV.get(i),"Decrease");
				SortedTM.put(Months.get(KV.get(i)),"Decrease");
			}
		}
		
		System.out.println(SortedTM);
		
		return SortedTM;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		GDL gd = new GDL();

	}

}
