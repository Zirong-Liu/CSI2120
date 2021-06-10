/* Student Name: Zirong Liu
 * Student Number: 300048614
 */

package KnapsackProblem;

import java.util.ArrayList;


/**
 * this main class is use to start the program and select the corresponding method
 *
 */


public class KnapsackProblem {
	 /** 
     * the method to invoke brute Force method
     * @param knapsack,the knapsack which put item into it
     * @param Items,all items which ready to be put in
     * @param ItemsPath,record one way of select
     * @param index, current item's index
     * @param currentWeight,current weight of knapsack
     */
	//the method to invoke brute Force method
	private  void bruteForce(Knapsack knapsack,ArrayList<ArrayList<Item>> Items,ArrayList<Item> ItemsPath,int index,int currentWeight) {
		// TODO Auto-generated method stub
		if(index>=knapsack.count){     //out of the max index,return
            ArrayList<Item> Plist=(ArrayList<Item>) ItemsPath.clone();
            Items.add(Plist);
            return;
        }
		 //No. index is put into bag 
		if(currentWeight+knapsack.Items.get(index).getWeight()<=knapsack.totalweight)
         {
			 ItemsPath.add(knapsack.Items.get(index));
			 bruteForce(knapsack,Items,ItemsPath,index+1,currentWeight+knapsack.Items.get(index).getWeight());
			 ItemsPath.remove(ItemsPath.size()-1);  //Backtracking
         }
		 
		//No. index is not put into bag 
		 bruteForce(knapsack,Items,ItemsPath,index+1,currentWeight);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String filename=args[0];
        String mode=args[1];
        if(mode.equals("F")){    //brute force method
        	KnapsackProblem kp=new KnapsackProblem();
        	Knapsack knapsack=new Knapsack(filename);
        	ArrayList<ArrayList<Item>> Items= new ArrayList();  //all the possible plans
        	ArrayList<Item> ItemsPath= new ArrayList();  //one path of the possible plans
        	kp.bruteForce(knapsack,Items,ItemsPath,0,0);
        	int maxValue=0;
        	int maxIndex=0;
        	for(int i=0;i<Items.size();i++){
        		int value=0;
        		ArrayList<Item> path=Items.get(i);
        		for(int j=0;j<path.size();j++){
        			value=value+path.get(j).getValue();
        		}
        		if(value>=maxValue){
        			maxValue=value;
        			maxIndex=i;
        		}
        	}
        	knapsack.setFinalItems(Items.get(maxIndex));
        	knapsack.show();
        }
        if(mode.equals("D")){    //dynamic programming method
        	KnapsackProblem kp=new KnapsackProblem();
        	Knapsack knapsack=new Knapsack(filename);
        	KTable kt=new KTable(knapsack);
        	kt.DynamicProgramming(); //the method to invoke dymastic  method
        	knapsack.show();
        }
	}
}
