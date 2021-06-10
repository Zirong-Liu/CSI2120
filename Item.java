/* Student Name: Zirong Liu
 * Student Number: 
 */

package KnapsackProblem;


/**
 * this class is use to indicate the items which are put into knapsack 
 *
 */
public class Item {
	/** the name of item  */
	public String name;//the name of item
	/** the weight of the item */
    public int weight; //the weight of the item
	/** the value of the item  */
    public int value; //the value of the item
	
    /** 
    * constructor using all of the fields
    * @param name,the name of item
    * @param weight,the weight of item
    * @param value,the value of item
    */
    //constructor using all of the fields
    public Item(String name, int weight, int value) {
		super();
		this.name = name;
		this.weight = weight;
		this.value = value;
	}
    
    /** 
     * return the name of item
     * @return the name of item
     */
    //return the name of item
    public String getName() {
		return name;
	}
   
    /** 
     * return the weight of item
     * @return the weight of item
     */
    //return the weight of item
	public int getWeight() {
		return weight;
	}
	
	 /** 
     * return the value of item
     * @return the value of item
     */
	//return the value of item
	public int getValue() {
		return value;
	}
    
}
