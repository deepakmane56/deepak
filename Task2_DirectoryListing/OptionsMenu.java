package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class OptionsMenu {
	
	//reference to pojo of telephone records
	private ArrayList<Records> myList = new ArrayList<Records>();

	public OptionsMenu(){
        Scanner in = new Scanner(System.in);
        String providedOption;
        
        // Display the menu
        do{
	        System.out.println("1\t Add Record");
	        System.out.println("2\t Delete Record");
	        System.out.println("3\t Search Record");
	        System.out.println("4\t Edit Record");
	        System.out.println("5\t Display Record");
	        System.out.println("6\t Exit");
	        System.out.print("Please enter your choice:");
	        providedOption = in.nextLine();
	        
	        if(providedOption.equals("1")){
	        	addRecord();
	        }else if(providedOption.equals("2")){
	        	deleteRecord();
	        }else if(providedOption.equals("3")){
	        	searchRecord();
	        }else if(providedOption.equals("4")){
	        	editRecord();
	        }else if(providedOption.equals("5")){
	        	displayRecord();
	        }
        
        } while (providedOption.equals("6") == false);
	}
	
	private void addRecord(){
		// scanner for user input
		String myData1, myData2, myData3;
		Scanner addMe = new Scanner(System.in);
		
		System.out.print("Please enter first name:");
        myData1 = addMe.nextLine();
		
        System.out.print("Please enter last name:");
        myData2 = addMe.nextLine();
		
        System.out.print("Please enter telephone number:");
        myData3 = addMe.nextLine();
        
        if(myData1.isEmpty() || myData2.isEmpty() || myData3.isEmpty()){
        	System.out.println("please provide the data for all 3 fields!");
        }else{
        
	        //reference to records object to set their values
	        Records lst = new Records();
			lst.setFirstName(myData1);
			lst.setLastName(myData2);
	        lst.setTelNumber(myData3);
			//adding it to arraylist object
			myList.add(lst);
			
			System.out.println("New record has been added!\n");
        }
         
//		Records lst = new Records();
//		lst.setFirstName("deepak");
//		lst.setLastName("mane");
//		lst.setTelNumber("1234");
//		//adding it to arraylist object
//		myList.add(lst);
//		// display of records
//		for(Records show:myList){
//			System.out.println(show.toString());
//		}
		
	}// end of addRecord method
	
	private void deleteRecord(){
		// scanner for user input
		String myData1;
		Scanner delMe = new Scanner(System.in);
		System.out.print("To delete a record, Please provide first name or phone number:");
        myData1 = delMe.nextLine();
        if(myData1.isEmpty()){
        	System.out.println("please provide the value!");
        }else{
        	
//    		for (Records temp : myList) {
//    			//System.out.println(temp);
//    			if(temp.getFirstName().equals(myData1)){
//    				//System.out.println("fnmatch");
//    				myList.remove(myData1);
//    			}else if(temp.getTelNumber().equals(myData1)){
//    				//System.out.println("fnmatch");
//    				myList.remove(myData1);
//    			//}else{
//    			//	System.out.println("No match record found!");
//    			}
//    		}// end of for loop
    		
//    		ArrayList<String> arrStr = new ArrayList<String>();
//    	    for (int i = 0; i < myList.size(); i++) {
//    	        Records student = myList.get(i);
//    	        if (arrStr.contains(student.getFirstName())) {
//    	        	myList.remove(i);
//    	            i--;
//    	        //} else {
//    	            System.out.println("Else Called");
//    	        }
//    	    }

    		for (int i=0; i< myList.size(); i++){
    			if(myList.get(i).getFirstName().equals(myData1)){
    				//System.out.println(i);
    				myList.remove(i);
    				System.out.println("Record has been deleted!");
    				//displayRecord();
    			}else if(myList.get(i).getTelNumber().equals(myData1)){
    				//System.out.println(i);
    				myList.remove(i);
    				System.out.println("Record has been deleted!");
    				//displayRecord();
    			}// end of if loop
    		}// end of for loop
        }//end of if loop

	}// end of delete record method
	 
	private void searchRecord(){
		// scanner for user input
		String myData1;
		Scanner srchMe = new Scanner(System.in);
		System.out.print("To search a record, Please provide a value:");
        myData1 = srchMe.nextLine();
        if(myData1.isEmpty()){
        	System.out.println("please provide the value!");
        }else{		
		
    		for (int i=0; i< myList.size(); i++){
    			if(myList.get(i).getFirstName().equals(myData1) ||
    				myList.get(i).getLastName().equals(myData1) ||
    				myList.get(i).getTelNumber().equals(myData1) ){
    				//System.out.println(i);
    				displayRecord();
    				System.out.println("Found matching data!");
    				//displayRecord();
    			}else{
    				System.out.println("Matching data not found!");
    			}// end of if loop
    		}// end of for loop
        }//end of if loop		
		
		
		
	}// end of search record method
	
	private void editRecord(){
		// scanner for user input
		String myData1, myData2;
		Scanner editMe1 = new Scanner(System.in);
		System.out.print("To change a phone number, please provide the existing phone number:");
        myData1 = editMe1.nextLine();
        if(myData1.isEmpty()){
        	System.out.println("please provide the existing phone number!");
        }else{
        	Scanner editMe2 = new Scanner(System.in);
        	System.out.print("Now please provide a new phone number:");
        	myData2 = editMe2.nextLine();
        	if(myData2.isEmpty()){
		        System.out.println("please provide the new phone number!");
        	} else {
	    		for (int i=0; i< myList.size(); i++){
    				//if(myList.get(i).getTelNumber().equals(myData1)){
	    			if(myList.get(i).getTelNumber().equals(myData1)){
    					//System.out.println(i);
	    				
	    			    for(Records person:myList) {
	    			        if(person.getTelNumber().equals(myData1)) {
	    			            //person.setName("ChangedJuned");
	    			            //person.setAddress("Hola-lulu");
	    			            person.setTelNumber(myData2);
	    			        }
	    			    }	    				
	    				
//    					Records rec2 = new Records();
//    					rec2.setFirstName(myList.get(i).getFirstName());
//    					rec2.setLastName(myList.get(i).getLastName());
//    					rec2.setTelNumber(myList.get(i).getTelNumber());
//    					
//    					//myList.add(int i, myData2);
//    					//myList.set(i, myData2); 
//    					//myList.setTelNumber();
//    					
//    					//rec2.set(i, myData2).setTelNumber();
    					
	    				System.out.println("Record has been edited!");
//    					displayRecord();

    				//}else{
    				//	System.out.println("No such telephone number exist!");
    					
    				}// end of if loop
    			}// end of for loop
        	}// end of if loop 
        }//end of if loop		
	}// end of edit record method
	
	private void displayRecord(){
		if(myList.size()==0){
			System.out.println("No records to display!");
		}

		//sort by Last name  
        Collections.sort(myList, new Comparator() {  
            @Override  
            public int compare(Object obj1, Object obj2) {  
            	Records rec1 = (Records)obj1;  
            	Records rec2 = (Records)obj2;  
                return rec1.getLastName().compareToIgnoreCase(rec2.getLastName());  
            }  
        });
        //Now sorted based on last name  		
 
        // display of records
        for(Records show:myList){
        	System.out.println(show.toString());
        }
	}// end of displayRecord method	

	public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // Display the menu
//        System.out.println("1\t Insert Phone Number");
//        System.out.println("2\t Delete Phone Number");
//        System.out.println("3\t Find Phone Number");
//        System.out.println("4\t Edit Phone Number");
//        System.out.println("5\t Print Phone Numbers");
//        System.out.println("6\t Exit");
//        System.out.println("Please enter your choice:");
//        //Get user's choice
//        int choice = in.nextInt();
//        //Display the title of the chosen module
//        switch (choice) {
//            case 1: System.out.println("insert"); 
//            		break;
//            case 2: System.out.println("delete");
//                    break;
//            case 3: System.out.println("find"); 
//                    break;
//            case 4: System.out.println("edit"); 
//                     break;
//            case 5: System.out.println("print"); 
//            		break;
//            case 6: System.out.println("exit"); 
//    				break;
//            default: System.out.println("Invalid choice");
//            		break;  
//        }//end of switch

		new OptionsMenu();
        
	}// end of main method
}// end of class

