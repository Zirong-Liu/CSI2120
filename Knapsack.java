/* Student Name: Zirong Liu
 * Student Number: 300048614
 */

package KnapsackProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * this class is use to indicate the knapsack,which can contain many  item 
 *
 */

public class Knapsack {
	 /** the total nums of the items  */
     public int  count;//the total nums of the items;
     /** the maxweight of the Knapsack  */
     public int totalweight; //the maxweight of the Knapsack;
     /** all of the Items  */
     public ArrayList<Item> Items; //all of the Items
     /** the Items that cab be put in  */
     public ArrayList<Item> FinalItems; //the Items that cab be put in
     
   
     /** 
      * initial the Knapsack by reading file
      * @param fileName,the filename which to be read
      */
     public Knapsack(String fileName){   //initial the Knapsack by reading file;
    	 Items=new ArrayList();
    	 FinalItems=new ArrayList();
    	 readFile(fileName);
     }
     
     /** 
      * set the items that cab be put in finally
      * @param finalItems,the list of tehe items which to be put finally
      */
     public void setFinalItems(ArrayList<Item> finalItems) {
		FinalItems = finalItems;
     }

     /** 
      * reading the configuration file
      * @param fileName,the filename which to be read
      */
	private void readFile(String fileName) {
		// TODO Auto-generated method stub
		try { 
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			this.count=Integer.parseInt(line);  //the first line is the number of the items
		    for(int i=0;i<count;i++){
		    	String[] str = br.readLine().split(" "); //Analyze the attributes of each item
		    	Item item=new Item(str[0],Integer.parseInt(str[2]),Integer.parseInt(str[1]));
		    	Items.add(item);
		    }
		    this.totalweight=Integer.parseInt(br.readLine());    	
		    br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 

    /** 
     * show the final result including the maxValue and the name of the items
     */
	public void show(){
		int sumValue=0;   //the variable of the max value
		String itemsName=""; //the variable of the items name that be put into
		for(int i=0;i<FinalItems.size();i++){   //traverse list
			sumValue=sumValue+FinalItems.get(i).getValue();
			itemsName=itemsName+" "+FinalItems.get(i).getName();
		}
		System.out.println(sumValue);
		System.out.println(itemsName.trim());
	}
}
