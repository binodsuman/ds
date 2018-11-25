package com.song;

public class Node {
  protected String title, duration;
  protected Node next, prev;
  
  public Node(){
	  next = null;
	  prev = null;
	  title = "";
	  duration = "";
  }

	public Node(String title, String duration, Node next, Node prev) {
		super();
		this.title = title;
		this.duration = duration;
		this.next = next;
		this.prev = prev;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Node getLinkNext() {
		return next;
	}

	public void setLinkNext(Node next) {
		this.next = next;
	}

	public Node getLinkPrev() {
		return prev;
	}

	public void setLinkPrev(Node prev) {
		this.prev = prev;
	}
  
  
  
}
