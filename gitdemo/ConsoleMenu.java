package com.ainosoft.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import com.ainosoft.menu.Action;
import com.ainosoft.menu.Menu;
import com.ainosoft.menu.MenuItem;

public class ConsoleMenu extends Menu {

	private int i;
	MenuItem temp = null;
	public ConsoleMenu(int choice, String description, Action action) {
		super(choice, description, action);
	}

	public ConsoleMenu(String description) {
		super(-1, description, null);
	}

	@Override
	public void selected(){
		
		
		if(getParent()==null){
			temp=new MenuItem(getCounter()+1,"Exit", new Action(){

				@Override
				public void executeAction() {
					System.out.println("Exited successfully...");
					System.exit(0);
					
				}
			});
			
		}
		else{
			
				temp=new MenuItem(getCounter(),"Go Back", new Action(){

					@Override
					public void executeAction() {
						getParent().selected();
					}
					});
							
		}
		System.out.println(""+temp.getChoice()+":"+temp.getDescription());
		
		for(MenuItem mi : menuItemSet){
			System.out.println(mi.getChoice()+":"+mi.getDescription());
			}
		
		ConsoleUtil cu=new ConsoleUtil(); 
		System.out.println("Enter Choice:-");
		i=cu.readInt();
		if(i==temp.getChoice()){
			
			temp.selected();
		}
		
		for(MenuItem mi : menuItemSet){
		if(mi.getChoice()==i){
		mi.selected();	
		}
		
		
	}
		selected();
	}
}
