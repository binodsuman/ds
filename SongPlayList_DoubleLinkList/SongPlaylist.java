package com.song;
import java.util.Scanner;

public class SongPlaylist {

	 public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String title, duration;
		
		LinkedList list = new LinkedList();
		System.out.println("Song List List");
		char ch;
		
		do{
			System.out.println("\nPlaylist Operations\n");
			System.out.println("1 Add a Song to the playlist");
			System.out.println("2 Delete a song from the playlist");
			System.out.println("3 Find a song by name");
			System.out.println("4 Next track / Previous track");
			System.out.println("5 Sort playlist by song title");
			System.out.println("6 Display playlist");
			System.out.println("7 Exit");
						
			System.out.println("\nEnter Menu Option:");
			int choice = input.nextInt();
			input.nextLine();
			ch = 'Y';
			
			switch(choice){
			case 1 :
				System.out.println("Enter Song Title");
				title = input.nextLine();
				System.out.println("Enter Song duration");
				duration = input.nextLine();
				list.addSong(title,  duration);
				System.out.println("\nAdded the song '"+title +"' to the playlist");
				break;
			case 2 :
				System.out.println("Enter Track Number");
				int p = input.nextInt();
				if (p < 1 || p > list.getSize()){
					System.out.println("Track number does not exist\n");
				}else{
					list.deleteAtPos(p);
				}
				break;
			case 3:
				System.out.println("Enter the Name of the song: ");
				String findTitle = input.nextLine();
				int position = list.findSong(findTitle);
				if (position ==0 )
					System.out.println("The song '"+findTitle +"' does not exist");
				else
					System.out.println("The song '"+findTitle +"' is present at position "+position);
				break;
			case 4:
				System.out.println("Enter a track number to start from:");
				int pos = input.nextInt();
				if(pos < 1 || pos > list.getSize())
					System.out.println("Invalid track\n");
				else{
					String songName = list.getSongAtPos(pos);
					System.out.println("Current Song is "+ pos + ". "+songName);
					char fbe;
					do{
						System.out.println("Enter n for Next Track, p for Previous and e for exit from this menu");
						fbe = input.next().charAt(0);
						
						if(pos == 1 & fbe == 'p')
							System.out.println("Already at first song. Cannot go back");
						else if(pos == list.getSize() & fbe == 'n')
							System.out.println("Alread at last song. Cannot go further");
						else if(fbe == 'n'){
							songName = list.getSongAtPos(pos+1);
							System.out.println("Current Song is "+ (pos+1) +". "+ songName);
							pos++;
						}
						else if (fbe == 'p'){
							songName = list.getSongAtPos(pos - 1);
							System.out.println("Current Song is "+ (pos -1) + ". "+ songName);
							pos--;
						}
					}while (fbe != 'e');
				}	
				break;
			case 5:
				list.sortList();
				System.out.println("Sorted playlist by song titles");
				list.display();
				break;
			case 6:
				list.display();
				break;
			case 7:
				ch = 'N';
				break;
			default:
				System.out.println("Wrong Entry \n");
				break;
			}	
		}while(ch != 'N');
		
	}
}
