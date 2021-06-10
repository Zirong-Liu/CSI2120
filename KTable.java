/* Student Name: Zirong Liu
 * Student Number: 300048614
 */

package KnapsackProblem;

import java.util.ArrayList;
/**
 * this class is use to indicate the tables which are used by dynamic method
 *
 */
public class KTable {
	 /** the row of table  */
	public int row; //the row of table;
	 /** the col of table  */
	public int col; //the col of table;
	 /** using the knapsack to initial the table */
	public Knapsack knapsack; //using the knapsack to initial the table
	 /** the table recording the value */
	public int[][] value; //the table recording the value
	 /** he table recording the items of maxValue */
	public ArrayList<Item>[][] name;//the table recording the items of maxValue
	
	 /** 
     * initial the two array
     * @param knapsack,using the knapsack to initial the row and col of tables
     */
	public KTable(Knapsack knapsack){     //initial the two array
		this.knapsack=knapsack;
		value=new int[knapsack.count+1][knapsack.totalweight+1];
		name=new ArrayList[knapsack.count+1][knapsack.totalweight+1];
	}
	
	 /** 
     * Dynamic programming to calculate the max value
     */
	public void DynamicProgramming(){     //Dynamic programming to calculate the max value;
		for(int i=0;i<=knapsack.totalweight;i++){     //initial the tables by the first row
			value[0][i]=0;
			name[0][i]=new ArrayList();
    	}
		for(int i=0;i<=knapsack.count;i++){ //initial the tables by the first col
			value[i][0]=0;
			name[i][0]=new ArrayList();
    	}
		
		//Using dynamic method to fill in the table
		for(int i=1;i<=knapsack.count;i++)
    		for(int j=1;j<=knapsack.totalweight;j++){
    			if(knapsack.Items.get(i-1).getWeight()>j){
    				value[i][j]=value[i-1][j];
    				name[i][j]=(ArrayList<Item>) name[i-1][j].clone();
    			}
    			else{
    				if(value[i-1][j]>=knapsack.Items.get(i-1).getValue()+value[i-1][j-knapsack.Items.get(i-1).getWeight()]){
    					value[i][j]=value[i-1][j];
        				name[i][j]=(ArrayList<Item>) name[i-1][j].clone();
    				}	
    				else{
    					value[i][j]=knapsack.Items.get(i-1).getValue()+value[i-1][j-knapsack.Items.get(i-1).getWeight()];
    					name[i][j]=(ArrayList<Item>) name[i-1][j-knapsack.Items.get(i-1).getWeight()].clone();
    					name[i][j].add(knapsack.Items.get(i-1));
    					
    				}
    			}
    		}
		    knapsack.setFinalItems(name[knapsack.count][knapsack.totalweight]);  //update the result
	}	
}
