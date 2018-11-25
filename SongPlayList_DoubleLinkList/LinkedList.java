package com.song;

public class LinkedList {

	protected Node start, end;
	int size;
	
	public void addSong(String t, String dur){
		Node newNode = new Node(t, dur, null, null);
		if(start == null){
			start = newNode;
			end = start;
		}else{
			Node ptr = start;
			  while(ptr.getLinkNext() != null){
				 ptr = ptr.getLinkNext();
			  }
			 ptr.setLinkNext(newNode); 
			
		}
		 size++;
	}
	
	public int findSong(String t){
	  Node ptr = start;
	  for(int i = 1; i <= size; i++){
		  if(t.equalsIgnoreCase(ptr.getTitle())){
			  return i;
		  }
		  ptr = ptr.getLinkPrev();
	  }
	  return 0;
	}
	
	public String getSongAtPos(int pos){
		Node ptr = start;
		for(int i = 1; i <= size; i++){
			if(i == pos){
				return ptr.getTitle();
			}
		  ptr = ptr.getLinkNext();	
		}
	   return null;	
	}
	
	public void sortList(){
		String swapTitle, swapDuration;
		Node ptr = start;
		for(int i =1; i<=size; i++){
			for(int j = i+1; j<=size; j++){
				if(ptr.getTitle().compareTo(ptr.getLinkNext().getTitle()) > 0){
					 swapTitle = ptr.getTitle();
					 swapDuration = ptr.getDuration();
					 ptr.setTitle(ptr.getLinkNext().getTitle());
					 ptr.setDuration(ptr.getLinkNext().getDuration());
					 ptr.getLinkNext().setTitle(swapTitle);
					 ptr.getLinkNext().setDuration(swapDuration);
				}
				ptr = ptr.getLinkNext();
			}
		}
	}
	
	public void deleteAtPos(int pos){
		if(pos == 1 ){
			System.out.println("Deleting song at position "+ pos + ": " + end.getTitle());
			start = null;
			end = null;
			size = 0;
			return;
		}
 	  if (pos == size)
	   {
		System.out.println("Deleting song at position "+ pos + ": " + end.getTitle());
		end = end.getLinkPrev();
		end.setLinkNext(null);
		size--;
	  }
	  Node ptr = start.getLinkNext();
	  for(int i = 2; i<= size; i++){
		  if(i == pos){
			  System.out.println("Deleting song at position "+ pos + ": " + end.getTitle());
			  Node p = ptr.getLinkPrev();
			  Node n = ptr.getLinkNext();
			  
			  p.setLinkNext(n);
			  n.setLinkPrev(p);
			  size--;
			  return;
		  }
		  ptr = ptr.getLinkNext();
	  }
	
	}
	
	public void display(){
	  System.out.println("\nPlaylist currently contains "+size +" song(s)\n");
	  if(size == 0){
		  System.out.println("Empty\n");
		  return;
	  }
	  if(start.getLinkNext() == null){
		  System.out.println("1. "+start.getTitle() +" <" + start.getDuration()+">");
		  return;
	  }
	  Node ptr = start;
	  int counter = 1;
	  while(ptr != null){
		  System.out.println(counter+". "+ptr.getTitle() +" <" + ptr.getDuration()+">");
		  counter++;
		  ptr = ptr.getLinkNext();
	  }
	}
	
	public int getSize(){
		return size;
	}

}
