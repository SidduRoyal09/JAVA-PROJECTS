package com.Projects;
import java.util.Scanner;
class Task{
	private String description;
	private boolean isCompleted;
	
	Task(String description){
		this.description=description;
	}
	String getDescription() {
		return description;
	}
	boolean isCompleted() {
		return this.isCompleted;
	}
	void markCompleted() {
		this.isCompleted=true;
	}
	public String toString() {
		return "Task Description="+this.description+"status="+this.isCompleted;
	}
}
class Taskmanager{
	Task task[];
	int taskCount;
	Taskmanager(int size){
		task=new Task[size];
	}
	void addTask(String description) {
		if(taskCount==task.length) {
			System.out.println("full");
		}else {
//			Task t=new Task(description);
			task[taskCount]=new Task(description);
			taskCount++;
			System.out.println("added");
		}
	}
	void markTaskCompleted(int index) {
		if(index<=taskCount) {
		task[index].markCompleted();
		System.out.println("status updated");
		}
	}
	void listPendingTask() {
		for(int i=0;i<task.length;i++) {
			if(task[i].isCompleted()==false) {
				System.out.println(task[i]);
			}
			if(task[i+1]==null) {
				break;
			}
		}
	}
	
	void listCompletedTask() {
		for(int i=0;i<task.length;i++) {
			if(task[i].isCompleted()==true) {
				System.out.println(task[i]);
			}
			if(task[i+1]==null) {
				break;
			}
		}
	}
	void listAllTask() {
		for(int i=0;i<taskCount;i++) {
			
				System.out.println(task[i]);
		}
	}
	void deleteTask(int position) {
		if(position<taskCount) {
			for(int i=position;i<=taskCount-1;i++) { 
				task[i]=task[i+1];
			}
			task[taskCount]=null;
		}
	}
	
} 
public class TaskManager1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Taskmanager tm=new Taskmanager(10);
		boolean exit=false;
		while(!exit) {
			System.out.println("1.add task");
			System.out.println("2.mark as complete");
			System.out.println("3.list of completed tasks");
			System.out.println("4.list of all tasks");
			System.out.println("5.list of incompleted/pending tasks");
			System.out.println("6.delete task");
			System.out.println("7.exit");
			System.out.print("select option: ");
			int op=sc.nextInt();
			sc.nextLine();
			switch(op) {
			case 1:
				System.out.println("enter your task info: ");
				String desc=sc.nextLine();
				tm.addTask(desc);
				break;
			case 2:
				System.out.println("enter index: ");
				int index=sc.nextInt();
				tm.markTaskCompleted(index);
				break;
			case 3:
				tm.listCompletedTask();
				break;
			case 4:
				tm.listAllTask();
				break;
			case 5:
				tm.listPendingTask();
				break;
			case 6:
				System.out.print("enter position : ");
				int position=sc.nextInt();
				tm.deleteTask(position);
				break;
			case 7:
				exit=true;
				break;
			}
			
		}
		sc.close();
	}

}
